package application;

/**
 * Notation class
 * @author Gleb Yakunin
 *
 */
public class Notation {
	/**
	 * Performs arithmetic calculation between two variables
	 * @param first string variable to be parsed as double for calculation
	 * @param second string variable to be parsed as double for calculation
	 * @param op operator to use in calculation
	 * @return result of calculation
	 */
	private static double operation(String first, String second,char op) {
		double result=0,fir,sec;
		switch(op) {
		case '+':
			fir=Double.parseDouble(first);
			sec=Double.parseDouble(second);
			result=fir+sec;
			break;
		
		case '-':
			fir=Double.parseDouble(first);
			sec=Double.parseDouble(second);
			result=fir-sec;
			break;
		
		case '*':
			fir=Double.parseDouble(first);
			sec=Double.parseDouble(second);
			result=fir*sec;
			break;
		
		case '/':
			fir=Double.parseDouble(first);
			sec=Double.parseDouble(second);
			result=fir/sec;
			break;
		
		default:
			System.out.println("Unknown operator");
		}	
		return result;
	}
	
	/**
	 * convert a postfix expression to an infix expression
	 * @param postfix expression to convert to infix
	 * @return converted infix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		String infix;
		String top;
		NotationStack<String> infixStack=new NotationStack<String>(10);
		char[] temp=postfix.toCharArray();
		
		try {
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==' ') {
					continue;
				}
				if(Character.isDigit(temp[i])) {
					infixStack.push(String.valueOf(temp[i]));
				}
				if(temp[i]=='+'||temp[i]=='-'||temp[i]=='/'||temp[i]=='*') {
					if(infixStack.size()<2) {
						throw new InvalidNotationFormatException();
					}
					else {
						top=infixStack.pop();
						infix="("+infixStack.pop()+temp[i]+top+")";
						infixStack.push(infix);
					}
				}
			}
			if(infixStack.size()>1) {
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackOverflowException d) {
			d.printStackTrace();
		}
		catch(StackUnderflowException s) {
			s.printStackTrace();
		}
		return infixStack.toString();
	}
	
	/**
	 * converts an infix expression to a postfix expression
	 * @param infix expression to convert
	 * @return converted postfix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		
		NotationStack<String> postfixStack=new NotationStack<String>(20);
		NotationQueue<String> postfixQueue=new NotationQueue<String>(20);
		char[] temp=infix.toCharArray();
		
		try {
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==' ') {
					continue;
				}
				if(Character.isDigit(temp[i])) {
					postfixQueue.enqueue(String.valueOf(temp[i]));
				}
				if(temp[i]=='(') {
					
					postfixStack.push(String.valueOf(temp[i]));
				}
				
				if(temp[i]=='+') {
					if(!postfixStack.isEmpty()) {
						while(postfixStack.top().equals("+")||postfixStack.top().equals("-")||postfixStack.top().equals("*")||postfixStack.top().equals("/")) {
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					postfixStack.push(String.valueOf(temp[i]));
				}
				if(temp[i]=='-') {
					if(!postfixStack.isEmpty()) {
						while(postfixStack.top().equals("+")||postfixStack.top().equals("-")||postfixStack.top().equals("*")||postfixStack.top().equals("/")) {
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					postfixStack.push(String.valueOf(temp[i]));
				}
				if(temp[i]=='/') {
					if(!postfixStack.isEmpty()) {
						while(postfixStack.top().equals("*")||postfixStack.top().equals("/")) {
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					postfixStack.push(String.valueOf(temp[i]));
				}
				if(temp[i]=='*') {
					if(!postfixStack.isEmpty()) {
						while(postfixStack.top().equals("*")||postfixStack.top().equals("/")) {
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					postfixStack.push(String.valueOf(temp[i]));
				}
				if(temp[i]==')') {
					while(!postfixStack.isEmpty()&&!postfixStack.top().equals("(")) {
						postfixQueue.enqueue(postfixStack.pop());
					}
					if(postfixStack.isEmpty()||!postfixStack.top().equals("(")) {
						throw new InvalidNotationFormatException();
					}
					
					if(!postfixStack.isEmpty()&&postfixStack.top().equals("(")){
						postfixStack.pop();
					}
				}
			}
			while(!postfixStack.isEmpty()&&!postfixStack.top().equals("(")) {
				postfixQueue.enqueue(postfixStack.pop());
			}
		}
		catch(QueueOverflowException e) {
			e.printStackTrace();
		}
		catch(StackOverflowException d) {
			d.printStackTrace();
		}
		catch(StackUnderflowException s) {
			s.printStackTrace();
		}
		return postfixQueue.toString();
	}
	
	/**
	 * performs calculation of postfix expression
	 * @param postfixExpr postfix expression to evaluate
	 * @return result of evaluation
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		String first, second;
		double result=0;
		NotationStack<String> postfixStack=new NotationStack<String>(10);
		char[] temp=postfixExpr.toCharArray();
		
		try {
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==' ') {
					continue;
				}
				if(Character.isDigit(temp[i])|| temp[i]=='(') {
					postfixStack.push(String.valueOf(temp[i]));
				}
				else {
					if(postfixStack.size()<2) {
						throw new InvalidNotationFormatException();
					}
					else {
						second=postfixStack.pop();
						first=postfixStack.pop();
						result=operation(first,second,temp[i]);
						postfixStack.push(Double.toString(result));
						
					}
				}
			}
			if(postfixStack.size()>1) {
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackOverflowException d) {
			d.printStackTrace();
		}
		catch(StackUnderflowException s) {
			s.printStackTrace();
		}
		
					
		return result;
	}
	
	/**
	 * performs calculations of infix expression
	 * @param infixExpr infix expression to evaluate
	 * @return result of evaluation
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException {
		double result=0;
		result=evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
		
		return result;
	}
}