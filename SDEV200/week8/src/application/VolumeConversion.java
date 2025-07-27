package application;

// The volume conversion class which handles the methods & math of converting volumes
public class VolumeConversion extends Conversion {

	public double convert(double inputValue) {
		// Performs math depending on what the input/output units are
		// this is validated in the main program which tightly controls which is which
		if (getInputUnit().equals("Liters") && getOutputUnit().equals("Gallons")) {
			return inputValue * 0.2641720524;
		}
		else if (getInputUnit().equals("Gallons") && getOutputUnit().equals("Liters")) {
			return inputValue * 3.785411784 ;
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
