package graph;

import Standardlibraries.StdOut;

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
            StdOut.println(v+" 的相邻边 "+w+" 开始");
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

    public static void main(String[] args) {
        GraphIn graphIn = new GraphIn(6);
        graphIn.addEdge(0,5);
        graphIn.addEdge(2,4);
        graphIn.addEdge(2,3);
        graphIn.addEdge(1,2);
        graphIn.addEdge(0,1);
        graphIn.addEdge(3,4);
        graphIn.addEdge(3,5);
        graphIn.addEdge(0,2);

        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graphIn,0);
        Iterable<Integer> path = depthFirstPaths.pathTo(5);
        StdOut.println(path);

    }



}
