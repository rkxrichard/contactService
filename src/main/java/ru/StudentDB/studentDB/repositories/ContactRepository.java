package ru.StudentDB.studentDB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.StudentDB.studentDB.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
