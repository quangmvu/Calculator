
public class ExpOperator extends Operator{
	
	public ExpOperator(){
		super(3);
	}
	
	@Override
	double evaluate(double a, double b){
		return Math.pow(b, a);
	}
}
