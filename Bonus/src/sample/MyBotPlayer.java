package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;


public class MyBotPlayer implements BotPlayer {
    private String invalid="Invalid!";
    private Map map;
    private Circle ball;
    private Food f;
    private int[][] cMap;
    private  Position position;
    private int step;
    public MyBotPlayer(Map map){
        this.map=map;
        position=new Position(map.getStartPosition().getY(),map.getStartPosition().getX());
        ball=new Circle(position.getX()*map.getUnit()+map.getUnit()/2,position.getY()*map.getUnit()+map.getUnit()/2,map.getUnit()/2);
        ball.setFill(Color.RED);
        ball.setStroke(Color.BLACK);
        map.getChildren().add(ball);
    }
    @Override
    public void feed(Food f) {
        this.f=f;
        Thread var3 = new Thread(() -> {
            while (!position.equals(f.getPosition())) {
                Platform.runLater(() -> {
                    if (position.getY() > f.getPosition().getY()) {
                        moveDown();
                    } else if (position.getY() < f.getPosition().getY()) {
                        moveUp();
                    } else if (position.getX() < f.getPosition().getX()) {
                        moveRight();
                    } else if (position.getX() > f.getPosition().getX()) {
                        moveLeft();
                    }
                });
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException var5) {
                }
            }
            if(position.equals(f.getPosition())){
                System.out.println("Press e to move next");
            }
        });
        var3.start();

    }
    public  void move(){
        
    }

    @Override
    public void eat(Food f) {
        this.f=f;
        find();
        ArrayList<Integer> arr=new ArrayList<>();
        Thread var3 = new Thread(() -> {
            while (!position.equals(f.getPosition())) {
                Platform.runLater(() -> {
                    int steep=step;
                    if(position.getY()>f.getPosition().getY()){
                        if(position.getX()>f.getPosition().getX()){
                            if(cMap[position.getY()+1][position.getX()]==steep) moveUp();
                            else if(cMap[position.getY()][position.getX()-1]==steep) moveLeft();
                            else moveRight();
                        }
                        else if(position.getX()<f.getPosition().getX()){
                            if(cMap[position.getY()+1][position.getX()]==steep) moveUp();
                            else if(cMap[position.getY()][position.getX()+1]==steep) moveRight();
                            else moveLeft();
                        }
                    }
                    steep--;

                });
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException var5) {
                }
            }
        });
        var3.start();
    }

    @Override
    public void find() {
        boolean add=true;
        int size=map.getSize();
        cMap = new int[size][size];
        int x, y=0;
        step=0;
        for (y = 0; y < size; y++)
            for (x = 0; x < size; x++)
            {
                if (map.getValueAt(y,x) == 1)
                cMap[y][ x] = -2;//индикатор стены
                    else
                cMap[y][x] = -1;//индикатор еще не ступали сюда
            }
        cMap[position.getY()][position.getX()]=0;//Начинаем с финиша
        while (add==true)
        {
            add = false;
            for (y = 0; y < size; y++)
                for (x = 0; x < size; x++)
                {
                    if (cMap[y][x] == step)
                    {
                        //Ставим значение шага+1 в соседние ячейки (если они проходимы)
                        if (y - 1 >= 0 && cMap[y - 1][x] != -2 && cMap[y - 1][x] == -1)
                        cMap[y - 1][ x] = step + 1;
                        if (x - 1 >= 0 && cMap[y][ x - 1] != -2 && cMap[y][ x - 1] == -1)
                        cMap[y][ x - 1] = step + 1;
                        if (y + 1 < size && cMap[y + 1][ x] != -2 && cMap[y + 1][ x] == -1)
                        cMap[y + 1][ x] = step + 1;
                        if (x + 1 < size && cMap[y][ x + 1] != -2 && cMap[y][ x + 1] == -1)
                        cMap[y][x + 1] = step + 1;
                    }
                }
            step++;
            add = true;
            if (cMap[f.getPosition().getY()][f.getPosition().getX()] != -1)//решение найдено
            add = false;
            if (step > size*size)//решение не найдено
                add = false;
        }

            }


    @Override
    public void moveRight() {
        if(position.getX()+1<map.getSize()&&map.getValueAt(position.getY(),position.getX()+1)!=1) { //смотрит можно ли ходить
            position.setX(position.getX() + 1); //если да дает новыю позицую
            ball.setCenterX(position.getX() * map.getUnit() + map.getUnit() / 2);//меняет шарик
        }
        else System.out.println(invalid);
    }

    @Override
    public void moveLeft() {
        if(position.getX()-1>-1&&map.getValueAt(position.getY(),position.getX()-1)!=1) {
            position.setX(position.getX() - 1);
            ball.setCenterX(position.getX() * map.getUnit() + map.getUnit() / 2);
        }
        else System.out.println(invalid);

    }

    @Override
    public void moveUp() {
        if (position.getY() + 1 < map.getSize()&&map.getValueAt(position.getY()+1,position.getX())!=1) {
            position.setY(position.getY() + 1);
            ball.setCenterY(position.getY() * map.getUnit() + map.getUnit() / 2);
        }
        else System.out.println(invalid);

    }

    @Override
    public void moveDown() {
        if(position.getY()-1>-1&&map.getValueAt(position.getY()-1,position.getX())!=1) {
            position.setY(position.getY() - 1);
            ball.setCenterY(position.getY() * map.getUnit() + map.getUnit() / 2);
        }
        else System.out.println(invalid);

    }

    @Override
    public Position getPosition() {
        return position;
    }
}
