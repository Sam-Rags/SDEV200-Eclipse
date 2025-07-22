package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Main extends Application {
	
	private Label lblStatus = new Label();
	private TextField textInput = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button tempButton = new Button("Convert");
			Button celsiusButton = new Button("Celsius");
			Button fahrenheitButton = new Button("Fahrenheit");
			Button tempConvert = new Button("Convert Temperature");
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
			
			tempConvert.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
				Stage stage = new Stage();
				stage.setWidth(400);
				stage.setHeight(400);
				stage.show();
			}
			});
			
			Scene scene = new Scene(root,400,400, Color.LIGHTBLUE);
			root.setCenter(tempButton);
			root.setBottom(lblStatus);
			root.setTop(textInput);
			root.setRight(fahrenheitButton);
//			root.setLeft(celsiusButton);
			root.setLeft(tempConvert);
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
