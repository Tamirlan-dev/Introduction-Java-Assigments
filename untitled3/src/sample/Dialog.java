    package sample;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import java.util.*;
public class Dialog {
    public static void startException(Stage stage) {
        BorderPane border = new BorderPane();
        Label label = new Label("InvalidQuizFormatException", new ImageView(new Image("sample\\x.jpg")));
        border.setTop(label);
        Label text = new Label("The file selected does not fit the requirements for a \nstandart Quiz text file format....");
        Button ok = new Button("OK");
        ok.setPrefWidth(80);
        ok.setPrefHeight(20);
        border.setCenter(text);
        border.setBottom(ok);
        border.setAlignment(text, Pos.CENTER);
        border.setAlignment(label, Pos.CENTER);
        border.setAlignment(ok, Pos.BOTTOM_RIGHT);
        ok.setOnAction(er -> {
            stage.close();
        });
        border.setPadding(new Insets(10, 10, 10, 10));
        stage.setResizable(false);
        Scene scene2 = new Scene(border, 350, 150);
        stage.setTitle("QuizViewer: Error");
        stage.setScene(scene2);
        stage.show();
    }

    public static void startResult(Stage stage, ArrayList<Question> list, ArrayList<ArrayList<RadioButton>> arr, ArrayList<Node> panes) {
        int count = 0;
        int x = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Test) {
                for (RadioButton j : arr.get(x)) {
                    if (j.isSelected() && j.getText().equals(list.get(i).getAnswer())) {
                        count++;
                    }
                }
                x++;
            }
            if (list.get(i) instanceof FillIn) {
                if (((TextField) panes.get(i)).getText().toLowerCase().equals(list.get(i).getAnswer().toLowerCase())) {
                    count++;
                }
            }
        }
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 10, 10, 10));
        Label text1 = new Label("Number of correct answers " + count + "/" + list.size());
        Label text2 = new Label("You may try again.");
        Button ok = new Button("OK");
        ok.setPrefWidth(80);
        ok.setPrefHeight(20);
        border.setTop(text1);
        border.setAlignment(text1, Pos.CENTER);
        border.setCenter(text2);
        border.setAlignment(text2, Pos.CENTER);
        border.setBottom(ok);
        border.setAlignment(ok, Pos.BOTTOM_RIGHT);
        ok.setOnAction(et -> {
            stage.close();
        });
        Scene scene1 = new Scene(border, 250, 100);
        stage.setTitle("QuizViewer: Results");
        stage.setScene(scene1);
        stage.show();
    }
}