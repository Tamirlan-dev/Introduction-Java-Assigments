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
      //  MyPlayer myPlayer = new MyPlayer(map);//создает игрока как шарика
        MyBotPlayer myBotPlayer=new MyBotPlayer(map);
        Food food = new Food(map,myBotPlayer);//еду создают
        pane.getChildren().add(map);//добавляют карту
        //двигается
        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case E:
                    myBotPlayer.feed(food);
                    break;
                case F:
                    myBotPlayer.eat(food);
                    break;
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
