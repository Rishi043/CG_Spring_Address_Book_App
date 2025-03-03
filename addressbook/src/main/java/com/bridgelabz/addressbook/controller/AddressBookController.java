package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// UC-2 Add REST Controller
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable int id) {
        return ResponseEntity.ok(addressBookService.getContactById(id));
    }
    @PostMapping
    public ResponseEntity<AddressBook> addContact(@RequestBody AddressBook contact) {
        return ResponseEntity.ok(addressBookService.addContact(contact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable int id, @RequestBody AddressBook contact) {
        return ResponseEntity.ok(addressBookService.updateContact(id, contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        boolean isDeleted = addressBookService.deleteContact(id);
        return isDeleted ? ResponseEntity.ok("Deleted Successfully") : ResponseEntity.notFound().build();
    }
}