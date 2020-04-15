package graph;

import Standardlibraries.StdOut;

import java.util.Stack;
import java.util.Arrays;
public class DepthFirstPaths extends Paths{
    private boolean[] marked;//index对应的值表示index顶点和s顶点是否连通
    private int[] edgeTo;//index对应的值表示和index顶点连通的顶点
    private final int s;
    public DepthFirstPaths(Graph G, int s) {
        super(G, s);
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        dfs(G,s);
    }
    private void dfs(Graph G,int v){
        StdOut.println("从顶点 "+v+" 开始");
        marked[v]=true;
        StdOut.println("顶点 "+v+" 被访问");
        for(int w:G.adj(v)){
            StdOut.println("从顶点 "+v+" 的相邻顶点 "+w+" 开始");
                if(!marked[w]){
                edgeTo[w]=v;
                StdOut.println("顶点 "+v+"到顶点"+w+" 是路径");
                dfs(G,w);
            }
        }
    }


    @Override
    boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)){ return null;}
        Stack<Integer> path=new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        GraphIn graphIn = new GraphIn(8);
        graphIn.addEdge(0,5);
        graphIn.addEdge(2,4);
        graphIn.addEdge(2,3);
        graphIn.addEdge(1,2);
        graphIn.addEdge(0,1);
        graphIn.addEdge(3,4);
        graphIn.addEdge(3,5);
        graphIn.addEdge(0,2);
        graphIn.addEdge(6,7);

        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graphIn,0);
        StdOut.println(Arrays.toString(depthFirstPaths.marked));
        StdOut.println(Arrays.toString(depthFirstPaths.edgeTo));
        Iterable<Integer> path = depthFirstPaths.pathTo(5);
        StdOut.println(path);

    }



}
