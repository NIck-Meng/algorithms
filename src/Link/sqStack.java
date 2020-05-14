package Link;

import java.util.Arrays;

public class sqStack implements Stack {
    private int length;  //栈空间大小(常量)
    private int[] data;
    private int top=-1;  //栈顶指针(指向栈顶元素)

    public sqStack() {
        this.length=100;
        this.data=new int[this.length];
    }

    public sqStack(int length) {
        this.length=length;
        this.data=new int[length];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length==0;
    }

    @Override
    public void push(int ele) {
        if(length>=length)
        data[++top]=ele;

        length++;

    }

    @Override
    public int pop() {
        int temp=data[top--];
        length--;
        return temp;

    }

    @Override
    public int getHead() {
        return 0;
    }


    @Override
    public boolean isFull() {
        return length==data.length;
    }


    @Override
    public String toString() {
        return "sqStack{" +
                "length=" + length +
                ", data=" + Arrays.toString(data) +
                ", top=" + top +
                '}';
    }
}
