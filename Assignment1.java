import java.util.*;
 
class Edge {
    int source, dest;
 
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

class Graph {
    List<List<Integer>> adjList = null;
 
    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (Edge edge: edges) {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

public class Assignment1 {
    
    public static void recursiveBFS(Graph graph, Queue<Integer> queue, boolean[] discovered) {
        if (queue.isEmpty()) {
            return;
        }

        int head = queue.poll();
        System.out.print(head + " ");

        for (int u : graph.adjList.get(head)) {
            if (!discovered[u]) {
                discovered[u] = true;
                queue.add(u);
            }
        }
        recursiveBFS(graph, queue, discovered);
    }
    
    public static void recursiveDFS(Graph graph, int v, boolean[] discovered) {
        discovered[v] = true;
        System.out.print(v + " ");

        for (int u : graph.adjList.get(v)) {
            if (!discovered[u]) {
                recursiveDFS(graph, u, discovered);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2),new Edge(1, 3),new Edge(1, 4),new Edge(2, 5),new Edge(2, 6)
        );
        int n = 7; // No. of nodes in the graph + 1
 
        Graph graph = new Graph(edges, n); // Instantiated new undirected graph
        boolean[] discoveredBFS = new boolean[n];
        boolean[] discoveredDFS = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>(); // Queue for BFS traversal

        int choice;
        do {
            System.out.println("\n****** MENU ******");
            System.out.println("\n1. BFS\n2. DFS\n3. Exit");
            System.out.print("\nEnter your choice : ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nBY BFS");
                    for (int i = 1; i < n; i++) {
                        if (discoveredBFS[i] == false) {
                            discoveredBFS[i] = true;
                            queue.add(i);
                            recursiveBFS(graph, queue, discoveredBFS);
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\nBY DFS");
                    for (int i = 1; i < n; i++) {
                        if (!discoveredDFS[i]) {
                            recursiveDFS(graph, i, discoveredDFS);
                        }
                    }
                    System.out.println();
                    break;
                default:
                    break;
            }
        } while (choice != 3);
    }
}
