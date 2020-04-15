package graph;

import Standardlibraries.StdOut;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Stack;

public class BreadthFirstPaths extends Paths {
    /*
    * 解决最短路径问题：起点到给定顶点的最短路径
    * */
    boolean[] marked;
    int[] edgeTo;
    final int s;

    public BreadthFirstPaths(Graph G, int s) {
        super(G,s);
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }
    private void bfs(Graph G,int s){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        marked[s]=true;
        queue.add(s);
        StdOut.println("将顶点 "+s+" 加入队列");
        while(!queue.isEmpty()){
            int v=queue.pop();
            StdOut.println("顶点 "+v+" 被访问");
            for(int w:G.adj(v)){
                StdOut.println("顶点 "+v+"到顶点"+w+" 被访问");
                if(!marked[w]){
                    edgeTo[w]=v;
                    StdOut.println("顶点 "+v+"到顶点"+w+" 是路径");
                    marked[w]=true;
                    queue.add(w);
                    StdOut.println("将顶点 "+w+" 加入队列");
                }
            }

        }

    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
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

        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graphIn, 0);
        StdOut.println(Arrays.toString(breadthFirstPaths.marked));
        StdOut.println(Arrays.toString(breadthFirstPaths.edgeTo));
        Iterable<Integer> path = breadthFirstPaths.pathTo(5);
        StdOut.println(path);



    }




}
