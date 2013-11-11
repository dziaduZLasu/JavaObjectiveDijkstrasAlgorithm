package pl.aaugustyniak.dijkstra;

/**
 *
 * @author artur
 */
public class DijkstaObj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph G = new SomeGraph();
        Dijkstra alg = new Dijkstra(G);
        CostMatrix result = alg.inspectGraph();
        System.out.println(result);
    }

}
