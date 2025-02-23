/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
public class StackUnderflowException extends Exception {
	public StackUnderflowException() {
		super("Stack is empty");
	}
	public StackUnderflowException(String message) {
		super(message);
	}
}
