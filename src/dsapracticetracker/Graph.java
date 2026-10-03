package dsapracticetracker;

import java.util.Scanner;

/*
 * Question:
 * Write a Java program to implement a Graph using an adjacency matrix.
 *
 * Operations:
 * 1. Add Edge
 * 2. Display Graph
 * 3. BFS Traversal
 * 4. DFS Traversal
 * 5. Exit
 */

public class Graph {

    int[][] graph;
    int vertices;

    // Constructor
    Graph(int vertices) {
        this.vertices = vertices;
        graph = new int[vertices][vertices];
    }

    // Add an edge
    void addEdge(int source, int destination) {

        graph[source][destination] = 1;
        graph[destination][source] = 1; // Undirected graph
    }

    // Display adjacency matrix
    void display() {

        System.out.println("\nAdjacency Matrix:");

        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }

            System.out.println();
        }
    }

    // BFS Traversal
    void BFS(int start) {

        boolean[] visited = new boolean[vertices];

        int[] queue = new int[vertices];

        int front = 0;
        int rear = 0;

        queue[rear++] = start;
        visited[start] = true;

        System.out.print("BFS: ");

        while (front < rear) {

            int current = queue[front++];

            System.out.print(current + " ");

            for (int i = 0; i < vertices; i++) {

                if (graph[current][i] == 1 && !visited[i]) {

                    queue[rear++] = i;
                    visited[i] = true;
                }
            }
        }

        System.out.println();
    }

    // DFS Traversal
    void DFS(int current, boolean[] visited) {

        visited[current] = true;

        System.out.print(current + " ");

        for (int i = 0; i < vertices; i++) {

            if (graph[current][i] == 1 && !visited[i]) {

                DFS(i, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        Graph g = new Graph(vertices);

        int choice;

        do {

            System.out.println("\n===== GRAPH =====");
            System.out.println("1. Add Edge");
            System.out.println("2. Display Graph");
            System.out.println("3. BFS Traversal");
            System.out.println("4. DFS Traversal");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter source vertex: ");
                    int source = sc.nextInt();

                    System.out.print("Enter destination vertex: ");
                    int destination = sc.nextInt();

                    if (source >= 0 && source < vertices &&
                        destination >= 0 && destination < vertices) {

                        g.addEdge(source, destination);

                        System.out.println("Edge added.");

                    } else {

                        System.out.println("Invalid vertex.");
                    }

                    break;

                case 2:

                    g.display();

                    break;

                case 3:

                    System.out.print("Enter starting vertex: ");
                    int startBFS = sc.nextInt();

                    if (startBFS >= 0 && startBFS < vertices) {
                        g.BFS(startBFS);
                    } else {
                        System.out.println("Invalid vertex.");
                    }

                    break;

                case 4:

                    System.out.print("Enter starting vertex: ");
                    int startDFS = sc.nextInt();

                    if (startDFS >= 0 && startDFS < vertices) {

                        boolean[] visited = new boolean[vertices];

                        System.out.print("DFS: ");
                        g.DFS(startDFS, visited);
                        System.out.println();

                    } else {

                        System.out.println("Invalid vertex.");
                    }

                    break;

                case 5:

                    System.out.println("Exiting...");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}