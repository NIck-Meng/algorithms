package Link;

public interface Stack {

    public abstract int size();
    public abstract boolean isEmpty();
    public abstract void push(int ele);
    public abstract int pop();
    public abstract int getHead();
    boolean isFull();
}
