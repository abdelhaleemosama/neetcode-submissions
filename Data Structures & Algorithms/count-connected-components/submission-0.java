class Solution {

    private List<List<Integer>> graph;
    private boolean[] visited;

    public int countComponents(int n, int[][] edges) {

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        return count;

    }

    private void dfs(int node){
        if (visited[node]) return;
        visited[node] = true;
        for(int neighbor: graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
}
