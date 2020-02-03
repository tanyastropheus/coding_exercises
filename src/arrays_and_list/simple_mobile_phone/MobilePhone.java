package arrays_and_list.simple_mobile_phone;

import java.util.ArrayList;
import java.util.List;


public class MobilePhone {

  private List<Contact> contacts = new ArrayList<>();

  List<Contact> getContacts() {
    return contacts;
  }

  MobilePhone() {
  }

  Contact findContactByName(String name) {
    for (Contact existingContact: contacts) {
      if (existingContact.getName().equals(name)) {
        return existingContact;
      }
    }
    return null;
  }

  Contact addNewContact(String newContactName, String newContactNumber) {
    Contact newContact = new Contact(newContactName, newContactNumber);

    if (contacts.contains(newContact)) {
      System.out.println("The contact already exists");
      return null;
    } else {
      contacts.add(newContact);
      return newContact;
    }
  }

  Contact updateContact(Contact contact, String type, String updateInfo) {
    if (type.equals("name")) {
      contact.setName(updateInfo);
    } else if (type.equals("number")) {
      contact.setNumber(updateInfo);
    }
    return contact;
  }

  void removeContact(Contact contact) {
    contacts.remove(contact);
  }
}
