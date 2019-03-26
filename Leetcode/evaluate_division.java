class Solution {
    // Model binary relationship as graph
    // a / b = 2.0 can be represented as a --- 2.0 ---> b and b --- 0.5 ---> a
    // Node: variables
    // Edge: division result
    // Let # equations be N, let # variables be M. It takes O(N) to build and O(N + M) to store graph. It takes O(M) to query graph 
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] answer = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Set<String> visited = new HashSet<>();
            answer[i] = search(graph, queries[i][0], queries[i][1], visited);
            if (answer[i] != -1.0) {
                graph.get(queries[i][0]).put(queries[i][1], answer[i]);
            }
        }
        return answer;
    }

    private Map<String, Map<String, Double>> buildGraph(String[][] equations, double[] values) {
        Map<String, Map<String, Double>> g = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            g.putIfAbsent(a, new HashMap<>());
            g.putIfAbsent(b, new HashMap<>());

            g.get(a).put(b, values[i]);
            g.get(b).put(a, 1.0 / values[i]);
        }
        return g;
    }

    private double search(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        visited.add(start);

        for (String child : graph.get(start).keySet()) {
            if (!visited.contains(child)) {
                double result = search(graph, child, end, visited);
                if (result == -1.0) {
                    continue;
                }
                // Multiply all edge values
                return graph.get(start).get(child) * result;
            }
        }
        return -1;
    }
}
