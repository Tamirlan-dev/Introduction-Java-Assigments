package com.company;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

	    File file=new File(args[0]);
        List<String> words=new LinkedList<>();
        Scanner input=new Scanner(file);
        while (input.hasNext()){
            String word="";
            word=input.next();
            if(Character.isLetter(word.charAt(0))) {
                words.add(input.next());
            }
        }
        Collections.sort(words,new AlhabeticComparator());
        System.out.println(words);
        Collections.sort(words,new DescendingAlhabeticComparator());
        System.out.println(words);
        Collections.sort(words,new LengthComparator());
        System.out.println(words);
    }
}
class AlhabeticComparator implements Comparator<String>{
      @Override
      public int compare(String s, String t1) {
          return s.compareToIgnoreCase(t1);

      }
  }
class DescendingAlhabeticComparator implements Comparator<String>{

    @Override
    public int compare(String s, String t1) {
        for(int i=0;i<s.length();i++){
            for(int j=i;j<t1.length();j++){
                if(s.charAt(i)>t1.charAt(j)) return - 1;
                else if(s.charAt(i)<t1.charAt(j)) return 1;
            }
        }
        return 0;
    }
}
class LengthComparator implements Comparator<String>{
    @Override
    public int compare(String s, String t1) {
        if(s.length()>t1.length()) return 1;
        else if(s.length()<t1.length()) return -1;
        return 0;
    }
}
