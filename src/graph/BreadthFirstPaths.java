package graph;

import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstPaths {
    boolean[] marked;
    int[] edgeTo;
    final int s;

    public BreadthFirstPaths(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }
    private void bfs(Graph G,int s){
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
        marked[s]=true;
        queue.add(s);
        while(!queue.isEmpty()){
            int v=queue.peek();
            for(int w:G.adj(v)){
                if(!marked[w]){
                    edgeTo[w]=v;
                    marked[w]=true;
                    queue.add(w);
                }
            }

        }

    }

    public boolean hasPathTo(int v){
        return marked[v];
    }





}
