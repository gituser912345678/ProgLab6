package network;

import command.commandClasses.Command;
import data.Person;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private final static long serialVersionUID = 7L;
    private Command command;
    private Person person;
    private String[] arg;

    public Request(Command command, Person person, String[] arg) {
        this.command = command;
        this.person = person;
        this.arg = arg;
    }

    public Request(Command command) {
        this.command = command;
    }

    public Request(Command command, Person person) {
        this.command = command;
        this.person = person;
    }

    public Request(Command command, String[] arg){
        this.command = command;
        this.arg = arg;
    }

    public Command getCommand() {
        return command;
    }

    public Person getPerson() {
        return person;
    }

    public String[] getArg() {
        return arg;
    }
}
