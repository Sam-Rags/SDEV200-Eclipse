package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = new HBox(10);
			pane.setPadding(new Insets(5, 5, 5, 5));
			Image image = new Image("file:/us-flag.gif");
			pane.getChildren().add(pane);
			
			ImageView imageView2 = new ImageView(image);
			imageView2.setFitHeight(100);
			imageView2.setFitWidth(100);
			pane.getChildren().add(imageView2);
			
			ImageView imageView3= new ImageView(image);
			imageView3.setRotate(90);
			pane.getChildren().add(imageView3);
			
			Scene scene = new Scene(pane);
			primaryStage.setTitle("ShowImage");
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
