import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class bookapp {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static final HashMap<String, Contact> firstNameLookup = new HashMap<>();
    private static final HashSet<String> phoneSet = new HashSet<>();

    public static class Contact {
        String name;
        String phone;
        String email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
    }

    public static void addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Phone number already exists. Duplicate contact not added.");
            return;
        }

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        phoneSet.add(phone);

        String firstName = name.trim().split("\\s+")[0].toLowerCase(Locale.ROOT);
        firstNameLookup.put(firstName, contact);
        System.out.println("Contact added successfully.");
    }

    public static Contact searchByFirstName(String firstName) {
        return firstNameLookup.get(firstName.trim().toLowerCase(Locale.ROOT));
    }

    public static boolean deleteContact(String phone) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).phone.equals(phone)) {
                Contact removed = contacts.remove(i);
                phoneSet.remove(phone);

                String firstName = removed.name.trim().split("\\s+")[0].toLowerCase(Locale.ROOT);
                firstNameLookup.remove(firstName);
                return true;
            }
        }
        return false;
    }

    public static void displaySortedByName() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        ArrayList<Contact> sortedContacts = new ArrayList<>(contacts);
        Collections.sort(sortedContacts, Comparator.comparing(contact -> contact.name.toLowerCase(Locale.ROOT)));

        System.out.println("\nContacts sorted by name:");
        for (Contact contact : sortedContacts) {
            System.out.println("Name: " + contact.name + ", Phone: " + contact.phone + ", Email: " + contact.email);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("\n===== Address Book Menu =====");
                System.out.println("1. Add Contact");
                System.out.println("2. Search by First Name");
                System.out.println("3. Delete Contact by Phone");
                System.out.println("4. Display Contacts Sorted by Name");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter phone: ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        addContact(name, phone, email);
                    }
                    case 2 -> {
                        System.out.print("Enter first name to search: ");
                        String firstName = scanner.nextLine();
                        Contact found = searchByFirstName(firstName);
                        if (found != null) {
                            System.out.println("Contact found: Name: " + found.name + ", Phone: " + found.phone + ", Email: " + found.email);
                        } else {
                            System.out.println("No contact found for first name: " + firstName);
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter phone number to delete: ");
                        String phoneToDelete = scanner.nextLine();
                        if (deleteContact(phoneToDelete)) {
                            System.out.println("Contact deleted successfully.");
                        } else {
                            System.out.println("No contact found with phone: " + phoneToDelete);
                        }
                    }
                    case 4 -> displaySortedByName();
                    case 5 -> System.out.println("Exiting Address Book. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }
    }
}
