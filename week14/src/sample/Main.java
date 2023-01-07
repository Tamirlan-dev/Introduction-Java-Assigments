package sample;
//
//import javafx.animation.PathTransition;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Border;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.shape.Line;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage){
//        BorderPane borderPane=new BorderPane();
//        Pane pane=new Pane();
//        ImageView imageView = new ImageView("sample\\kz1.jpg");
//        pane.getChildren().add(imageView);
//        Pane newpane=new Pane();
//        newpane.getChildren().add(imageView);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    while (true){
//                        Platform.runLater(new Runnable() {
//
//                                              @Override
//                                              public void run() {
//                                                  imageView.setX(imageView.getX()+10);
//                                                  imageView.setY(imageView.getY()+10);
//                                              }
//                                          });
//                        Thread.sleep(10000);
//                    }
//
//                }
//                catch (Exception ex){
//                }
//            }
//        }).start();
//        PathTransition pt = new PathTransition(Duration.millis(10000), new Line(0, 1000, 0, 0),imageView);
//        pt.setCycleCount(5);
//        pt.play();
//        borderPane.setLeft(pane);
//        borderPane.setRight(newpane);
//        Scene scene = new Scene(borderPane, 800, 800);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("FlagRisingAnimation");
//        primaryStage.show();
//    }
//}
