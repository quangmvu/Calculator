import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator extends JFrame{

	private static final int CALC_WIDTH = 300;
	private static final int CALC_HEIGHT = 200;
	private static final int OUTPUT_SIZE = 0;

	private JButton jbNum1, jbNum2, jbNum3, jbNum4, jbNum5, jbNum6, jbNum7, jbNum8, jbNum9, jbAdd,
	jbSub, jbMul, jbDiv, jbLParenthesis, jbRParenthesis, jbExp, jbClear, jbNum0, jbDot, jbEqual;
	private JTextField jtfOutput;

	AddOperator add = new AddOperator();
	SubOperator sub = new SubOperator();
	MulOperator mul = new MulOperator();
	DivOperator div = new DivOperator();
	ExpOperator exp = new ExpOperator();
	EqualOperator equal = new EqualOperator();
	LeftParenOperator leftP = new LeftParenOperator();
	
	public Calculator(){
		this.setSize(CALC_WIDTH, CALC_HEIGHT);

		jtfOutput = new JTextField(OUTPUT_SIZE);
		jbNum1 = new JButton("1");
		jbNum2 = new JButton("2");
		jbNum3 = new JButton("3");
		jbNum4 = new JButton("4");
		jbNum5 = new JButton("5");
		jbNum6 = new JButton("6");
		jbNum7 = new JButton("7");
		jbNum8 = new JButton("8");
		jbNum9 = new JButton("9");
		jbAdd = new JButton("+");
		jbSub = new JButton("-");
		jbMul = new JButton("*");
		jbDiv = new JButton("/");
		jbLParenthesis = new JButton("(");
		jbRParenthesis = new JButton(")");
		jbExp = new JButton("^");
		jbClear = new JButton("C");
		jbNum0 = new JButton("0");
		jbDot = new JButton(".");
		jbEqual = new JButton("=");

		//panel for the keypad
		JPanel keypad = new JPanel();
		keypad.setLayout(new GridLayout(4, 5, 3, 3));

		//adding all buttons to the keypad
		keypad.add(jbNum1);
		keypad.add(jbNum2);
		keypad.add(jbNum3);
		keypad.add(jbAdd);
		keypad.add(jbSub);
		keypad.add(jbNum4);
		keypad.add(jbNum5);
		keypad.add(jbNum6);
		keypad.add(jbMul);
		keypad.add(jbDiv);
		keypad.add(jbNum7);
		keypad.add(jbNum8);
		keypad.add(jbNum9);
		keypad.add(jbLParenthesis);
		keypad.add(jbRParenthesis);
		keypad.add(jbNum0);
		keypad.add(jbDot);
		keypad.add(jbEqual);
		keypad.add(jbExp);
		keypad.add(jbClear);

		//panel for the calculator
		JPanel calculator = new JPanel();
		calculator.setLayout(new BorderLayout());
		calculator.add(jtfOutput, BorderLayout.NORTH);
		calculator.add(keypad);
		jtfOutput.setEditable(false);
		jtfOutput.setBackground(Color.WHITE);
		
		this.add(calculator);

		KeypadListener listener = new KeypadListener();
		//adding action listener to buttons
		jbNum1.addActionListener(listener);
		jbNum2.addActionListener(listener);
		jbNum3.addActionListener(listener);
		jbAdd.addActionListener(listener);
		jbSub.addActionListener(listener);
		jbNum4.addActionListener(listener);
		jbNum5.addActionListener(listener);
		jbNum6.addActionListener(listener);
		jbMul.addActionListener(listener);
		jbDiv.addActionListener(listener);
		jbNum7.addActionListener(listener);
		jbNum8.addActionListener(listener);
		jbNum9.addActionListener(listener);
		jbLParenthesis.addActionListener(listener);
		jbRParenthesis.addActionListener(listener);
		jbNum0.addActionListener(listener);
		jbDot.addActionListener(listener);
		jbEqual.addActionListener(listener);
		jbExp.addActionListener(listener);
		jbClear.addActionListener(listener);	
	}

	//action listener for buttons
	private class KeypadListener implements ActionListener
	{
		Stack<Object> operator = new Stack<Object>();
		Stack<Double> operand = new Stack<Double>();
		StringBuilder number = new StringBuilder();

		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == jbNum1){
				jtfOutput.setText(jtfOutput.getText() + "1");
				number.append("1");
			}
			else if(e.getSource() == jbNum2){
				jtfOutput.setText(jtfOutput.getText() + "2");
				number.append("2");
			}
			else if(e.getSource() == jbNum3){
				jtfOutput.setText(jtfOutput.getText() + "3");
				number.append("3");
			}
			else if(e.getSource() == jbAdd){
				jtfOutput.setText(jtfOutput.getText() + "+");
				pushDouble(number, operand);
				number.setLength(0);
				pushOrPop("+", operator, operand);
			}
			else if(e.getSource() == jbSub){
				jtfOutput.setText(jtfOutput.getText() + "-");
				try{
					operand.push(Double.parseDouble(number.toString()));
					number.setLength(0);
					pushOrPop("-", operator, operand);
				}
				catch(NumberFormatException nfe){
					number.append("-");
				}		
			}
			else if(e.getSource() == jbNum4){
				jtfOutput.setText(jtfOutput.getText() + "4");
				number.append("4");
			}
			else if(e.getSource() == jbNum5){
				jtfOutput.setText(jtfOutput.getText() + "5");
				number.append("5");
			}
			else if(e.getSource() == jbNum6){
				jtfOutput.setText(jtfOutput.getText() + "6");
				number.append("6");
			}
			else if(e.getSource() == jbMul){
				jtfOutput.setText(jtfOutput.getText() + "*");
				pushDouble(number, operand);
				number.setLength(0);
				pushOrPop("*", operator, operand);
			}
			else if(e.getSource() == jbDiv){
				jtfOutput.setText(jtfOutput.getText() + "/");
				pushDouble(number, operand);
				number.setLength(0);
				pushOrPop("/", operator, operand);
			}
			else if(e.getSource() == jbNum7){
				jtfOutput.setText(jtfOutput.getText() + "7");
				number.append("7");
			}
			else if(e.getSource() == jbNum8){
				jtfOutput.setText(jtfOutput.getText() + "8");
				number.append("8");
			}
			else if(e.getSource() == jbNum9){
				jtfOutput.setText(jtfOutput.getText() + "9");
				number.append("9");
			}
			else if(e.getSource() == jbLParenthesis){
				jtfOutput.setText(jtfOutput.getText() + "(");
				pushOrPop("(", operator, operand);
			}
			else if(e.getSource() == jbRParenthesis){
				jtfOutput.setText(jtfOutput.getText() + ")");
				pushDouble(number, operand);
				number.setLength(0);
				pushOrPop(")", operator, operand);
			}
			else if(e.getSource() == jbNum0){
				jtfOutput.setText(jtfOutput.getText() + "0");
				number.append("0");
			}
			else if(e.getSource() == jbDot){
				jtfOutput.setText(jtfOutput.getText() + ".");
				number.append(".");
			}
			else if(e.getSource() == jbExp){
				pushDouble(number, operand);
				number.setLength(0);
				jtfOutput.setText(jtfOutput.getText() + "^");
				pushOrPop("^", operator, operand);
			}
			else if(e.getSource() == jbClear){
				jtfOutput.setText("");
				number.setLength(0);
				operand.clear();
				operator.clear();
			}
			else if(e.getSource() == jbEqual){
				pushDouble(number, operand);
				number.setLength(0);
				pushOrPop("=", operator, operand);
				if(operand.peek() % 1 == 0){
					jtfOutput.setText("" + operand.peek().intValue());
				}
				else{
					jtfOutput.setText("" + operand.peek());		
				}
			}
		}
	}

	//try to see to if a double number is available to push
	public void pushDouble(StringBuilder num, Stack<Double> number){
		try{
			number.push(Double.parseDouble(num.toString()));
		}
		catch(NumberFormatException nfe){
			
		}	
	}

	//adding operators and numbers to the appropriate stack and push or pop the operator or number
	public void pushOrPop(String oper, Stack<Object> operators, Stack<Double> numbers){	
		Double num1;
		Double num2;
		Double result;

		//if the operator stack is empty, push the first operator
		if(operators.isEmpty()){
			if(oper.equals("+")){
				operators.push(add);
			}
			else if(oper.equals("-")){
				operators.push(sub);
			}
			else if(oper.equals("*")){
				operators.push(mul);
			}
			else if(oper.equals("/")){
				operators.push(div);
			}
			else if(oper.equals("^")){
				operators.push(exp);
			}
			else if(oper.equals("(")){
				operators.push(leftP);
			}
			else if(oper.equals("=")){
				operators.push(equal);
			}
		}

		//if the operator is not empty, compare the current operator with the operator on top of the stack
		else{
			//addition operator
			if(oper.equals("+")){
				while(operators.empty() == false && ((Operator)operators.peek()).getPriority() >= add.getPriority()){
					num1 = numbers.pop();
					num2 = numbers.pop();
					result = ((Operator)operators.pop()).evaluate(num1, num2);
					numbers.push(result);
				}
				operators.push(add);
			}
			//subtraction operator
			else if(oper.equals("-")){
				while(operators.empty() == false && ((Operator)operators.peek()).getPriority() >= sub.getPriority()){	
					num1 = numbers.pop();
					num2 = numbers.pop();
					result = ((Operator)operators.pop()).evaluate(num1, num2);
					numbers.push(result);
				}
				operators.push(sub);
			}
			//multiplication operator
			else if(oper.equals("*")){
				while(operators.empty() == false && ((Operator)operators.peek()).getPriority() >= mul.getPriority()){
					num1 = numbers.pop();
					num2 = numbers.pop();
					result = ((Operator)operators.pop()).evaluate(num1, num2);
					numbers.push(result);
				}
				operators.push(mul);
			}
			//division operator
			else if(oper.equals("/")){
				while(operators.empty() == false && ((Operator)operators.peek()).getPriority() >= div.getPriority()){
					num1 = numbers.pop();
					num2 = numbers.pop();
					result = ((Operator)operators.pop()).evaluate(num1, num2);
					numbers.push(result);
				}
				operators.push(div);
			}
			//exponentiation operator
			else if(oper.equals("^")){
				while(operators.empty() == false && ((Operator)operators.peek()).getPriority() >= exp.getPriority()){
					num1 = numbers.pop();
					num2 = numbers.pop();
					result = ((Operator)operators.pop()).evaluate(num1, num2);
					numbers.push(result);
				}
				operators.push(exp);
			}
			//equal operator
			else if(oper.equals("=")){
				while(operators.empty() == false && ((Operator)operators.peek()).getPriority() >= equal.getPriority()){
					num1 = numbers.pop();
					num2 = numbers.pop();
					result = ((Operator)operators.pop()).evaluate(num1, num2);
					numbers.push(result);
				}
			}
			//left parenthesis operator
			else if(oper.equals("(")){
				operators.push(leftP);
				
			}
			//right parenthesis operator
			else if(oper.equals(")")){
				while(!(operators.peek()).equals(leftP)){
					num1 = numbers.pop();
					num2 = numbers.pop();
					result = ((Operator)operators.pop()).evaluate(num1, num2);
					numbers.push(result);
				}
				operators.pop();
			}
		}
	}

	public void run(){
		this.setVisible(true);
	}

	public static void main(String[] args){
		Calculator calc = new Calculator();
		calc.run();
	}
}
