package sample;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.geometry.*;

public class QuizViewer extends Application {
    private File file;
    private static  int x=0;
    private Quest quest;

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane start = new StackPane();
        Scene scene = new Scene(start, 500, 380);
        primaryStage.setTitle("Project 2");
        primaryStage.setScene(scene);
        Button choose = new Button("Choose");
        start.getChildren().add(choose);
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(5, 5, 5, 5));
        Scene quizScene = new Scene(pane, 500, 380);
        choose.setOnAction(e ->{
            try{
                JFileChooser fileChooser = new JFileChooser();
                int n = fileChooser.showDialog(null, "Open File");
                if(n == fileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                    Quiz quiz = Quiz.loadFromFile(file.toString());
                    ArrayList<Question> list = quiz.getQuestions();
                    Collections.shuffle(list);
                    TextArea description = new TextArea();
                    description.setWrapText(true);
                    description.setEditable(false);
                    description.setPrefWidth(400);
                    description.setPrefHeight(100);
                    description.setPadding(new Insets(5, 5, 5, 5));
                    StackPane option = new StackPane();
                    option.setPrefWidth(400);
                    option.setPrefHeight(120);
                    pane.getChildren().addAll(description, option);
                    ArrayList<ArrayList<RadioButton>> arr = new ArrayList<>();
                    ArrayList<Node> panes = new ArrayList<>();
                    Text status = new Text("Status: " + (x+1) + "/" + list.size() + "questions.");
                    quest = new Quest(x, description, option, status, list, panes, arr);
                    quest.options();
                    description.setText(list.get(x).getDescription().replace("{blank}","_______"));
                    option.getChildren().add((Node)panes.get(x));
                    Button previous = new Button("Previous");
                    Button next = new Button("Next");
                    Button check = new Button("Check");
                    next.setOnAction(er ->{quest.toNext();});
                    previous.setOnAction(er->{quest.toPrevious();});
                    check.setOnAction(er ->{Dialog.startResult(new Stage(), list, arr, panes);});
                    HBox buttons = new HBox(20);
                    buttons.setAlignment(Pos.CENTER);
                    buttons.getChildren().addAll(status,previous, next, check);
                    pane.getChildren().add(buttons);
                    primaryStage.setScene(quizScene);
                }

            }catch(InvalidQuizFormatException ex){Dialog.startException(new Stage());}});
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
