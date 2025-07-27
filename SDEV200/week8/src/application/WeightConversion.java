package application;


// This is the weight conversion class which handles the math and methods of weight conversions
public class WeightConversion extends Conversion {

	
			
		public double convert(double inputValue) {
			// Performs math depending on what the input/output units are
			// this is validated in the main program which tightly controls which is which
			if (getInputUnit().equals("Pounds") && getOutputUnit().equals("Kilograms")) {
				return inputValue * 0.453592;
			}
			else if (getInputUnit().equals("Kilograms") && getOutputUnit().equals("Pounds")) {
				return inputValue * 2.20462 ;
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


