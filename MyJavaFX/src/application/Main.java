package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Create a pane to hold the circle
			Pane pane = new Pane();
			
			// Create a circle and set its properties
			Circle circle = new Circle();
			/** Binder properties as below are generally named by
			 * propertyNameProperty binds with a source in the syntax:
			 * target.bind(source); */
			circle.centerXProperty().bind(pane.widthProperty().divide(2));
			circle.centerYProperty().bind(pane.heightProperty().divide(2));
			circle.setRadius(50);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
			pane.getChildren().add(circle);
			
			// Create a scene and place it in the stage
			Scene scene = new Scene(pane, 400, 400); // create the scene
			primaryStage.setTitle("ShowCircleCentered"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
