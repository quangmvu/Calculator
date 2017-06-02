
public class DivOperator extends Operator{

	public DivOperator(){
		super(2);
	}
	
	@Override
	double evaluate(double a, double b){
		return b / a;
	}
}
