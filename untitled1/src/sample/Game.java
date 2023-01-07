package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
    private static String words;

    @Override
    public void start(Stage stage) throws Exception {
        Map map = new Map(words); //создает карту
        Pane pane = new Pane();
        MyPlayer myPlayer = new MyPlayer(map);//создает игрока как шарика
        Food food = new Food(map, myPlayer);//еду создают
        pane.getChildren().add(map);//добавляют карту
        //двигается
        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case D:
                    myPlayer.moveRight();
                    break;
                case A:
                    myPlayer.moveLeft();
                    break;
                case W:
                    myPlayer.moveUp();
                    break;
                case S:
                    myPlayer.moveDown();
            }
        });

        stage.setScene(new Scene(pane, 800, 800));
        stage.show();
        pane.requestFocus();
    }

    public static void main(String[] args) {
        words = args[0] + " " + args[1];
        Game.launch();
    }

}
