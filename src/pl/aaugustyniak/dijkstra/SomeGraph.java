package pl.aaugustyniak.dijkstra;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author artur
 */
public class SomeGraph implements Graph {

    private final Vertex featuredVertex;
    private final Set<Vertex> allGraphVertices;

    public SomeGraph() {

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);

        v1.addNeighborPathWithCost(v4, 3).addNeighborPathWithCost(v2, 3);
        v2.addNeighborPathWithCost(v3, 2);
        v3.addNeighborPathWithCost(v6, 1);
        v4.addNeighborPathWithCost(v5, 1);
        v5.addNeighborPathWithCost(v3, 1).addNeighborPathWithCost(v6, 2);
        v6.addNeighborPathWithCost(v4, 3);

        this.allGraphVertices = new HashSet<>();
        this.allGraphVertices.add(v1);
        this.allGraphVertices.add(v2);
        this.allGraphVertices.add(v3);
        this.allGraphVertices.add(v4);
        this.allGraphVertices.add(v5);
        this.allGraphVertices.add(v6);

        this.featuredVertex = v1;

    }

    @Override
    public Vertex getFeaturedVertex() {
        return this.featuredVertex;
    }

    @Override
    public Set<Vertex> getAllVertices() {
        return this.allGraphVertices;

    }

}
