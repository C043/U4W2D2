package Es3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, String> rubrica = new HashMap<>();

        addContact(rubrica, "Aldo", "34502943093");
        addContact(rubrica, "Giovanni", "30403092092");
        addContact(rubrica, "Giacomo", "2329091292093");
        addContact(rubrica, "Ajeje", "20192019020391");

        removeContact(rubrica, "Ajeje");

        printAllContacts(rubrica);

        System.out.println("--------");
        try {
            System.out.println(getContactName(rubrica, "34502943093"));
        } catch (NoContactException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(getContactNumber(rubrica, "34502943093"));
        } catch (NoContactException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addContact(Map<String, String> rubrica, String name, String number) throws NullPointerException {
        rubrica.putIfAbsent(name.toLowerCase(), number);
    }

    public static void removeContact(Map<String, String> rubrica, String name) throws NullPointerException {
        rubrica.remove(name.toLowerCase());
    }

    public static String getContactName(Map<String, String> rubrica, String number) throws NoContactException {
        Set<String> contactsKeys = rubrica.keySet();
        for (String key : contactsKeys) {
            if (Objects.equals(rubrica.get(key), number)) {
                return key;
            }
        }
        throw new NoContactException("No contact with that number!");
    }

    public static String getContactNumber(Map<String, String> rubrica, String name) throws NoContactException {
        String number = rubrica.get(name.toLowerCase());
        if (number == null) {
            throw new NoContactException("No contact with that name!");
        }
        return number;
    }

    public static void printAllContacts(Map<String, String> rubrica) {
        Set<String> contactsKeys = rubrica.keySet();
        for (String key : contactsKeys) {
            System.out.println(key + " - " + rubrica.get(key));
        }
    }
}
