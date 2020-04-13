package graph;

abstract class Graph {
    Graph(int V) {}

    abstract int V();  //顶点数,使用0到V-1来表示一张含有V个顶点的图中的每个顶点，这样是为了方便使用数组的索引来高效访问各个顶点的信息
    abstract int E();  //边数，用v-w表示连接v和w的边

    abstract void addEdge(int v,int w); //增加边
    abstract Iterable<Integer> adj(int v); //v的相邻顶点,核心方法

}
