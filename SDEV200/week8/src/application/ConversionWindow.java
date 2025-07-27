package application;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/** The below 4 classes do more or less the same thing,
 * they each create a window & populate the logic from the respective Conversion classes
 * and allow user input as well as outputting results of conversions */
public class ConversionWindow {
	public void TemperatureConversionWindow() {
		TemperatureConversion converter = new TemperatureConversion();
		Stage stage = new Stage();
		GridPane grid = new GridPane();
		Label aboutLbl = new Label();
		aboutLbl.setText("Unit Converter by Sam Ragsdale \u00a9 2025");
		Scene scene = new Scene(grid, 415, 180);
		stage.setScene(scene);
		stage.setTitle("Temperature Conversion");
		stage.setResizable(false);
		stage.show();
		Label label = new Label();
		label.setText("Select a conversion method to begin");
		TextField text = new TextField();
		Button celtoFahr = new Button("Celsius to Fahrenheit");
		Button fahrtoCel = new Button("Fahrenheit to Celsius");
		Button compute = new Button("Compute");
		grid.add(label, 0, 0);
		grid.setColumnSpan(label, 2);
		grid.add(text, 0, 1);
		grid.add(celtoFahr, 0, 2);
		grid.add(fahrtoCel, 0, 3);
		grid.add(compute, 1, 1);
		grid.add(aboutLbl, 1, 7);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		fahrtoCel.setOnAction(e -> {converter.setInputUnit("Fahrenheit");
		converter.setOutputUnit("Celsius");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
});
		celtoFahr.setOnAction(e -> {converter.setInputUnit("Celsius");
		converter.setOutputUnit("Fahrenheit");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
		});
		
		compute.setOnAction(f -> {
			double value;
			String stringValue;
			try {
				value = Double.parseDouble(text.getText());
				double result = converter.convert(value);
				stringValue = String.format("%.2f", result);
				label.setText(value + " " +converter.getInputUnit() + " is " + stringValue + " " + converter.getOutputUnit());
			} catch (NumberFormatException e) {
				label.setText("Invalid input.");
			}
		 });
	}

	
	public void WeightConversionWindow() {
		WeightConversion converter = new WeightConversion();
		Stage stage = new Stage();
		GridPane grid = new GridPane();
		Label aboutLbl = new Label();
		aboutLbl.setText("Unit Converter by Sam Ragsdale \u00a9 2025");
		Scene scene = new Scene(grid, 415, 180);
		stage.setTitle("Weight Conversion");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		Label label = new Label();
		label.setText("Select a conversion method to begin");
		TextField text = new TextField();
		Button lbToKg = new Button("Pounds to Kilograms");
		Button kgToLb = new Button("Kilograms to Pounds");
		Button compute = new Button("Compute");
		grid.add(label, 0, 0);
		grid.setColumnSpan(label, 2);
		grid.add(text, 0, 1);
		grid.add(lbToKg, 0, 2);
		grid.add(kgToLb, 0, 3);
		grid.add(compute, 1, 1);
		grid.add(aboutLbl, 1, 7);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		lbToKg.setOnAction(e -> {converter.setInputUnit("Pounds");
		converter.setOutputUnit("Kilograms");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
});
		
		kgToLb.setOnAction(e  -> {converter.setInputUnit("Kilograms");
		converter.setOutputUnit("Pounds");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
		});
		
		compute.setOnAction(f -> {
			double value;
			String stringResult;
			try {
				value = Double.parseDouble(text.getText());
				double result = converter.convert(value);
				stringResult = String.format("%.2f", result);
				label.setText(text.getText() + " " + converter.getInputUnit() + " is " + 
				stringResult + " " + converter.getOutputUnit());
			} catch (NumberFormatException e) {
				label.setText("Invalid input.");
			}
		 });
	}

	public void VolumeConversion() {
		VolumeConversion converter = new VolumeConversion();
		Stage stage = new Stage();
		GridPane grid = new GridPane();
		Label aboutLbl = new Label();
		aboutLbl.setText("Unit Converter by Sam Ragsdale \u00a9 2025");
		Scene scene = new Scene(grid, 415, 180);
		stage.setTitle("Volume Conversion");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		Label label = new Label();
		label.setText("Select a conversion method to begin");
		TextField text = new TextField();
		Button litersToGal = new Button("Liters to Gallons");
		Button galToLiters = new Button("Gallons to Liters");
		Button compute = new Button("Compute");
		grid.add(label, 0, 0);
		grid.setColumnSpan(label,2);
		grid.add(text, 0, 1);
		grid.add(litersToGal, 0, 2);
		grid.add(galToLiters, 0, 3);
		grid.add(compute, 1, 1);
		grid.add(aboutLbl, 1, 7);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		litersToGal.setOnAction(e -> {converter.setInputUnit("Liters");
		converter.setOutputUnit("Gallons");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
});
		
		galToLiters.setOnAction(e  -> {converter.setInputUnit("Gallons");
		converter.setOutputUnit("Liters");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
		});
		
		compute.setOnAction(f -> {
			double value;
			String stringResult;
			try {
				value = Double.parseDouble(text.getText());
				double result = converter.convert(value);
				stringResult = String.format("%.2f", result);
				label.setText(text.getText() + " " + converter.getInputUnit() +  " is " + stringResult + " " + converter.getOutputUnit());
			} catch (NumberFormatException e) {
				label.setText("Invalid input.");
			}
		 });
	}
	
	public void LengthConversion() {
		LengthConversion converter = new LengthConversion();
		Stage stage = new Stage();
		GridPane grid = new GridPane();
		Label aboutLbl = new Label();
		aboutLbl.setText("Unit Converter by Sam Ragsdale \u00a9 2025");
		Scene scene = new Scene(grid, 415, 180);
		stage.setTitle("Length Conversion");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		Label label = new Label();
		label.setText("Select a conversion method to begin");
		TextField text = new TextField();
		Button feetToMeters = new Button("Feet to Meters");
		Button metersToFeet = new Button("Meters to Feet");
		Button compute = new Button("Compute");
		grid.add(label, 0, 0);
		grid.setColumnSpan(label, 2);
		grid.add(text, 0, 1);
		grid.add(feetToMeters, 0, 2);
		grid.add(metersToFeet, 0, 3);
		grid.add(compute, 1, 1);
		grid.add(aboutLbl, 1, 7);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		feetToMeters.setOnAction(e -> {converter.setInputUnit("Feet");
		converter.setOutputUnit("Meters");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
});
		
		metersToFeet.setOnAction(e  -> {converter.setInputUnit("Meters");
		converter.setOutputUnit("Feet");
		label.setText("Converting from " + converter.getInputUnit() + " to "
				+ converter.getOutputUnit());
		});
		
		compute.setOnAction(f -> {
			double value;
			String stringResult;
			try {
				value = Double.parseDouble(text.getText());
				double result = converter.convert(value);
				stringResult = String.format("%.2f", result);
				label.setText(text.getText() + " " + converter.getInputUnit() +  " is " + stringResult + " " + converter.getOutputUnit());
			} catch (NumberFormatException e) {
				label.setText("Invalid input.");
			}
		 });
	}
	
	
}
