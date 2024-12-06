package ru.StudentDB.studentDB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ru.StudentDB.studentDB.services.ContactService;
import ru.StudentDB.studentDB.services.InMemoryContactService;

@Configuration
public class ContactConfig {

    @Bean
    public ContactService contactService() {
        return new ContactService();
    }
}
