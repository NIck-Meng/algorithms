package graph;

abstract class ConnectedComponents {
    public ConnectedComponents(Graph G) {

    }
    abstract boolean connected(int v,int w);
    abstract int count();
    abstract int id(int v);
}
