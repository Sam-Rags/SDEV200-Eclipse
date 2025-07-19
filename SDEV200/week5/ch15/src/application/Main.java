package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/** create a stack pane, a circle w/ default black
			* outline & white fill & add the circle to the pane */
			StackPane pane = new StackPane();
			Circle circle = new Circle(100);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
			circle.setStyle("-fx-fill-color: black");
			pane.getChildren().add(circle);
			
			// set's the circle object's fill to BLACK when mouse pressed on the pane
			pane.setOnMousePressed(e -> circle.setFill(Color.BLACK));
			
			// set's the circle object's fill to WHITE when mouse released on the pane
			pane.setOnMouseReleased(e -> circle.setFill(Color.WHITE));
					
			// Create a scene & place/show the pane inside of it at 400x300 resolution
			Scene scene = new Scene(pane, 400, 300);
			primaryStage.setTitle("Exercise15_7");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


