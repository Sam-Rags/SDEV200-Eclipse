package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// Create the grid pane, the text to be colored & the labels for each color
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setHgap(10.5);
			pane.setVgap(5.5);
			
			// create the text that will be manipulated
			Text colorText = new Text("Show Colors");
			colorText.setStyle("-fx-font: 24 arial;");
			
			// Create the labels for the rgbo field sliders
			Label redText = new Label("Red");
			redText.setStyle("-fx-font: 18 arial;");
			Label greenText = new Label("Green");
			greenText.setStyle("-fx-font: 18 arial;");
			Label blueText = new Label("Blue");
			blueText.setStyle("-fx-font: 18 arial;");
			Label opText = new Label("Opacity");
			opText.setStyle("-fx-font: 18 arial;");
			
			// Create the sliders for the color changing
			Slider slRed = new Slider(0, 1, .5);
			Slider slGreen = new Slider(0, 1, .5);
			Slider slBlue = new Slider(0, 1, .5);
			Slider slOpacity = new Slider(0, 1, .5);
			
			
			
			
			// Add all elements to the GridPane
			pane.add(colorText, 1, 0);
			pane.add(redText, 0, 1);
			pane.add(greenText, 0, 2);
			pane.add(blueText, 0, 3);
			pane.add(opText, 0, 4);
			pane.add(slRed, 1, 1);
			pane.add(slGreen, 1, 2);
			pane.add(slBlue, 1, 3);
			pane.add(slOpacity, 1, 4);
			
			
			// Set the scene
			Scene scene = new Scene(pane, 300, 200);
			primaryStage.setTitle("Exercise16_17");
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
