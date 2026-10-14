class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;
    public boolean validTree(int n, int[][] edges) {
        graph = new ArrayList<>();
        if (n - 1 != edges.length)
            return false;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];

        if (hasCycle(0, -1))
            return false;

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    private boolean hasCycle(int node, int parent) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (neighbour == parent)
                continue;
            if (visited[neighbour])
                return true;
            if (hasCycle(neighbour, node))
                return true;
        }
        return false;
    }
}
