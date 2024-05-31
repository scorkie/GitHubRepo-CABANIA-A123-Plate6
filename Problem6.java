/*
Anikka Cabania A123 
6. Write a java program that receives the vertex pairs associated to the edges of a graph, the program should construct an
adjacency matrix for the graph. (Produce a version that works when loops, multiple edges, or directed edges are present.)
*/

import java.util.*;

public class Problem6 {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Problem6(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int fromVertex, int toVertex) {
        // Increment the count of edges between fromVertex and toVertex
        adjacencyMatrix[fromVertex][toVertex]++;
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        
        Problem6 graph = new Problem6(numVertices);

        System.out.println("Enter the edges (enter -1 -1 to stop):");
        while (true) {
            int fromVertex = scanner.nextInt();
            int toVertex = scanner.nextInt();
            
            if (fromVertex == -1 && toVertex == -1) {
                break;
            }
            
            if (fromVertex < 0 || fromVertex >= numVertices || toVertex < 0 || toVertex >= numVertices) {
                System.out.println("Invalid edge. Please enter valid vertex indices.");
                continue;
            }
            
            graph.addEdge(fromVertex, toVertex);
        }
        
        graph.printAdjacencyMatrix();
        
        scanner.close();
    }
}
