package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        String word="D:\\Works\\untitled9\\src\\com\\company\\map1.txt";
        String num="8";
       GridPane pane=new GridPane();
        int unit=10;
        int y=0;
        int x=0;
        Color c = new Color(0,0,0,1.0);
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
                            pane.add(rect(x,y,Color.WHITE),j,i);
                        }
                        else if(map[i][j]==1){
                            pane.add(rect(x,y,Color.BLACK),j,i);
                        }
                        else if(map[i][j]==2){
                            pane.add(rect(x,y,Color.YELLOW),j,i);
                        }
                        x+=unit;
                    }
                    y+=unit;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        stage.setTitle("DSA");
        stage.setScene(new Scene(pane,800,800));
        stage.show();

    }
    public Rectangle rect(int x, int y, Color color){
        Rectangle rec=new Rectangle(x,y,10,10);
        rec.setFill(color);
        rec.setStroke(Color.BLACK);
        return  rec;
    }
}
