package network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * Класс записывающий коллекцию в файл.
 */
public class JsonWriter {
    private static String path;

    public JsonWriter(String path) {
        JsonWriter.path = path;
    }

    public void execute() throws IOException {
        LinkedHashMap<String, Person> map = CollectionManager.getMap();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JsonWriter.path))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(map, writer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
