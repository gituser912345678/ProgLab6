package network;

import command.commandClasses.AbstractReciever;
import command.commandClasses.Command;
import data.HairColor;
import data.Person;
import exception.NoElementException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Reciver implements AbstractReciever {

    private static JsonWriter jsonWriter;

    public static void setWriter(JsonWriter jsonWriter) {
        Reciver.jsonWriter = jsonWriter;
    }

    @Override
    public Respons info() {
        return new Respons("Data type - " + CollectionManager.getMap().getClass().getName() + "\n" +
                "Count of persons - " + CollectionManager.getMap().size() + "\n" +
                "Init date - " + CollectionManager.getDate());
    }

    public Respons clear() {
        Map<String, Person> map = CollectionManager.getMap();
        map.clear();
        CollectionManager.setMap((LinkedHashMap<String, Person>) map);
        return new Respons("Clear...........");
    }

    public Respons executeScript(Request request) {
        File file = new File(request.getArg()[1]);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String respons = "";

        String line;
        try {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                kek:
                if (line.split(" ")[0].equals("insert")) {
                    ArrayList<String> array = new ArrayList<>();
                    String key = line.split(" ")[1];
                    StartCommand startCommand = new StartCommand();
                    while (!startCommand.getCommandTable().containsKey(line = scanner.nextLine())) {
                        if (scanner.hasNextLine()) {
                            if (startCommand.getCommandTable().containsKey(line.split(" ")[0])) {
                                startCommand.startExecute(new Request(startCommand.getCommandTable().get(line.split(" ")[0])));
                            } else if (line.equals(" ") || line.isEmpty()) {
                                break kek;
                            } else {
                                array.add(line.split(" ")[0]);
                            }
                        } else {
                            break kek;
                        }
                    }
                    CollectionManager.add(key, new Person(array));
                    respons += "Персонаж успешно добавлен." + "\n";
                } else if (line.split(" ")[0].equals("update")) {
                    LinkedList<String> array = new LinkedList<>();
                    String key = line.split(" ")[1];
                    StartCommand startCommand = new StartCommand();
                    while (!startCommand.getCommandTable().containsKey(line = scanner.nextLine())) {
                        if (scanner.hasNextLine()) {
                            if (line.equals(" ") || line.isEmpty()) {
                                break kek;
                            } else {
                                array.add(line.split(" ")[0]);
                            }
                        } else {
                            System.out.println("...");
                            break kek;
                        }
                    }
                    CollectionManager.add(key, new Person(array));
                    respons += "Персонаж успешно обновлён." + "\n";
                } else if (line.split(" ")[0].equals("execute_script") && line.split(" ").length < 2) {
                    return new Respons("Я не буду выполнять команду execute_scrip");
                } else {
                    StartCommand startCommand = new StartCommand();
                    if (startCommand.getCommandTable().containsKey(line.split(" ")[0])) {
                        respons += startCommand.startExecute(new Request(startCommand.getCommandTable().get(line.split(" ")[0]))).getMessage() + "\n";
                    } else {
                        respons += "..." + "\n";
                    }
                }
            }
        } catch (Exception | NoElementException e) {
            return new Respons(e.getMessage());
        }
        return new Respons(respons);
    }

    public Respons filterByHairColor(Request request) {
        try {
            LinkedHashMap<String, Person> map = CollectionManager.getMap();
            HairColor hairColor = HairColor.valueOf(request.getArg()[1]);
            String str = "";
            map.entrySet().stream().filter(x -> x.getValue().getHairColor() == hairColor).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            for (String key : map.keySet()) {
                str += map.get(key) + " ";
            }
            return new Respons(str);
        } catch (Exception e) {
            return new Respons(e.getMessage());
        }
    }

    public Respons help() {
        StartCommand startCommand = new StartCommand();
        LinkedHashMap<String, Command> commandTable = startCommand.getCommandTable();
        String str = "";
        for (String s : commandTable.keySet()) {
            str += commandTable.get(s).getName() + " " + commandTable.get(s).getDescription() + "\n";
        }
        return new Respons(str);
    }

    public Respons insert(Request request) {
        try {
            Person person = request.getPerson();
            Integer.parseInt(request.getArg()[1]);
            CollectionManager.add(request.getArg()[1], person);
            return new Respons("Персонаж успешно добавлен");
        } catch (Exception exception) {
            return new Respons(exception.getMessage());
        }


    }

    public Respons removeGreater(Request request) {
        Person person = request.getPerson();

        LinkedHashMap<String, Person> map = CollectionManager.getMap();
        map.entrySet().stream().filter(x -> x.getValue().getId() < person.getId()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        CollectionManager.setMap(map);

        return new Respons("Ненужные элементы успешно удалены из коллекции");
    }

    public Respons removeGreaterKey(Request request) {
        String key = request.getArg()[1];

        LinkedHashMap<String, Person> map = CollectionManager.getMap();
        map.entrySet().stream().filter(x -> Integer.parseInt(x.getKey()) < Integer.parseInt(key)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        CollectionManager.setMap(map);

        return new Respons("Ненужные элементы успешно удалены из коллекции");
    }

    public Respons removeKey(Request request) {
        try {
            CollectionManager.remove(request.getArg()[1]);
            return new Respons("Ненужные элементы успешно удалены из коллекции");
        } catch (Exception exception) {
            return new Respons(exception.getMessage());
        }
    }

    public Respons removeLower(Request request) {
        Person person = request.getPerson();

        LinkedHashMap<String, Person> map = CollectionManager.getMap();
        map.entrySet().stream().filter(x -> x.getValue().getId() > person.getId())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        CollectionManager.setMap(map);

        return new Respons("Ненужные элементы успешно удалены из коллекции");
    }

    public Respons show() {
        try {
            LinkedHashMap<String, Person> map = CollectionManager.getMap();
            String str = "";
            if (map.isEmpty()) {
                return new Respons(CollectionManager.getMap().getClass().getName() + " is empty");
            } else {
                for (String s : map.keySet()) {
                    str += "Key: <" + s + "> " + map.get(s) + "\n";
                }
                return new Respons(str);
            }
        } catch (Exception e) {
            return new Respons(e.getMessage());
        }
    }

    public Respons updateId(Request request) {
        try {
            Integer id = Integer.parseInt(request.getArg()[1]);

            for (String key : CollectionManager.getMap().keySet()) {
                if (Objects.equals(CollectionManager.getMap().get(key).getId(), id)) {
                    Person person = request.getPerson();
                    CollectionManager.remove(key);
                    CollectionManager.add(key, person);
                }
            }
            return new Respons("Объект уоллекции успешно обновлён.");
        } catch (Exception e) {
            return new Respons("Не получилось обновить указанный элемент коллекции.");
        }
    }
}
