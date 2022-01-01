package com.bafrow.contactbook.serviceImpl;

import com.bafrow.contactbook.domain.Contact;
import com.bafrow.contactbook.repository.ContactRepository;
import com.bafrow.contactbook.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author BaFr0w
 */
@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact){
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(UUID Id){
        contactRepository.deleteById(Id);
    }

    @Override
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> findContactByPhone(@PathVariable("phoneNumber") String phoneNumber){
        return contactRepository.findContactByPhone(phoneNumber);
    }

    @Override
    @Transactional
    public Optional<Contact> updateContact(@PathVariable("Id") UUID Id, @RequestBody Contact updatedContact){
        return this.contactRepository.findById(Id)
                .map(oldContact -> this.contactRepository.save(updatedContact));
    }
}
