package com.bafrow.contactbook.service;

import com.bafrow.contactbook.domain.Contact;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author BaFr0w
 */
public interface IContactService {
    Contact saveContact(Contact contact);

    void deleteContact(UUID Id);

    List<Contact> getAllContacts();

    Optional<Contact> findContactByPhone(@PathVariable("phoneNumber") String phoneNumber);

    Optional<Contact> updateContact(@PathVariable("Id") UUID Id, @RequestBody Contact updatedContact);
}
