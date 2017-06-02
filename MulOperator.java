
public class MulOperator extends Operator{
	
	public MulOperator(){
		super(2);
	}
	
	@Override
	double evaluate(double a, double b){
		return a * b;
	}
}
