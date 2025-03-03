package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// UC-4 Add Service Layer
@Service
public class AddressBookService {
    private List<AddressBook> addressBookList = new ArrayList<>();

    public List<AddressBook> getAllContacts() {
        return addressBookList;
    }

    public AddressBook getContactById(int id) {
        return addressBookList.stream().filter(contact -> contact.getId() == id).findFirst().orElse(null);
    }
}