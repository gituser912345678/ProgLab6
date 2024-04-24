package fileManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Person;
import collectionManager.CollectionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класс-парсер файла.
 */
public class JsonReader {
    Map<String, Person> map = new LinkedHashMap<>();

    public String readJson(String[] path) throws FileNotFoundException {
        String str = "";
        File file = new File(path[0]);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            str += scanner.nextLine();
        }
        return str;
    }

    public void jsonReader(String str) {
        Type type = new TypeToken<LinkedHashMap<String, Person>>() {
        }.getType();
        try {
            map = new Gson().fromJson(str, type);
            CollectionManager.setMap((LinkedHashMap<String, Person>) map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
