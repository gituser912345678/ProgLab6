package exception;

public class UnknowElementException extends Exception {
    public UnknowElementException() {
        super("Неизвестный элемент");
    }
}
