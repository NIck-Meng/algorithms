package graph;

abstract class Paths {
    public Paths(Graph G,int s) {
        /*
        * 在G中找出所有起点为s的路径
        * */
    }
    abstract boolean hasPahtTo(int v);
    abstract Iterable<Integer> pathTo(int v);
}
