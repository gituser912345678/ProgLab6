package command.commandClasses;

import network.Request;
import network.Respons;

import java.io.Serial;

/**
Команда позволяет вывести в стандартный поток вывода все элементы коллекции в строковом представлении.
 */
public class ShowCommand implements Command {
    @Serial
    private final static long serialVersionUID = 25L;
    @Override
    public Respons execute(Request request, AbstractReciever T) {
        return T.show();
    }

    @Override
    public String getName() {
        return "show: ";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
