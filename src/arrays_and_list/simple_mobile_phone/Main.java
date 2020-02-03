package arrays_and_list.simple_mobile_phone;

import java.util.List;
import java.util.Scanner;


/**
 * The Task:
 * Create a program that implements a simple mobile phone with the following capabilities.
 * Able to store, modify, remove and query contact names.
 * You will want to create a separate class for Contacts (name and phone number).
 * Create a master class (MobilePhone) that holds the ArrayList of Contacts
 * The MobilePhone class has the functionality listed above.
 * Add a menu of options that are available.
 * Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
 * and search/find contact.
 * When adding or updating be sure to check if the contact already exists (use name)
 * Be sure not to expose the inner workings of the Arraylist to MobilePhone
 * e.g. no ints, no .get(i) etc
 * MobilePhone should do everything with Contact objects only.
 */
public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static MobilePhone mobilePhone = new MobilePhone();

  public static void main(String[] args) {
    boolean flag = true;
    while (flag) {
      System.out.println("\nPlease choose from the following functions: ");
      System.out.println("1 - print list of contacts");
      System.out.println("2 - add new contact");
      System.out.println("3 - update existing contact");
      System.out.println("4 - remove contact");
      System.out.println("5 - search/find contact");
      System.out.println("6 - quit");

      int option = scanner.nextInt();

      switch (option) {
        case 1:
          printAllContacts();
          break;
        case 2:
          addNewContact();
          break;
        case 3:
          updateContact();
          break;
        case 4:
          removeContact();
          break;
        case 5:
          findContactByName();
          break;
        case 6:
          flag = false;
          System.out.println("Bye!");
          break;
      }
    }

  }

  private static void printAllContacts() {
    List<Contact> contactList = mobilePhone.getContacts();
    System.out.println("Contact list size : " + contactList.size());

    for (Contact contact: contactList) {
      System.out.println("Contact name: " + contact.getName());
      System.out.println("Contact number: " + contact.getNumber());
    }
  }

  private static void findContactByName() {
    System.out.println("Enter contact name to be searched: ");
    String name = scanner.next();

    Contact result = mobilePhone.findContactByName(name);
    if (result == null) {
      System.out.println("Contact does not exist");
    } else {
      System.out.println("Contact name: " + result.getName());
      System.out.println("Contact number: " + result.getNumber());
    }

  }

  private static void addNewContact() {
    System.out.println("Please enter new contact name: ");
    String newContactName = scanner.next();

    System.out.println("Please enter new contact number: ");
    String newContactNumber = scanner.next();

    Contact newContact = mobilePhone.addNewContact(newContactName, newContactNumber);

    if (newContact == null) {
      System.out.println("The contact already exists");
    } else {
      System.out.println("New contact added: ");
      System.out.println("Name: " + newContact.getName());
      System.out.println("Number: " + newContact.getNumber());
    }
  }

  private static void updateContact() {
    System.out.println("Please enter contact name: ");  // assuming the contact name is unique
    String contactName = scanner.next();

    Contact contactToBeUpdated = mobilePhone.findContactByName(contactName);
    if (contactToBeUpdated == null) {
      System.out.println("Contact does not exist");
    } else {
      System.out.println("What would you like to update about the contact? ");
      System.out.println("1 - update contact name");
      System.out.println("2 - update contact number");

      int updateOption = scanner.nextInt();

      System.out.println("Enter the new updated information: ");
      String updateInfo = scanner.next();

      Contact updatedContact = new Contact();
      if (updateOption == 1) {
        updatedContact = mobilePhone.updateContact(contactToBeUpdated, "name", updateInfo);
      } else if (updateOption == 2) {
        updatedContact = mobilePhone.updateContact(contactToBeUpdated, "number", updateInfo);
      }
      System.out.println("Updated contact information: ");
      System.out.println("contact name: " + updatedContact.getName());
      System.out.println("contact number: " + updatedContact.getNumber());
    }
  }

  private static void removeContact() {
    System.out.println("Enter contact name to be deleted: ");
    String contactName = scanner.next();

    Contact contactToRemove = mobilePhone.findContactByName(contactName);
    if (contactToRemove == null) {
      System.out.println("Contact does not exist");
    } else {
      mobilePhone.removeContact(contactToRemove);
      System.out.println("Contact successfully removed");
    }
  }
}
