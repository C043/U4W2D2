import Es3.NoContactException;
import Es3.Rubrica;

public class Main {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        rubrica.addContact("Aldo", "3459244024");
        rubrica.addContact("Giovanni", "389483948");
        rubrica.addContact("Giacomo", "123456789");
        rubrica.addContact("Ajeje", "344938498");

        rubrica.printAllContacts();

        rubrica.removeContact("Ajeje");
        System.out.println("----------------");
        rubrica.printAllContacts();

        System.out.println("----------------");
        try {
            System.out.println("Aldo's number is: " + rubrica.getContactNumber("Aldo"));
        } catch (NoContactException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------");
        try {
            System.out.println("Searched number contact is: " + rubrica.getContactName("389483948"));
        } catch (NoContactException e) {
            System.out.println(e.getMessage());
        }


    }
}