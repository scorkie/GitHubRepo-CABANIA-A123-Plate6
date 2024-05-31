/*
Anikka Cabania A123 
7. Write a java program that accepts vertex pairs associated to the edges of an undirected graph and the number of times
each edge appears. The program should construct an incidence matrix for the graph.
*/

import java.util.*;

public class Problem7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        int[][] incidenceMatrix = new int[numVertices][numEdges];
        int[] edgeCounts = new int[numEdges];

        Map<String, Integer> edgeIndexMap = new HashMap<>();
        int currentEdgeIndex = 0;

        System.out.println("Enter the edges (vertex1 vertex2 count): ");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt() - 1; // convert to zero-indexed
            int vertex2 = scanner.nextInt() - 1; // convert to zero-indexed
            int count = scanner.nextInt();

            String edgeKey = Math.min(vertex1, vertex2) + "-" + Math.max(vertex1, vertex2);

            if (!edgeIndexMap.containsKey(edgeKey)) {
                edgeIndexMap.put(edgeKey, currentEdgeIndex++);
            }

            int edgeIndex = edgeIndexMap.get(edgeKey);
            incidenceMatrix[vertex1][edgeIndex] = count;
            incidenceMatrix[vertex2][edgeIndex] = count;
            edgeCounts[edgeIndex] += count;
        }

        System.out.println("\nIncidence Matrix: ");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < currentEdgeIndex; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
