/*
Anikka Cabania A123 
8. Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices.
*/

import java.util.Scanner;

public class Problem8 {

    // Check if two graphs are isomorphic
    public static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;
        
        if (n != graph2.length) {
            return false; // Graphs must have the same number of vertices
        }

        // Permutations array to try all possible mappings
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }

        return isIsomorphic(graph1, graph2, permutation, 0);
    }

    // Recursively try all permutations
    private static boolean isIsomorphic(int[][] graph1, int[][] graph2, int[] permutation, int index) {
        int n = graph1.length;

        if (index == n) {
            return checkIsomorphism(graph1, graph2, permutation);
        }

        for (int i = index; i < n; i++) {
            swap(permutation, i, index);
            if (isIsomorphic(graph1, graph2, permutation, index + 1)) {
                return true;
            }
            swap(permutation, i, index); // backtrack
        }

        return false;
    }

    // Check if the current permutation of vertices makes the graphs isomorphic
    private static boolean checkIsomorphism(int[][] graph1, int[][] graph2, int[] permutation) {
        int n = graph1.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph1[i][j] != graph2[permutation[i]][permutation[j]]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Utility function to swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graphs: ");
        int n = scanner.nextInt();

        int[][] graph1 = new int[n][n];
        int[][] graph2 = new int[n][n];

        System.out.println("Enter the adjacency matrix for the first graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the adjacency matrix for the second graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        if (areIsomorphic(graph1, graph2)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        scanner.close();
    }
}
