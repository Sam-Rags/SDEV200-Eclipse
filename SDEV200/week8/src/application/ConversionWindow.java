package application;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConversionWindow {
	public void TemperatureConversionWindow() {
		TemperatureConversion converter = new TemperatureConversion();
		Stage stage = new Stage();
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 200, 200);
		stage.setScene(scene);
		stage.show();
		Label label = new Label();
		TextField text = new TextField();
		Button celtoFahr = new Button("C > F");
		Button fahrtoCel = new Button("F > C");
		Button compute = new Button("Compute");
		grid.add(label, 2, 2);
		grid.add(text, 1, 0);
		grid.add(celtoFahr, 1, 1);
		grid.add(fahrtoCel, 2, 1);
		grid.add(compute, 1, 2);
		
		fahrtoCel.setOnAction(e -> {converter.setInputUnit("Fahrenheit");
		converter.setOutputUnit("Celsius");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
});
		
		compute.setOnAction(f -> {
			double value;
			try {
				value = Double.parseDouble(text.getText());
				double result = converter.convert(value);
				label.setText("The value is: " + result + " " + converter.getOutputUnit());
			} catch (NumberFormatException e) {
				label.setText("Invalid input.");
			}
		 });
	}

}
