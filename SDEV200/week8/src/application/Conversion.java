package application;

// Main abstract class Conversion which is extended by the 4 Conversion types
public abstract class Conversion {

	protected String inputUnit;
	protected String outputUnit;
	
	// Handles the math between converted types, overridden in extending classes
	public Conversion() {
		 this.inputUnit = inputUnit;
		 this.outputUnit = outputUnit;
	}
	
	void setInputUnit(String s) {
		this.inputUnit = s;
	}
	
	void setOutputUnit(String s) {
		this.outputUnit = s;
	}
	
	String getInputUnit() {
		return inputUnit;
	}
	
	String getOutputUnit() {
		return outputUnit;
	}
	
	

}


