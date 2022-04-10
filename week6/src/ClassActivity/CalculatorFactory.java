package ClassActivity;

public class CalculatorFactory {
	public Calculate Operation(char o) {
		switch(o) {
		case '+':
			return new CalcPlus();
		case '-':
			return new CalcMinus();
		default:
			return null;
		}
	}

}
