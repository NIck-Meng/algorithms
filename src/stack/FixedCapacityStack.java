package stack;

public class FixedCapacityStack<Item> {
    //定容栈：容量固定的栈
    private Item[] a;
    private int N;


    public FixedCapacityStack(int cap) {
        a=(Item[]) new Object[cap];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        a[N++]=item;
    }
    public Item pop(){
        return a[--N];
    }


    public static void main(String[] args) {
        FixedCapacityStack<String> stringFixedCapacityStack = new FixedCapacityStack<>(5);
        stringFixedCapacityStack.push("to");
        stringFixedCapacityStack.push("be");
        stringFixedCapacityStack.push("a");
        stringFixedCapacityStack.push("good");
        stringFixedCapacityStack.push("boy");



    }


}
