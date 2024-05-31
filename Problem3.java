/*
Anikka Cabania A123 
3. Write a java program that will determine if a graph has a cycle or not.
*/

import java.util.*;

public class Problem3 {
    private final int vertices;
    private final List<List<Integer>> adjacencyList;

    public Problem3(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    private boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recStack) {
        if (recStack[vertex]) {
            return true;  // There is a cycle.
        }

        if (visited[vertex]) {
            return false;  // No cycle found here.
        }

        visited[vertex] = true;
        recStack[vertex] = true;

        List<Integer> children = adjacencyList.get(vertex);
        for (Integer child : children) {
            if (isCyclicUtil(child, visited, recStack)) {
                return true;
            }
        }

        recStack[vertex] = false;  // Remove the vertex from recursion stack.
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        Problem3 graph = new Problem3(vertices);

        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        scanner.close();

        if (graph.isCyclic()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph doesn't contain a cycle");
        }
    }
}
