package com.company;

public class Main {

    public static void main(String[] args) {
        MyQueue<String> list = new MyQueue<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Zebra");
        list.add("Banana");

        System.out.println(list);

        System.out.println(list.get(2));
        list.remove(1);
        System.out.println(list);
    }
}
