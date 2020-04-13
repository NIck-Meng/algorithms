package graph;

public class DirectedGraph extends Graph {

    public DirectedGraph(int V) {
        super(V);
    }

    @Override
    public int V() {
        return 0;
    }

    @Override
    public int E() {
        return 0;
    }

    @Override
    public void addEdge(int v, int w) {

    }

    @Override
    public Iterable<Integer> adj(int v) {
        return null;
    }
}
