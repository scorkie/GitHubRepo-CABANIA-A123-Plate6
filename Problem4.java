/*
Anikka Cabania A123 
4. Write a java program, given the pair of vertex associated to 
the edges of an undirected graph, it will output the degree of
vertex.
*/

import java.util.*;

public class Problem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Map to store the degree of each vertex
        Map<Integer, Integer> degreeMap = new HashMap<>();
        
        System.out.println("Enter the number of edges:");
        int numberOfEdges = scanner.nextInt();
        
        System.out.println("Enter the edges (pair of vertices):");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            
            // Update the degree of vertex1
            degreeMap.put(vertex1, degreeMap.getOrDefault(vertex1, 0) + 1);
            
            // Update the degree of vertex2
            degreeMap.put(vertex2, degreeMap.getOrDefault(vertex2, 0) + 1);
        }
        
        // Output the degree of each vertex
        System.out.println("Degree of each vertex:");
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " has degree " + entry.getValue());
        }
        
        scanner.close();
    }
}
