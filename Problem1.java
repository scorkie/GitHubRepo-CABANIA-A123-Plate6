/*
Anikka Cabania A123 
1. Write a java program that receives a list of edges of a simple graph,
the program should determine whether it is connected
and find the number of connected components if it is not connected
*/

import java.util.*;

public class Problem1 {
    
    private static class Graph {
        private final int vertices;
        private final List<List<Integer>> adjList;
        
        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }
        
        public void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        
        public int getVertices() {
            return vertices;
        }
        
        public List<Integer> getAdjList(int vertex) {
            return adjList.get(vertex);
        }
    }
    
    private static void dfs(Graph graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int neighbor : graph.getAdjList(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
    
    public static boolean isConnected(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        dfs(graph, 0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    
    public static int numberOfConnectedComponents(Graph graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        int count = 0;
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int edges = scanner.nextInt();
        
        Graph graph = new Graph(vertices);
        
        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) {
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
    }
}