package pl.aaugustyniak.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author artur
 */
public class CostMatrix {

    public static final Integer INFINITY = Integer.MAX_VALUE;
    public static final Vertex NON_EXISTENT_VERT = null;

    private final Graph G;
    /**
     * Map<Current, Cost from featuredVertex>
     */
    private final Map<Vertex, Integer> costToVertex;
    /**
     * Map<Current, Predecessor>
     */
    private final Map<Vertex, Vertex> predecessorOnPath;

    public CostMatrix(Graph G) {
        this.G = G;
        costToVertex = new HashMap<>(G.getAllVertices().size());
        predecessorOnPath = new HashMap<>(G.getAllVertices().size());
        this.initMatrix();
    }

    private void initMatrix() {
        for (Vertex vertex : this.G.getAllVertices()) {
            this.predecessorOnPath.put(vertex, NON_EXISTENT_VERT);
            if (vertex.equals(G.getFeaturedVertex())) {
                this.costToVertex.put(vertex, 0);
            } else {
                this.costToVertex.put(vertex, INFINITY);
            }
        }
    }

    void update(Vertex currentVert) {
        List<Edge> paths = currentVert.getNeighborsPaths();
        for (Edge edge : paths) {
            if (costToVertex.get(edge.getDestination()) > costToVertex.get(currentVert) + edge.getCost()) {
                int NewCost = costToVertex.get(currentVert) + edge.getCost();
                costToVertex.put(edge.getDestination(), NewCost);
                this.predecessorOnPath.put(edge.getDestination(), currentVert);
            }
        }
    }

    public Vertex getNearestVertexExcludingFeaturedBy(Set<Vertex> Q) {
        int minCost = INFINITY;
        Vertex nextToProcess = null;
        for (Vertex vertex : Q) {

            Integer cost = this.costToVertex.get(vertex);
            if (cost < minCost) {
                nextToProcess = vertex;
            }
        }
        return nextToProcess;
    }

    public Vertex getNearestVertexExcludingFeatured() {
        int minCost = INFINITY;
        Vertex nextToProcess = null;
        for (Map.Entry<Vertex, Integer> entry : costToVertex.entrySet()) {
            Vertex vertex = entry.getKey();
            Integer cost = entry.getValue();
            if ((cost < minCost && cost > 0) && this.predecessorOnPath.get(vertex) != NON_EXISTENT_VERT) {
                nextToProcess = vertex;
            }
        }
        return nextToProcess;
    }

    @Override
    public String toString() {
        String outBuffer = "";
        for (Vertex vertex : this.G.getAllVertices()) {
            outBuffer += "V:" + vertex + " - ";
            outBuffer += "Cost from V:" + G.getFeaturedVertex() + " - " + costToVertex.get(vertex) + " ||| ";
            outBuffer += "Predecessor - V:" + predecessorOnPath.get(vertex);
            if (vertex.equals(G.getFeaturedVertex())) {
                outBuffer = String.format("%s <-- START!", outBuffer);
            }
            outBuffer += "\n";
        }
        return outBuffer;
    }

}
