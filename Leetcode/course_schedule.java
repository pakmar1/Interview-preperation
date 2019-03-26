class Solution {
    // 1. Represent prerequisites as a map of edges
    // 2. Run dfs to check for cycles
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] edge : prerequisites) {
            edges.putIfAbsent(edge[0], new ArrayList<>());
            edges.get(edge[0]).add(edge[1]);
        }

        int[] state = new int[numCourses]; // 0, unvisited, 1 visiting, 2 visited
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, edges, state)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int i, Map<Integer,List<Integer>> edges, int[] state) {
        if (state[i] == 2) {
            return false;
        }

        if (state[i] == 1) {
            return true;
        }

        state[i] = 1;
        if (edges.containsKey(i)) {
            for (int child : edges.get(i)) {
                if (hasCycle(child, edges, state)) {
                    return true;
                }
            }
        }
        state[i] = 2;
        return false;
    }
}
