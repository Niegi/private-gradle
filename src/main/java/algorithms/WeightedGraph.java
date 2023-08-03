package algorithms;

import java.util.*;

class WeightedGraph {
  private int vertices;
  private List<Edge>[] adjList;

  static class Edge {
    int destination;
    int weight;

    Edge(int destination, int weight) {
      this.destination = destination;
      this.weight = weight;
    }
  }

  // Constructor to initialize the graph
  public WeightedGraph(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList[vertices];
    for (int i = 0; i < vertices; i++) {
      adjList[i] = new ArrayList<>();
    }
  }

  // Add a weighted edge between two vertices
  public void addEdge(int source, int destination, int weight) {
    adjList[source].add(new Edge(destination, weight));
    adjList[destination].add(new Edge(source, weight)); // For undirected graph
  }

  // Dijkstra's algorithm implementation
  public void dijkstra(int startVertex) {
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
    int[] distances = new int[vertices];
    Arrays.fill(distances, Integer.MAX_VALUE);

    pq.add(new Node(startVertex, 0));
    distances[startVertex] = 0;

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int vertex = current.vertex;

      for (Edge edge : adjList[vertex]) {
        int newDistance = distances[vertex] + edge.weight;
        if (newDistance < distances[edge.destination]) {
          distances[edge.destination] = newDistance;
          pq.add(new Node(edge.destination, newDistance));
        }
      }
    }

    // Print shortest distances or perform other tasks
    System.out.println("Shortest distances from vertex " + startVertex + " to all other vertices:");
    for (int i = 0; i < vertices; i++) {
      System.out.println("Vertex " + i + ": " + distances[i]);
    }
  }

  static class Node {
    int vertex;
    int distance;

    Node(int vertex, int distance) {
      this.vertex = vertex;
      this.distance = distance;
    }
  }

  public static void main(String[] args) {
    int vertices = 12;
    WeightedGraph graph = new WeightedGraph(vertices);

    // Adding weighted edges between vertices
    graph.addEdge(0, 1, 3);
    graph.addEdge(0, 2, 100);
    graph.addEdge(0, 3, 1);
    graph.addEdge(1, 4, 50);
    graph.addEdge(2, 5, 2);
    graph.addEdge(2, 6, 9);
    graph.addEdge(3, 7, 4);
    graph.addEdge(4, 8, 5);
    graph.addEdge(5, 9, 2);
    graph.addEdge(6, 9, 4);
    graph.addEdge(7, 10, 3);
    graph.addEdge(8, 11, 4);
    graph.addEdge(9, 11, 1);
    graph.addEdge(10, 11, 7);

    graph.dijkstra(0); // Starting from vertex 0
  }
}
