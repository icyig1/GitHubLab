/**
 * Ian Green
 * Professor Kuijt
 * 2/22/2025
 * CMSC 204 CRNN 31209
 */
public class InvalidNotationFormatException extends Exception {
	public InvalidNotationFormatException() {
		super("Notation format incorrect");
	}
	public InvalidNotationFormatException(String message) {
		super(message);
	}
	public String getMessage() {
		return ("Notation format incorrect");
	}
	public String toString() {
		return "Notation format incorrect";
	}
}
