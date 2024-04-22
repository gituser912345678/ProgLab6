package exception;

public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException(){
        super("Неизвестная команда");
    }
}
