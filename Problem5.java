/*
Anikka Cabania A123 
5. Write a java program that receives a list of edges of a simple graph and determine whether the graph is bipartite.
*/

import java.util.*;

public class Problem5 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Reading number of edges
        System.out.println("Enter the number of edges:");
        int edgesCount = scanner.nextInt();
        
        // Reading edges
        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges (as pairs of space-separated integers):");
        for (int i = 0; i < edgesCount; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }
        
        // Building the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        // Checking if the graph is bipartite
        boolean isBipartite = isBipartite(graph);
        System.out.println("The graph is " + (isBipartite ? "bipartite" : "not bipartite"));
        
        scanner.close();
    }

    private static boolean isBipartite(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> colors = new HashMap<>();
        
        for (int node : graph.keySet()) {
            if (!colors.containsKey(node)) {
                // Start BFS/DFS from this node
                if (!isBipartiteFromNode(graph, node, colors)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private static boolean isBipartiteFromNode(Map<Integer, List<Integer>> graph, int start, Map<Integer, Integer> colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors.put(start, 0); // Start coloring with color 0
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = colors.get(node);
            
            for (int neighbor : graph.get(node)) {
                if (!colors.containsKey(neighbor)) {
                    // Assign opposite color to neighbor
                    colors.put(neighbor, 1 - currentColor);
                    queue.add(neighbor);
                } else if (colors.get(neighbor) == currentColor) {
                    // If neighbor has the same color, then the graph is not bipartite
                    return false;
                }
            }
        }
        
        return true;
    }
}
