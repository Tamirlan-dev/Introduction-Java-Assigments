package stack;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack=new MyStack<>();
        int size=50;
        while(size<=50){
            int i=0;
            int counter=0;
            for(int num=i;num>=1;num--){
                if(i%num==0) counter++;
            }
            if(counter==2) {
                stack.push(i);
            }
            i++;
        }
        System.out.println(stack.toString());

        for(int i=0;i<size;i++){
            stack.pop();
            System.out.println(stack.toString());
        }
    }
}
