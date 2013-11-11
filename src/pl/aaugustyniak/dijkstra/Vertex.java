package pl.aaugustyniak.dijkstra;

import static pl.aaugustyniak.dijkstra.CostMatrix.INFINITY;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author artur
 */
public class Vertex {

    private String label;
    private List<Edge> neighborsPaths;

    public Vertex(String label) {
        this.label = label;
        init();
    }

    public Vertex(Integer label) {
        this.label = label.toString();
        init();
    }

    public Vertex() {
        init();
    }

    private void init() {
        this.neighborsPaths = new ArrayList();
    }

    public Vertex addNeighborPathWithCost(Vertex neighbor, Integer cost) {
        Edge wayToneighbor = new Edge(this, neighbor, cost);
        this.neighborsPaths.add(wayToneighbor);
        return this;
    }

    public List<Edge> getNeighborsPaths() {
        return neighborsPaths;
    }

    public Vertex getNearestNeighbor() {
        Vertex nearestNeighbor = null;
        Integer lastLowestCost = INFINITY;
        for (Edge e : this.getNeighborsPaths()) {
            if (e.getCost() <= lastLowestCost) {
                lastLowestCost = e.getCost();
                nearestNeighbor = e.getDestination();
            }
        }
        return nearestNeighbor;
    }

    public List<Vertex> getNeighbors() {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge e : this.getNeighborsPaths()) {
            neighbors.add(e.getDestination());
        }
        return neighbors;
    }

    @Override
    public String toString() {
        return (this.label != null) ? this.label : super.toString();
    }

}
