package tree;



import java.util.HashMap;

public class RBTree<T extends Comparable<T>> {

    RBNode<T> root;

    public RBTree() {
        this.root=null;
    }

    public RBTree(RBNode<T> root) {
        this.root = root;
    }

    public RBNode<T> parentOf(RBNode<T> node){
        //获取父节点
        return node!=null?node.parent:null;
    }
    public void setParent(RBNode<T> node,RBNode<T> parent){
        if(node!=null){
            node.parent=parent;
        }
    }


    public boolean isRed(RBNode<T> node){
        return node!=null && node.isRed;
    }

    public boolean isBlack(RBNode<T> node){
        return !isRed(node);
    }

    public void setRed(RBNode<T> node){
        if(node!=null){
            node.isRed=true;
        }
    }
    public void setBlack(RBNode<T> node){
        if(node!=null){
            node.isRed= false;
        }
    }


    /**************** 查找红黑树中键值为key的节点 ***************/
    public RBNode<T> search(T data){
        return search(root,data);
    }
    //使用递归
    public RBNode<T> search(RBNode<T> x,T data){
        if(x==null) return x;
        int cmp=data.compareTo(x.data);
        if(cmp<0) return search(x.leftChild,data);
        else if(cmp>0) return search(x.rightChild,data);
        else return x;
    }



    /*************对红黑树节点x进行左旋操作 ******************/
    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    public void leftRotate(RBNode<T> x){
        //1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
        RBNode<T> y=x.rightChild;
        x.rightChild=y.leftChild;
        if(y.leftChild!=null){
            y.leftChild.parent=x;
//            y.leftChild=x;//理解
        }

        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        y.parent=x.parent;
        if(x.parent==null){
            this.root=y;
        }
        else{
            if(x==x.parent.leftChild){
                x.parent.leftChild=y;
            }
            else{
                x.parent.rightChild=y;
            }
        }
        //3. 将y的左子节点设为x，将x的父节点设为y
        y.leftChild=x;
        x.parent=y;
    }

    /*************对红黑树节点y进行右旋操作 ******************/
    /*
     * 左旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    public void rightRotate(RBNode<T> y){
        RBNode<T> x=y.leftChild;
        y.leftChild=x.rightChild;






    }



    public void insert(T data){
        RBNode<T> node = new RBNode<>(true, data, null, null, null);
        if(node!=null){
            insert(node);
        }

    }

    private void insert(RBNode<T> node){
        RBNode<T> current=null;
        RBNode<T> x=this.root;
        //寻找插入位置
        while(x!=null){
            current=x;
            int cmp=node.data.compareTo(x.data);
            if(cmp<0) {
                x=x.leftChild;
            }
            else {
                x=x.rightChild;
            }
        }
        node.parent=current;

        if(current!=null){
            int cmp=node.data.compareTo(current.data);
            if(cmp<0){
                current.leftChild=node;
            }
            else{
                current.rightChild=node;
            }
        }
        else{
            this.root=root;
        }
        insertFixUp(node);

    }



    public void insertFixUp(RBNode<T> node){
        RBNode<T> parent,grandparent;




    }






}
