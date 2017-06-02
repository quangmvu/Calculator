
public abstract class Operator{
	
	private int priority;
	
	public Operator(int p){
		priority = p;
	}
	
	public int getPriority(){
		return priority;	
	}

	abstract double evaluate(double a, double b);
}
