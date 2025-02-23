/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
public class Notation {
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		MyStack<Character> stack = new MyStack<>();
		MyQueue<Character> queue = new MyQueue<>();
		
		try {
		for (char ch : infix.toCharArray()) {
			if (Character.isWhitespace(ch))
				continue;
			if (Character.isDigit(ch)) {
				queue.enqueue(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while(!stack.isEmpty() && stack.top() != '(' ) {
					queue.enqueue(stack.pop());
				}
				if (stack.isEmpty() || stack.top()!= '(') {
					throw new InvalidNotationFormatException("Mismatched parentheses");
				}
				stack.pop();		
			} else if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
					while(!stack.isEmpty() && getPrecedence(stack.top()) >= getPrecedence(ch)) {
							queue.enqueue(stack.pop());
						}
						stack.push(ch);
					}
			else {
				throw new InvalidNotationFormatException("Invalid Format");
			}
				}
		while (!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
		} catch (StackOverflowException | StackUnderflowException e) {
			System.out.println(e);
		} catch (QueueOverflowException e) {
			System.out.println(e);
		}
		return queue.toString();
	}
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException  {
		MyStack<String> stack = new MyStack<>();
		String infix = "";
		try {
		for (char ch : postfix.toCharArray()) {
			if (Character.isWhitespace(ch)) {
				continue;
			}
			
			if (Character.isDigit(ch)) {
				stack.push(String.valueOf(ch));
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
			if (stack.size() < 2) {
				throw new InvalidNotationFormatException("Not enough in stack");
			}
				String operand2 = stack.pop();
				String operand1 = stack.pop();
				String result = "(" + operand1 + ch + operand2 + ")";
				stack.push(result);
			} else {
				throw new InvalidNotationFormatException("Invalid Notation");
			}
		}

		} catch (StackOverflowException | StackUnderflowException e) {
			System.out.println(e);
		}
		if (stack.size() != 1) {
			throw new InvalidNotationFormatException ("Invalid Notation");
		}
		try {
			infix = stack.pop();
		} catch (StackUnderflowException e) {
			System.out.println(e);
		}
		return infix;
	}
	public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException {
		MyStack<Double> stack = new MyStack<>();
		Double evaluation = 0.0;
    	double result = 0.0;
		for(char ch : postfix.toCharArray()) {
			if (Character.isWhitespace(ch)) {
				continue;
			}
		    if (Character.isDigit(ch)) {
				try {
					stack.push((double)Character.getNumericValue(ch));
				} catch (StackOverflowException e) {
					System.out.println(e);
				}

		    } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
		    	if (stack.size() < 2) {
		    		throw new InvalidNotationFormatException("Invalid Notation");
		    	}
		    	try {
		    		double operand2 = stack.pop();
		    		double operand1 = stack.pop();
		    		switch (ch) {
		    			case  '+':
		    				result = operand1 + operand2;
		    				break;
		    			case '-':
		    				result = operand1 - operand2;
		    				break;
		    			case '*':
		    				result = operand1 * operand2;
		    				break;
		    			case '/':
		    				if (operand2 == 0) {
		    					throw new InvalidNotationFormatException("Second number can't be 0");
		    				}
		    				result = operand1 / operand2;
		    				break;
		    			default:
		    				throw new InvalidNotationFormatException("Invalid Operator");
		    		}
		    	} catch (StackUnderflowException e) {
		    		System.out.println(e);
		    	}
						try {
							stack.push(result);
						} catch (StackOverflowException e) {
							System.out.println(e);
						}
		    	} else {
		    		throw new InvalidNotationFormatException("Invalid Postfix");
		    	}
		    }
		if (stack.size() != 1) {
			throw new InvalidNotationFormatException("Invalid postfix expression");
		}
	
		try {
			evaluation = stack.pop();
		} catch (StackUnderflowException e) {
			System.out.println(e);
		}
		return evaluation;
	}
	
	private static int getPrecedence(char operator) {
		switch (operator) {
		case '+': 
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		default:
			return 0;
		}
	}
}
