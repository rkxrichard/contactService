package ru.StudentDB.studentDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.StudentDB.studentDB.models.Contact;
import ru.StudentDB.studentDB.services.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();}

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        return contactService.getContactById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.createContact(contact));
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        return contactService.getContactById(id).map(contact -> {
            contact.setName(updatedContact.getName());
            contact.setEmail(updatedContact.getEmail());
            return ResponseEntity.ok(contactService.createContact(contact));
        }).orElse(ResponseEntity.notFound().build());
    }
}

