import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class
        ArrayList<PersonalInformation> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

// Read person information from the user
        while (true) {
            System.out.print("First name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Identification number: ");

            String identificationNumber = String.valueOf(scanner.nextLine());
            persons.add(new PersonalInformation(name, lastName, identificationNumber));
        }

        System.out.println(" ");
        for (PersonalInformation person : persons) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }
    }
}