
public class AddOperator extends Operator{

	public AddOperator(){
		super(1);
	}
	
	@Override
	double evaluate(double a, double b) {
		return a + b;
	}
}
