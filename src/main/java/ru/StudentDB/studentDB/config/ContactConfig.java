package ru.StudentDB.studentDB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.StudentDB.studentDB.services.ContactService;

@Configuration
public class ContactConfig {

    @Bean
    public ContactService contactService() {
        return new ContactService();
    }
}
