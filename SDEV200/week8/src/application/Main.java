package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;


public class Main extends Application {
	
	private Label lblStatus = new Label();
	private Label aboutLbl = new Label();
	private TextField textInput = new TextField();
	private Label selectLbl = new Label();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			selectLbl.setText("Select Conversion type below");
			aboutLbl.setText("Unit Converter by Sam Ragsdale \u00a9 2025");
			Button tempButton = new Button("Convert");
			Button celsiusButton = new Button("Celsius");
			Button fahrenheitButton = new Button("Fahrenheit");
			Button degreesConvert = new Button("Convert Temperature");
			Button weightConvert = new Button("Convert Weight");
			Button volumeConvert = new Button("Convert Volume");
			Button lengthConvert = new Button("Convert Length");
			TemperatureConversion converter = new TemperatureConversion();
			
			// This button invokes the convert method of the TemperatureConversion object
			// and returns the mathematical output of the conversion C to F or F to C.
			tempButton.setOnAction(f -> {
				double value;
				try {
					value = Double.parseDouble(textInput.getText());
					double result = converter.convert(value);
					lblStatus.setText("The value is: " + result + " " + converter.getOutputUnit());
				} catch (NumberFormatException e) {
					lblStatus.setText("Invalid input.");
				}
			 });
			// This button changes the conversion to be C > F & states on the label which way it's going
			celsiusButton.setOnAction(e -> {converter.setInputUnit("Celsius");
											converter.setOutputUnit("Fahrenheit");
											lblStatus.setText("Converting from " + converter.getInputUnit() + " to " 
													+ converter.getOutputUnit());
			});
			
			// This button changes the conversion to be F > C & states on the label what it is converting			
			fahrenheitButton.setOnAction(e -> {converter.setInputUnit("Fahrenheit");
												converter.setOutputUnit("Celsius");
												lblStatus.setText("Converting from " + converter.getInputUnit() + " to "
														+ converter.getOutputUnit());
			});
			
			degreesConvert.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
				Stage stage = new Stage();
				stage.setWidth(400);
				stage.setHeight(400);
				stage.show();
			}
			});
			GridPane root = new GridPane();
			root.add(degreesConvert, 1, 1);
			root.add(weightConvert, 1, 3);
			root.add(volumeConvert, 1, 4);
			root.add(lengthConvert, 1, 5);
			root.add(selectLbl, 1, 0);
			root.setColumnSpan(selectLbl, 2);
			root.add(aboutLbl, 3, 7);
			Scene scene = new Scene(root,400,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
