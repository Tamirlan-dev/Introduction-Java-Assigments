package second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {


    public static void main(String[] args) {
        String word="D:\\Works\\untitled9\\src\\com\\company\\map1.txt 8";
        String num=word.substring(word.indexOf(" ")+1,word.length());
        word=word.substring(0,word.indexOf(" "));
        int size= Integer.parseInt(num);
        System.out.println(num+"word"+ word+"size" +size);
        ;
    }


}