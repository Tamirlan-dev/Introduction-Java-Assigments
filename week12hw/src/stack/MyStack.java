package stack;

import java.util.ArrayList;

public class MyStack<E>{

    private ArrayList<E> arr;
    private int size;

    public MyStack(){
        arr=new ArrayList<>(size);
        size=0;
    }
    public void push(E value){
        if(size==0)arr.add(value);
        else{
            ArrayList<E> newer = new ArrayList<>();
            newer.add(value);
            newer.addAll(arr);
            arr=newer;
        }
        size++;
    }
    public void pop() {
        if(size>0)arr.remove(0);
        size--;
    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return arr.toString();
    }
}