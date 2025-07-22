package application;

public class TemperatureConversion extends Conversion {
	
	


	public double convert(double inputValue) {
		// Performs math depending on what the input/output units are
		// this is validated in the main program which tightly controls which is which
		if (getInputUnit().equals("Celsius") && getOutputUnit().equals("Fahrenheit")) {
			return inputValue * 9 / 5 + 32;
		}
		else if (getInputUnit().equals("Fahrenheit") && getOutputUnit().equals("Celsius")) {
			return (inputValue - 32) / 1.8;
		}
		return inputValue;
	
	}
	
	//sets the input to Fahrenheit or Celsius
	public void setInputUnit(String s) {
		this.inputUnit = s;
	}
	
	// sets the output to Fahrenheit or Celsius
	public void setOutputUnit(String s) {
		this.outputUnit = s;
	}
	
	// returns the input string, Fahrenheit or Celsius
	String getInputUnit() {
		return inputUnit;
	}
	
	// returns the output string, Fahrenheit or Celsius
	String getOutputUnit() {
		return outputUnit;
	}
	
}
