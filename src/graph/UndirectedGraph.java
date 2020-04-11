package graph;

import Link.Bag;

public class UndirectedGraph implements Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;


    public UndirectedGraph(int V) {
        this.V=V;
        this.E=0;
        adj=(Bag<Integer>[]) new Bag[V];
        for(int v=0;v<V;v++){
            adj[v]=new Bag<Integer>();
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);  //无向图
        E++;

    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
