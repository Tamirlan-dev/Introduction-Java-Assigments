package sample;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map extends Pane {
    private GridPane gridPane;
    private int unit;
    private int size;
    private int[][] map;
    private Position start;
    Map(String word){
        gridPane=new GridPane();
        int x,y;
        x=0;y=0;unit=100;
        String num=word.substring(word.indexOf(" ")+1,word.length());
        word=word.substring(0,word.indexOf(" "));
        File file=new File(word);//читает файл
        size= Integer.parseInt(num);
        map=new int[size][size];
        try {
            Scanner in=new Scanner(file);
            if(size!=in.nextInt()){
                System.out.println("INCORREct");
            }
            while  (in.hasNext()){
                for (int i = 0; i <size ; i++) {
                    for (int j = 0; j < size; j++) {
                            map[i][j]=Integer.parseInt(in.next());// пишет каждый клетку в масив
                            if(map[i][j]==0){
                                gridPane.add(rect(x,y, Color.WHITE),j,i);// создает клетки
                            }else if(map[i][j]==1){
                                gridPane.add(rect(x,y,Color.BLACK),j,i);//создат клетки которые не возможно пройти
                            }
                            x+=unit;
                    }
                    y+=unit;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        getChildren().addAll(gridPane);
    }
    public Rectangle rect(int x, int y, Color color) {
        //создает прямоугольник
        Rectangle rec = new Rectangle(x, y, unit-0.2, unit-0.2);
        rec.setFill(color);
        rec.setStrokeWidth(0.1);
        rec.setStroke(Color.BLACK);
        return rec;
    }
    public int getUnit() {
        return unit;
    }
    public int getSize() {
        return size;
    }
    public  int getValueAt(int row,int column){
        return map[row][column];
    }
    public  int [][] getMap(){return  map;}
    public Position getStartPosition() {
        int x,y;
        do {
            x= (int) (Math.random()*size);
            y= (int) (Math.random()*size);
        }while (map[y][x]==1);
        start=new Position(x,y);
        return start;
    }
}

