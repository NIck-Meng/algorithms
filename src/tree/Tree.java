package tree;

public interface Tree {
    //查找结点
    public Node find(int key);
    //插入新结点
    public boolean insert(int key);
    //删除结点
    public boolean delete(int key);
}
