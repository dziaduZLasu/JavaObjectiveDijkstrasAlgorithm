package pl.aaugustyniak.dijkstra;

/**
 *
 * @author artur
 */
public class Edge {

    public static final String ERR_MSG = "Do not use negative values for path cost.";

    private final Vertex source;
    private final Vertex destination;
    private final Integer cost;

    public Edge(Vertex source, Vertex destination, Integer cost) {
        validateCost(cost);
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    private void validateCost(Integer cost) throws IllegalArgumentException {
        if (cost < 0) {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Integer getCost() {
        return cost;
    }

}
