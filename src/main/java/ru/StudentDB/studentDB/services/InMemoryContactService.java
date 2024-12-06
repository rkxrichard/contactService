package ru.StudentDB.studentDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.StudentDB.studentDB.models.Contact;
import ru.StudentDB.studentDB.repositories.ContactRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryContactService{

    @Autowired
    private ContactRepository contactRepository;
    private final Map<Long,Contact> contactMap;

    public InMemoryContactService() {
        this.contactMap = new HashMap<>();
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


    @Override
    public Optional<Contact> getContactById(Long id) {
        return Optional.ofNullable(contactMap.get(id));

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }
}
