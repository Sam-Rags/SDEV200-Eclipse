package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane pane = new StackPane();
			Button btOK = new Button();
			btOK.setStyle("-fx-bordor-color: blue;");
			pane.getChildren().add(btOK);
			
			pane.setRotate(-45); // rotate pane 45 deg
			pane.setStyle("-fx-border-color: red;"
					+ "-fx-background-color: lightgray");
			
			Scene scene = new Scene(pane, 200, 200); // set scene
			primaryStage.setTitle("NodeStyleRotate"); // set stage title
			primaryStage.setScene(scene); // place the scene in the stage
			primaryStage.show(); // display the stage
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
