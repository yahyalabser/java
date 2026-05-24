package Revision;

public class DocumentException extends Exception {
    public DocumentException() { super(); }
    public DocumentException(String message) {
        super(message);
    }
    public DocumentException(String message, Throwable cause) { super(message, cause); }

}
