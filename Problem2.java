/*
Anikka Cabania A123 
2. Write a java program that accepts an adjacency matrix of a graph.
The program should list the edges of this graph and give
the number of times each edge appears.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of vertices
        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();
        
        // Input the adjacency matrix
        int[][] adjacencyMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        
        // Map to store the edges and their counts
        Map<String, Integer> edgeCount = new HashMap<>();
        
        // Process the adjacency matrix to find edges
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCount.put(edge, adjacencyMatrix[i][j]);
                }
            }
        }
        
        // Output the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println("Edge: " + entry.getKey() + ", Count: " + entry.getValue());
        }
        
        scanner.close();
    }
}