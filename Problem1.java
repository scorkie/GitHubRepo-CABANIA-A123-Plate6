/*
Anikka Cabania A123 
1. Write a java program that receives a list of edges of a simple graph,
the program should determine whether it is connected
and find the number of connected components if it is not connected
*/

import java.util.*;

public class Problem1 {
    
    private static class GraphCabania {
        private final int verticesCabania;
        private final List<List<Integer>> adjListCabania;
        
        public GraphCabania(int vertices) {
            this.verticesCabania = vertices;
            adjListCabania = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjListCabania.add(new ArrayList<>());
            }
        }
        
        public void addEdge(int srcCabania, int destCabania) {
            adjListCabania.get(srcCabania).add(destCabania);
            adjListCabania.get(destCabania).add(srcCabania);
        }
        
        public int getVerticesCabania() {
            return verticesCabania;
        }
        
        public List<Integer> getAdjList(int vertexCabania) {
            return adjListCabania.get(vertexCabania);
        }
    }
    
    private static void dfs(GraphCabania graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : graph.getAdjList(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
    
    public static boolean isConnected(GraphCabania graph) {
        boolean[] visitedCabania = new boolean[graph.getVerticesCabania()];
        dfs(graph, 0, visitedCabania);
        for (boolean v : visitedCabania) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    
    public static int numberOfConnectedComponents(GraphCabania graph) {
        boolean[] visitedCabania = new boolean[graph.getVerticesCabania()];
        int countCabania = 0;
        for (int i = 0; i < graph.getVerticesCabania(); i++) {
            if (!visitedCabania[i]) {
                dfs(graph, i, visitedCabania);
                countCabania++;
            }
        }
        return countCabania;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int verticesCabania = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int edgesCabania = scanner.nextInt();
        
        GraphCabania graph = new GraphCabania(verticesCabania);
        
        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edgesCabania; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }
        
        if (isConnected(graph)) {
            System.out.println("The graph is connected.");
        } else {
            int components = numberOfConnectedComponents(graph);
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + components);
        }
        scanner.close();
    }
}
