package com.company;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        System.out.println("Jump:"+jump(10, 74, 20));
        int[] A = {2, 1, 3, 5};
        System.out.println("Miss array num"+MissNum(A));
    }

    public static int MissNum(int A[]) {
        int sum1 = 0;
        for (int i = 0; i < A.length; i++) {
            sum1 += A[i];
        }
        int sum = (A.length + 1) * (A.length + 2) / 2;
        return sum - sum1;
    }

    public static int jump(int X, int Y, int D) {
        if (X == Y) return 0;

        int ostatok = (Y - X) % D;

        if (ostatok == 0) {
            return (Y - X) / D;
        } else return (Y - X) / D + 1;
    }
    
}
