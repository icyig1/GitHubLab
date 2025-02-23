/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
public class QueueOverflowException extends Exception{
	public QueueOverflowException() {
		super("Queue is full");
	}
	public QueueOverflowException(String message) {
		super(message);
	}
}
