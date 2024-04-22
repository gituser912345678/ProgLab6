package data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable {
    @Serial
    private final static long serialVersionUID = 333L;
    private int id;//
    private String name;//
    private Coordinates coordinates;//
    private Date creationDate = new Date();//
    private Double height;//
    private EyeColor eyeColor;//
    private HairColor hairColor;//
    private Country nationality;
    private Location location;

    public int getId() {
        return id;
    }

    private static ArrayList<Integer> arrayListId = new ArrayList<>();

    public Person() {
        if (arrayListId.isEmpty()) {
            this.id = 0;
            arrayListId.add(this.id);
        } else {
            this.id = arrayListId.get(arrayListId.size() - 1) + 1;
            arrayListId.add(this.id);
        }
    }

    public Person(ArrayList<String> data) {
        if (arrayListId.isEmpty()) {
            this.id = 0;
            arrayListId.add(this.id);
        } else {
            this.id = arrayListId.get(arrayListId.size() - 1) + 1;
            arrayListId.add(this.id);
        }
        this.name = data.get(0);
        this.coordinates = new Coordinates(Double.parseDouble(data.get(1)), Integer.parseInt(data.get(2)));
        this.creationDate = new Date();
        this.height = Double.parseDouble(data.get(3));
        this.eyeColor = EyeColor.valueOf(data.get(4));
        this.hairColor = HairColor.valueOf(data.get(5));
        this.nationality = Country.valueOf(data.get(6));
        this.location = new Location(Double.parseDouble(data.get(7)), Long.parseLong(data.get(8)), Integer.parseInt(data.get(9)));
    }

    public Person(LinkedList<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.name = data.get(1);
        this.coordinates = new Coordinates(Double.parseDouble(data.get(2)), Integer.parseInt(data.get(3)));
        this.creationDate = new Date();
        this.height = Double.parseDouble(data.get(4));
        this.eyeColor = EyeColor.valueOf(data.get(5));
        this.hairColor = HairColor.valueOf(data.get(6));
        this.nationality = Country.valueOf(data.get(7));
        this.location = new Location(Double.parseDouble(data.get(8)), Long.parseLong(data.get(9)), Integer.parseInt(data.get(10)));
    }

    public Location getLocation() {
        return location;
    }

    public Country getNationality() {
        return nationality;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public Double getHeight() {
        return height;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public Person(Integer id) {
        this.id = id;
    }

    public void setCreationDate(Date d) {
        this.creationDate = d;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.coordinates = coordinates;
        }
    }

    public void setLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.location = location;
        }
    }

    public void setNationality(Country nationality) {
        if (nationality == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.nationality = nationality;
        }
    }

    public void setHeight(Double height) {
        if (height == null || height <= 0) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено и значение поля должно быть больше 0");
        } else {
            this.height = height;
        }
    }

    public void setHairColor(HairColor hairColor) {
        if (hairColor == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.hairColor = hairColor;
        }
    }

    public void setEyeColor(EyeColor eyeColor) {
        if (eyeColor == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.eyeColor = eyeColor;
        }
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Это поле обязательно должно быть заполнено");
        } else {
            this.name = name;
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        return this.id - person.id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(height, person.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
