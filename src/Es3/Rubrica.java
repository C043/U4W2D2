package Es3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Rubrica {
    private final Map<String, String> rubrica = new HashMap<>();

    public void addContact(String name, String number) {
        this.rubrica.putIfAbsent(name.toLowerCase(), number);
    }

    public void removeContact(String name) {
        this.rubrica.remove(name.toLowerCase());
    }

    public String getContactName(String number) throws NoContactException {
        Set<String> contactsKeys = this.rubrica.keySet();
        for (String key : contactsKeys) {
            if (Objects.equals(this.rubrica.get(key), number)) {
                return key;
            }
        }
        throw new NoContactException("No contact with that number!");
    }

    public String getContactNumber(String name) throws NoContactException {
        String number = this.rubrica.get(name.toLowerCase());
        if (number == null) {
            throw new NoContactException("No contact with that name!");
        }
        return number;
    }

    public void printAllContacts() {
        Set<String> contactsKeys = this.rubrica.keySet();
        for (String key : contactsKeys) {
            System.out.println(key + " - " + this.rubrica.get(key));
        }
    }
}
