package pl.aaugustyniak.dijkstra;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author artur
 */
public class Dijkstra {

    private final Graph G;
    private final Set<Vertex> S;
    private final Set<Vertex> Q;

    public Dijkstra(Graph G) {
        this.G = G;
        this.Q = new HashSet<>(G.getAllVertices());
        this.S = new HashSet<>();
    }

    public CostMatrix inspectGraph() {
        CostMatrix cm = new CostMatrix(this.G);
        while (!Q.isEmpty()) {
            Vertex next = cm.getNearestVertexExcludingFeaturedBy(Q);
            S.add(next);
            Q.remove(next);
            cm.update(next);
        }
        return cm;
    }
}
