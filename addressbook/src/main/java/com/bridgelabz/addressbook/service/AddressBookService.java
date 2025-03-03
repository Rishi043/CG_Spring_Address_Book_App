package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// UC-4 Service Layer
@Service
public class AddressBookService {
    private List<AddressBook> addressBookList = new ArrayList<>();
    private int idCounter = 1;

    public List<AddressBook> getAllContacts() {
        return addressBookList;
    }

    public AddressBook getContactById(int id) {
        return addressBookList.stream().filter(contact -> contact.getId() == id).findFirst().orElse(null);
    }

    public AddressBook addContact(AddressBook contact) {
        contact.setId(idCounter++);
        addressBookList.add(contact);
        return contact;
    }

    public AddressBook updateContact(int id, AddressBook updatedContact) {
        for (int i = 0; i < addressBookList.size(); i++) {
            if (addressBookList.get(i).getId() == id) {
                addressBookList.set(i, updatedContact);
                return updatedContact;
            }
        }
        return null;
    }

    public boolean deleteContact(int id) {
        return addressBookList.removeIf(contact -> contact.getId() == id);
    }
}