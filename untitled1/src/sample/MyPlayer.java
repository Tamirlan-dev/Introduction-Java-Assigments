package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyPlayer implements Player {
    private String invalid="Invalid position!";
    private Circle ball;
    private Map map;
    private Position position;
    MyPlayer(Map map){
        this.map=map;
        //создает позицию для шарика
        position=new Position(map.getStartPosition().getY(),map.getStartPosition().getX());
        //создает шарик
        ball=new Circle(position.getX()*map.getUnit()+map.getUnit()/2,position.getY()*map.getUnit()+map.getUnit()/2,map.getUnit()/2);
        ball.setFill(Color.RED);
        ball.setStroke(Color.BLACK);
        map.getChildren().add(ball);
    }
     // двигает направо
    @Override
    public void moveRight() {
        if(position.getX()+1<map.getSize()&&map.getValueAt(position.getY(),position.getX()+1)!=1) { //смотрит можно ли ходить
            position.setX(position.getX() + 1); //если да дает новыю позицую
            ball.setCenterX(position.getX() * map.getUnit() + map.getUnit() / 2);//меняет шарик
        }
        else System.out.println(invalid);

    }
    //двигает налево
    @Override
    public void moveLeft() {
        if(position.getX()-1>-1&&map.getValueAt(position.getY(),position.getX()-1)!=1) {
            position.setX(position.getX() - 1);
            ball.setCenterX(position.getX() * map.getUnit() + map.getUnit() / 2);
        }
        else System.out.println(invalid);
    }
    //двигает верх
    @Override
    public void moveDown() {
        if (position.getY() + 1 < map.getSize()&&map.getValueAt(position.getY()+1,position.getX())!=1) {
            position.setY(position.getY() + 1);
            ball.setCenterY(position.getY() * map.getUnit() + map.getUnit() / 2);
        }
        else System.out.println(invalid);
    }
    //двигате вниз
    @Override
    public void moveUp() {
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
