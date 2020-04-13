package graph;

import Link.Bag;
import Standardlibraries.StdIn;

public class GraphIn extends Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public GraphIn(int V) {
        /*
        * 创建邻接表
        * */
        super(V);
        this.V = V;
        this.E=E;
        adj=(Bag<Integer>[]) new Bag[V];
        for(int v=0;v<V;v++){
            adj[v]=new Bag<Integer>();
        }
    }

    @Override
    int V() {
        return V;
    }

    @Override
    int E() {
        return E;
    }

    @Override
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;

    }

    @Override
    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public GraphIn(StdIn in) {
        this(in.readInt());
        int E=in.readInt();
        for(int i=0;i<E;i++){
            int v=in.readInt();
            int w=in.readInt();
            addEdge(v,w);

        }

    }

    public String toString(){
        String s=V+" vertices,"+E+" edges\n";
        for(int v=0;v<V;v++){
            s+=v+" ";
            for(int w:this.adj(v))
                s+=w+" ";
            s+="\n";
        }
        return s;
    }

}
