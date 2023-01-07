package com.company;

public class MyQueue<E> {
        private Node<E> first;
        private Node<E> last;
        private int size;

        public MyQueue(){
            first = last = null;
            size=0;
        }

        public void add(E value){
            if(size==0){
                first = new Node<E>(value);
                last = first;
            }
            else{
                last.nextNode = new Node<E>(value);
                last = last.nextNode;
            }
        }
        public String toString(){
            String result = "";
            Node<E> current = first;
            while(current != null){
                result += current.value + " ";
                current = current.nextNode;
            }
            return result;
        }

        public E get(int index){
            int count = 0;
            Node<E> current = first;
            while(current != null){
                if(count == index)
                    return current.value;
                count++;
                current = current.nextNode;
            }
            return null;
        }

        public void remove(int index) throws NullPointerException{
            int count = 0;
            Node<E> current = first;
            while(current != null){
                if(count == index-1){
                    current.nextNode = current.nextNode.nextNode;
                }
                count++;
                current = current.nextNode;
            }
        }


        private class Node<E>{
            E value;
            Node<E> nextNode;
            Node(E value){
                this.value = value;
            }
        }
}
