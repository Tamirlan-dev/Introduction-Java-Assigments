package sample;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.*;

public class Quest {
    int x ;
    TextArea description;
    StackPane option;
    Text status;
    ArrayList<Question> list;
    ArrayList<Node> panes;
    ArrayList<ArrayList<RadioButton>> arr ;
    public Quest(int x, TextArea description, StackPane option, Text status, ArrayList<Question> list, ArrayList<Node> panes, ArrayList<ArrayList<RadioButton>> arr){
        this.x = x;
        this.description = description;
        this.option = option;
        this.status = status;
        this.list = list;
        this.panes = panes;
        this.arr = arr;
    }
    public  ArrayList<RadioButton> toTest(Test test){
        ToggleGroup group = new ToggleGroup();
        ArrayList<RadioButton> list = new ArrayList<>();
        for(int i = 0; i<3;i++){
            RadioButton radiobutton = new RadioButton(test.getOptionAt(i));
            list.add(radiobutton);
            radiobutton.setToggleGroup(group);
        }
        RadioButton rd = new RadioButton(test.getAnswer());
        list.add(rd);
        Collections.shuffle(list);
        rd.setToggleGroup(group);
        return list;
    }
    public void toNext(){
        if(x < (list.size()-1)){
            x++;
            description.setText(list.get(x).getDescription().replace("{blank}", "_______"));
            option.getChildren().remove(panes.get(x-1));
            option.getChildren().add((Node)panes.get(x));
            status.setText("Status: " + (x+1) + "/" + list.size() + "questions.");}
        else{status.setText("Status: " + (x+1) + "/" + list.size() + "questions.\nEnd of Quiz!");}
    }
    public  void toPrevious(){
        if(x >=1){
            x--;
            description.setText(list.get(x).getDescription().replace("{blank}", "_______"));
            option.getChildren().remove(panes.get(x+1));
            option.getChildren().add((Node)panes.get(x));
            status.setText("Status: " + (x+1) + "/" + list.size() + "questions.");
        }else{status.setText("Status: " + (x+1) + "/" + list.size() + "questions.\nStart of Quiz!");}
    }
    public void options(){
        for(Question i: list){
            if(i instanceof Test){
                ArrayList<RadioButton> radioButtons = this.toTest((Test)i);
                arr.add(radioButtons);
                VBox vbox = new VBox(20);
                for(RadioButton j: radioButtons){vbox.getChildren().add(j);}
                panes.add(vbox);
            }
            if(i instanceof FillIn){
                TextField textField = new TextField();
                panes.add(textField);
            }
        }
    }
}
