package ru.StudentDB.studentDB.services;

import org.springframework.stereotype.Service;
import ru.StudentDB.studentDB.models.Contact;

import java.util.List;
import java.util.Optional;

@Service
public interface ContactService {
    public List<Contact> getAllContacts();
    public Optional<Contact> getContactById(Long id);
    public Contact createContact(Contact contact);

    Contact createContact(long id, Contact contact);
}
