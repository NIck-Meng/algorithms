package graph;

interface Graph {
    int V();  //顶点数
    int E();  //边数

    void addEdge(int v,int w); //增加边
    Iterable<Integer> adj(int v); //v的相邻顶点,核心方法
    String toString(); //字符表示
}
