package exception;

public class NoElementException extends Throwable {
    public NoElementException(Integer id) {
        super("Нет элемента с данным индексом");
    }
}
