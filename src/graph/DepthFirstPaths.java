package graph;

import java.util.Stack;

public class DepthFirstPaths extends Paths{
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    public DepthFirstPaths(Graph G, int s) {
        super(G, s);
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        dfs(G,s);
    }
    private void dfs(Graph G,int v){
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }
        }
    }


    @Override
    boolean hasPahtTo(int v) {
        return marked[v];
    }

    @Override
    Iterable<Integer> pathTo(int v) {
        if(!hasPahtTo(v)){ return null;}
        Stack<Integer> path=new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
