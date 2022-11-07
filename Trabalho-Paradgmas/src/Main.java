import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    
    Stage Window;
    Scene scene1, scene2, scene3;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Window = primaryStage;
       
        Button button1 = new Button ("\n                             Água                             \n ");
        button1.setOnAction(e -> Window.setScene(scene1));
        Button button2 = new Button ("\n                          Alimentos                           \n ");
        button2.setOnAction(e -> Window.setScene(scene2));
        Button button3 = new Button ("\n                         Medicamentos                         \n ");
        button3.setOnAction(e -> Window.setScene(scene3));
        
        HBox botoes1 = new HBox(10);
        botoes1.setAlignment(Pos.CENTER);
        botoes1.getChildren().addAll(button1, button2, button3);
        
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("app.fxml"));
        Parent parent1 = loader1.load();
        
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(botoes1, parent1);
        
        scene1 = new Scene(layout1, 1000, 750);
        scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        Button button4 = new Button ("\n                             Água                             \n ");
        button4.setOnAction(e -> Window.setScene(scene1));
        Button button5 = new Button ("\n                          Alimentos                           \n ");
        button5.setOnAction(e -> Window.setScene(scene2));
        Button button6 = new Button ("\n                         Medicamentos                         \n ");
        button6.setOnAction(e -> Window.setScene(scene3));
        
        HBox botoes2 = new HBox(10);
        botoes2.setAlignment(Pos.CENTER);
        botoes2.getChildren().addAll(button4, button5, button6);
        
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("app.fxml"));
        Parent parent2 = loader2.load();
        
        VBox layout2 = new VBox();
        layout2.getChildren().addAll(botoes2, parent2);
        
        scene2 = new Scene(layout2, 1000, 750);
        scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        Button button7 = new Button ("\n                             Água                             \n ");
        button7.setOnAction(e -> Window.setScene(scene1));
        Button button8 = new Button ("\n                          Alimentos                           \n ");
        button8.setOnAction(e -> Window.setScene(scene2));
        Button button9 = new Button ("\n                         Medicamentos                         \n ");
        button9.setOnAction(e -> Window.setScene(scene3));
        
        HBox botoes3 = new HBox(10);
        botoes3.setAlignment(Pos.CENTER);
        botoes3.getChildren().addAll(button7, button8, button9);
        
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("app.fxml"));
        Parent parent3 = loader3.load();
        
        VBox layout3 = new VBox();
        layout3.getChildren().addAll(botoes3, parent3);
        
        scene3 = new Scene(layout3, 1000, 750);
        scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        Window.setScene(scene1);
        Window.setTitle("TRABALHO DE PARADGMAS");
        Window.show();
    
    }
 
}
