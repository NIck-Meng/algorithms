package graph;

abstract class Graph {
    /**
     * 用邻接表数组表示图
     * 以顶点为索引的列表数组，每个元素都是和该顶点相邻的顶点列表
     *
     *
     */



    Graph(int V) {}

    abstract int V();  //顶点数,使用0到V-1来表示一张含有V个顶点的图中的每个顶点，这样是为了方便使用数组的索引来高效访问各个顶点的信息
    abstract int E();  //边数，用v-w表示连接v和w的边

    abstract void addEdge(int v,int w); //增加边
    abstract Iterable<Integer> adj(int v); //v的相邻顶点,核心方法

    public static int degree(Graph G,int v){
        int degree=0;
        for(int w:G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G){
        int max=0;
        for(int v=0;v<G.V();v++){
            if(degree(G,v)>max)
                max=degree(G,v);
        }
        return max;
    }

    public static double avgDegree(Graph G){
        return 2*G.E()/G.V();
    }

    public static int numberOfSelfLoops(Graph G){
        int count=0;
        for(int v=0;v<G.V();v++){
            for(int w:G.adj(v)){
                if(v==w) count++;
            }
        }
        return count/2;
    }








}
