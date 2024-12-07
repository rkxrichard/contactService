package ru.StudentDB.studentDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.StudentDB.studentDB.models.Contact;
import ru.StudentDB.studentDB.repositories.ContactRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    private final Map<Long, Contact> contactMap;

    public ContactService() {
        this.contactMap = new HashMap<>();
    }


    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    
    public Optional<Contact> getContactById(Long id) {
        return Optional.ofNullable(contactMap.get(id));
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public ResponseEntity<Contact> updateContact(Long id, Contact updatedContact) {
        Optional<Contact> existingContact = contactRepository.findById(id);

        if (existingContact.isPresent()) {
            Contact contactToUpdate = existingContact.get();
            contactToUpdate.setName(updatedContact.getName());
            contactToUpdate.setEmail(updatedContact.getEmail());
            contactToUpdate.setPhone(updatedContact.getPhone());
            return ResponseEntity.ok(contactRepository.save(contactToUpdate));
        }
        return ResponseEntity.notFound().build();
    }
}
