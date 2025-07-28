package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Main extends Application {
	
	private Label aboutLbl = new Label();
	private Label selectLbl = new Label();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Labels that prompt for input & display author copyright
			selectLbl.setText("Select Conversion type below");
			aboutLbl.setText("Unit Converter by Sam Ragsdale \u00a9 2025  ");
			
			// Button creation which will each open a new window of its respective type
			Button degreesConvert = new Button("Convert Temperature");
			Button weightConvert = new Button("Convert Weight");
			Button volumeConvert = new Button("Convert Volume");
			Button lengthConvert = new Button("Convert Length");
			

			/** The below 4 button action methods each instantiate a new
			 * window object which contains its own logic in ConversionWindow.
			 * Each Window object additionally creates an object of its respective
			 * conversion type */
			degreesConvert.setOnAction(new EventHandler<ActionEvent>() {
				ConversionWindow window = new ConversionWindow();
				@Override public void handle(ActionEvent e) {
				window.TemperatureConversionWindow();
				}
			});

			weightConvert.setOnAction(new EventHandler<ActionEvent>() {
				ConversionWindow window = new ConversionWindow();
				@Override public void handle(ActionEvent e) {
				window.WeightConversionWindow();
				}
			});
			
			volumeConvert.setOnAction(new EventHandler<ActionEvent>() {
				ConversionWindow window = new ConversionWindow();
				@Override public void handle(ActionEvent e) {
				window.VolumeConversion();
				}
			});
			
			lengthConvert.setOnAction(new EventHandler<ActionEvent>() {
				ConversionWindow window = new ConversionWindow();
				@Override public void handle(ActionEvent e) {
				window.LengthConversion();
				}
			});
			
			// Instantiation of the GridPane window
			GridPane root = new GridPane();
			root.add(degreesConvert, 1, 1);
			root.add(weightConvert, 1, 3);
			root.add(volumeConvert, 1, 4);
			root.add(lengthConvert, 1, 5);
			root.add(selectLbl, 1, 0);
			root.setColumnSpan(selectLbl, 3);
			root.add(aboutLbl, 3, 7);
			Scene scene = new Scene(root,400,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Deluxe Converter Program");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
