class Solution {
    // Tree with directed graph will only have ONE vertex has 0 indegree and multiple outdegree. 
    // Other vertices will have exactly 1 indegree and 1 or 0 outdegree.
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // Tree will have n - 1 edges, and there is one more redundant edge.
        // So the number of vertices is the length of input edges
        final int n = edges.length;
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];
        final Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new HashSet<>());
        }
        int edgeTo = -1;
        for (final int[] edge : edges) {
            outdegree[edge[0]]++;
            indegree[edge[1]]++;
            if (indegree[edge[1]] > 1) {
                edgeTo = edge[1];
            }
            adjList.get(edge[0]).add(edge[1]);
        }
        
        int[] res = null;
        if (edgeTo != -1) {
            int root = -1;
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) root = i;
            }
            
            for (int i = n - 1; i >= 0; i--) {
                if (edges[i][1] == edgeTo) {
                    if (tryDeleteEdge(edges[i][0], edges[i][1], root, adjList)) {
                        res = edges[i];
                        break;
                    }
                }
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                int v = edges[i][0];
                int w = edges[i][1];
                if (outdegree[w] - 1 != 0) {
                    res = edges[i];
                }
            }
        }
        return res;
    }
    
    private boolean tryDeleteEdge(final int v, final int w, final int root, final Map<Integer, Set<Integer>> adjList) {
        final Set<Integer> visited = new HashSet<>();
        dfs(root, v, w, adjList, visited);
        return visited.size() == adjList.size();
    }
    
    private void dfs(int v, int from, int to, Map<Integer, Set<Integer>> adjList, Set<Integer> visited) {
        visited.add(v);
        for (final int adj : adjList.get(v)) {
            if (!visited.contains(adj) && (v != from || adj != to)) {
                dfs(adj, from, to, adjList, visited);
            }
        }
        
    }
}
