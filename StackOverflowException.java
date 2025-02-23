/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
public class StackOverflowException extends Exception{
	public StackOverflowException() {
		super("Stack is full");
	}
	public StackOverflowException(String message) {
		super(message);
	}
}
