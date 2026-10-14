class Solution {
    private List<List<Integer>> graph;
    private int[] state;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph  = new ArrayList<>();

        for(int i = 0; i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }

        state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs( int course){
        if (state[course] == 1) {
            return false;
        }

        if (state[course] == 2) {
            return true;
        }

        state[course] = 1;

        for(int child : graph.get(course)){
            if(!dfs(child)){
                return false;
            }
        }
        state[course] = 2;
        return true;
    }
}
