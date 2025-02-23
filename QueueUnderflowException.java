/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
public class QueueUnderflowException extends Exception{
	public QueueUnderflowException() {
		super("Queue is empty");
	}
	public QueueUnderflowException(String message) {
		super(message);
	}
}
