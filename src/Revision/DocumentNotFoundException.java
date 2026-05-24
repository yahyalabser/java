package Revision;

public class DocumentNotFoundException extends DocumentException {
    public DocumentNotFoundException() { super(); }
    public DocumentNotFoundException(String message) {
        super(message);
    }
    public DocumentNotFoundException(String message, Throwable cause) { super(message, cause); }
}
