package exception;

public class IncorrectDataException extends Exception{
    public IncorrectDataException(String message){
        super("Некорректно введённые данные " + message);
    }
}
