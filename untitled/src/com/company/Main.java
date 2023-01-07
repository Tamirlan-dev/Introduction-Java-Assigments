package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int[][] map;

    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("D:\\Works\\untitled9\\src\\com\\company\\map1.txt");
        Scanner in=new Scanner(file);
        int size= Integer.parseInt(in.next());
        map=new int[8][8];
        while (in.hasNext()){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    map[i][j]= Integer.parseInt(in.next());
                }
            }
        }


        FindWave(0, 7, 5, 3);
    }
        public static void  FindWave(int startX, int startY, int targetX, int targetY){
        int [][ ] karta=map;
        boolean add=true;
        int[][] cMap = new int[8][8];
        int x, y,step=0;
        for (y = 0; y < 8; y++)
            for (x = 0; x < 8; x++)
            {
                if (karta[y][ x] == 1)
                    cMap[y][ x] = -2;//индикатор стены
                else
                    cMap[y][x] = -1;//индикатор еще не ступали сюда
            }
        cMap[targetY][targetX]=0;//Начинаем с финиша
        while (add==true)
        {
            add = false;
            for (y = 0; y < 8; y++)
                for (x = 0; x < 8; x++)
                {
                    if (cMap[y][x] == step)
                    {
                        //Ставим значение шага+1 в соседние ячейки (если они проходимы)
                        if (y - 1 >= 0 && cMap[y - 1][x] != -2 && cMap[y - 1][x] == -1)
                            cMap[y - 1][ x] = step + 1;
                        if (x - 1 >= 0 && cMap[y][ x - 1] != -2 && cMap[y][ x - 1] == -1)
                            cMap[y][ x - 1] = step + 1;
                        if (y + 1 < 8 && cMap[y + 1][ x] != -2 && cMap[y + 1][ x] == -1)
                            cMap[y + 1][ x] = step + 1;
                        if (x + 1 < 8 && cMap[y][ x + 1] != -2 && cMap[y][ x + 1] == -1)
                            cMap[y][x + 1] = step + 1;
                    }
                }

            step++;
            add = true;
            if (cMap[startY][startX] != -1)//решение найдено
                add = false;
            if (step > 64)//решение не найдено
                add = false;
        }

        for (y = 0; y < 8; y++) {
            System.out.println();
            for (x = 0; x < 8; x++) {

                if (cMap[y][x] == -1)
                    System.out.print(" ");
                else if (cMap[y][x] == -2)
                    System.out.print("# ");
                else if (y == startY && x == startX)
                    System.out.print("S ");
                else if (y == targetY && x == targetX)
                    System.out.print("F ");
                else if (cMap[y][x] > -1) {

                    System.out.print(cMap[y][x]+" ");
                }
            }

        }
    }
    }
