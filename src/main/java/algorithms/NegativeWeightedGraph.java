package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NegativeWeightedGraph {

  private int vertices;
  private List<Edge> edges;

  static class Edge {
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }
  }

  // Constructor to initialize the graph
  public NegativeWeightedGraph(int vertices) {
    this.vertices = vertices;
    edges = new ArrayList<>();
  }

  // Add a weighted edge between two vertices
  public void addEdge(int source, int destination, int weight) {
    edges.add(new Edge(source, destination, weight));
  }

  // Bellman-Ford algorithm implementation
  public void bellmanFord(int startVertex) {
    int[] distances = new int[vertices];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[startVertex] = 0;

    // Relaxing edges for (V-1) iterations
    for (int i = 0; i < vertices - 1; i++) {
      for (Edge edge : edges) {
        if (distances[edge.source] != Integer.MAX_VALUE && distances[edge.source] + edge.weight < distances[edge.destination]) {
          distances[edge.destination] = distances[edge.source] + edge.weight;
        }
      }
    }

    // Checking for negative weight cycles
    for (Edge edge : edges) {
      if (distances[edge.source] != Integer.MAX_VALUE && distances[edge.source] + edge.weight < distances[edge.destination]) {
        System.out.println("Graph contains a negative weight cycle.");
        return;
      }
    }

    // Print shortest distances or perform other tasks
    System.out.println("Shortest distances from vertex " + startVertex + " to all other vertices:");
    for (int i = 0; i < vertices; i++) {
      System.out.println("Vertex " + i + ": " + distances[i]);
    }
  }

  public static void main(String[] args) {
    int vertices = 12;
    NegativeWeightedGraph graph = new NegativeWeightedGraph(vertices);

    // Adding weighted edges between vertices
    graph.addEdge(0, 1, 3);
    graph.addEdge(0, 2, -100);
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

    graph.bellmanFord(0); // Starting from vertex 0
  }
}
