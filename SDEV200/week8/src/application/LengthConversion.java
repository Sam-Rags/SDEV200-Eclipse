package application;

// Length conversion class for converting between feet & meters bidirectionally
public class LengthConversion extends Conversion {

	public double convert(double inputValue) {
		// Performs math depending on what the input/output units are
		// this is validated in the main program which tightly controls which is which
		if (getInputUnit().equals("Feet") && getOutputUnit().equals("Meters")) {
			return inputValue / 3.28084;
		}
		else if (getInputUnit().equals("Meters") && getOutputUnit().equals("Feet")) {
			return inputValue * 3.28084 ;
		}
		return inputValue;
	
	}
	
	// Sets the input unit to pounds or kilograms
	public void setInputUnit(String s) {
		this.inputUnit = s;
	}
	
	// sets the output to pounds or kilograms
	public void setOutputUnit(String s) {
		this.outputUnit = s;
	}
	
	// returns the set input, pounds or kilograms
	String getInputUnit() {
		return inputUnit;
	}
	
	// returns the output string, pounds or kilograms
	String getOutputUnit() {
		return outputUnit;
	}
	
	public String toString() {
		return "The output unit is " + getOutputUnit() + ", and the input unit is: "
				+ getInputUnit();
	}

}
