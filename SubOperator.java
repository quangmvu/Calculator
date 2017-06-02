
public class SubOperator extends Operator{

	public SubOperator(){
		super(1);
	}
	
	@Override
	double evaluate(double a, double b){
		return b - a;
	}
}
