import java.util.*;

public class Dijkstra {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node, distance;
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        public int compareTo(Pair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(2, 5));
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(3, 2));
        graph.get(3).add(new Edge(4, 10));
        graph.get(4).add(new Edge(0, 7));

        int source = 0;
        int[] distances = dijkstra(n, graph, source);

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i <n; i++) {
            System.out.println("Distance from " + source + " to " + i + " is: " + distances[i]);
        }
    }

    public static int[] dijkstra(int n, List<List<Edge>> graph, int source) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.distance;

            if (d > distances[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.add(new Pair(v, distances[v]));
                }
            }
        }

        return distances;
    }
}
