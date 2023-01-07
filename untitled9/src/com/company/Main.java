package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        String word="D:\\Works\\untitled9\\src\\com\\company\\map1.txt";
        String num="8";
        GridPane pane=new GridPane();

        Rectangle rec=new Rectangle(10,10);
        File file=new File(word);
        int n= Integer.parseInt(num);
        int [][] map=new int[n][n];
        try {
            Scanner in=new Scanner(file);
            while (in.hasNext()){
                for (int i = 0; i <n ; i++) {
                    for (int j = 0; j < n; j++) {
                        map[i][j]=Integer.parseInt(in.next());
                        if(map[i][j]==0){
                            pane.add(rec,j,i);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        stage.setTitle("DSA");
        stage.setScene(new Scene(pane));
        stage.show();

    }
}
