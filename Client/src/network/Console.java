package network;

import data.Person;
import data.generators.PersonGenerator;


import java.util.Scanner;

public class Console {
    public void execute() {
        StartCommand startCommand = new StartCommand();
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        try {
            while (scanner.hasNext()) {
                String[] str = scanner.nextLine().split(" ");
                if (str[0].equals("insert") || str[0].equals("update")) {
                    try {
                        Person person = PersonGenerator.createPerson(Integer.parseInt(str[1]));
                        System.out.println(client.sendRequest(new Request(startCommand.getCommandTable().get(str[0]), person, str)).getMessage());
                    } catch (Exception exception) {
                        System.out.println("Ключь обязательно должен быть числом.");
                    }
                } else if (str[0].equals("remove_lower") || str[0].equals("remove_greater")) {
                    Person person = PersonGenerator.createPerson(0);
                    System.out.println(client.sendRequest(new Request(startCommand.getCommandTable().get(str[0]), person, str)).getMessage());
                } else if (str[0].equals("execute_script") || str[0].equals("remove_key") || str[0].equals("filter_by_hair_color") || str[0].equals("remove_greater_key")) {
                    System.out.println(client.sendRequest(new Request(startCommand.getCommandTable().get(str[0]), str)).getMessage());
                } else if (str[0].equals("exit")) {
                    System.exit(0);
                } else {
                    System.out.println(client.sendRequest(new Request(startCommand.getCommandTable().get(str[0]))).getMessage());
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
