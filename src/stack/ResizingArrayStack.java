package stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;


    public ResizingArrayStack(int cap) {
        a=(Item[]) new Object[cap];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        if(N==a.length) resize(2*a.length);
        a[N++]=item;
    }
    public Item pop(){
        //给数组缩小容量：当栈大小为数据容量的1/4时，将数组容量减半
        Item item=a[--N];
        a[N]=null;
        if(N>0 && N==a.length/4) resize(a.length/2);
        return item;
    }

    private void resize(int max){
        //给数组扩容：将大小为N的栈移动到一个新的大小为max的数组中
        Item[] temp=(Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i]=a[i];
        }
        a=temp;
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }



//    public static void main(String[] args) {
//        ResizingArrayStack resizingArrayStack = new ResizingArrayStack<String>(5);
//        resizingArrayStack.push("to");
//        resizingArrayStack.push("be");
//        resizingArrayStack.push("a");
//        resizingArrayStack.push("good");
//        resizingArrayStack.push("boy");
//        for (String s : resizingArrayStack) {
//            System.out.println(s);
//
//        }



//    }

}
