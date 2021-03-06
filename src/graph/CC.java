package graph;

public class CC extends ConnectedComponents{
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        super(G);
        marked=new boolean[G.V()];
        id=new int[G.V()];
        for(int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }
    public void dfs(Graph G,int v){
        marked[v]=true;
        id[v]=count;
        for(int w:G.adj(v)){
            if(!marked[w]) dfs(G,w);
        }
    }

    @Override
    boolean connected(int v, int w) {
        return id[v]==id[w];
    }

    @Override
    int count() {
        return count;
    }

    @Override
    int id(int v) {
        return id[v];
    }
}
