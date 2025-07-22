package application;

public abstract class Conversion {

	protected String inputUnit;
	protected String outputUnit;
	
	// Handles the math between converted types, overridden in extending classes
	public Conversion() {
		 this.inputUnit = inputUnit;
		 this.outputUnit = outputUnit;
	}
	
	void setUnit(String s) {
		this.inputUnit = s;
	}
	
	String getInputUnit() {
		return inputUnit;
	}
	
	String getOutputUnit() {
		return outputUnit;
	}
	
	

}


