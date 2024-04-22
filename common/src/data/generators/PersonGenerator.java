package data.generators;

import data.*;
import exception.IncorrectDataException;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
Класс-генератор обЪекта.
 */
public class PersonGenerator {
    public static Person createPerson(Integer id) {
        System.out.println("Generate...");

        Scanner scanner = new Scanner(System.in);

        int b = 0;
        Double a = 0D;
        Coordinates coordinates;
        Location location;
        double x1;
        long y1;
        int z1;

        Person person;
        if (id == 0) {
            person = new Person();
        } else {
            person = new Person(id);
        }

        while (true) {
            try {
                System.out.println("Введите имя: ");
                person.setName(scanner.nextLine());
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату x: ");
                a = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату y: ");
                b = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        coordinates = new Coordinates(a, b);
        person.setCoordinates(coordinates);

        while (true) {
            try {
                System.out.println("Введите цвет глаз: доступные варианты: GREEN" + "    BLACK" + "    YELLOW" + "    WHITE" + "    BROWN: ");
                person.setEyeColor(EyeColor.valueOf(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите цвет волос: доступные варианты: RED" + "    BLACK" + "    YELLOW" + "    WHITE" + "    BROWN: ");
                person.setHairColor(HairColor.valueOf(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите рост: ");
                person.setHeight(Double.parseDouble(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите страну: доступные варианты: UNITED_KINGDOM," + "    CHINA," + "    VATICAN," + "    THAILAND," + "    NORTH_KOREA");
                person.setNationality(Country.valueOf(scanner.nextLine()));
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату x: ");
                x1 = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату y: ");
                y1 = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату z: ");
                z1 = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NoSuchElementException e) {
                System.err.println("Ctrl+D pressed");
                System.exit(1);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        location = new Location(x1, y1, z1);
        person.setLocation(location);

        return person;
    }
}
