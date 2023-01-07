package com.company;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        Set<String> set = new HashSet<>();
        Scanner in = new Scanner(file);
        ArrayList<String> s=new ArrayList<>();
        while (in.hasNext()) {

            String[] words = in.nextLine().split("[ \n\t\r.,;:!?()-]");
            for (String word: words) {
                if (word.length() > 0) {
                    s.add(word.toLowerCase());
                    set.add(word.toLowerCase());
                }
            }
        }
        String[] articl = {"am", "are", "is", "a", "an", "the", "on", "to", "in", "for", "and", "as", "not", "by","or","so"};
        for (String st : articl) {
            if(s.contains(st)){
                s.remove(st);
            }
            if (set.contains(st)) {
                set.remove(st);
            }
        }
        TreeSet<String> treeSet = new TreeSet<>(set);

        System.out.println("Size of file is " + set.size());
        for (String st : treeSet) {
            System.out.print(st + " ");
        }
        System.out.println();
        Map<String, Integer> map = new TreeMap<>();
        for(String word:s) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                int value = map.get(word);
                value++;
                map.put(word, value);
            }
        }
        List<Map.Entry<String, Integer>> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
