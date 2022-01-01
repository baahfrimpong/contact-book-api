package com.bafrow.contactbook.controller;

import com.bafrow.contactbook.domain.Contact;
import com.bafrow.contactbook.service.IContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Author BaFr0w
 */
@RestController
@RequestMapping("/api/v1/contacts")
@Tag(name = "Contacts", description = "CRUD operations on the Contact book.")
public class ContactController {

    @Autowired
    private IContactService contactService;

    @PostMapping
    @Operation(summary = "Add a new contact")
    public ResponseEntity<?> saveContact(@RequestBody Contact contact){
        return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
    }

    @DeleteMapping("/{Id}")
    @Operation(summary = "Delete a contact")
    public ResponseEntity<?> deleteContact(@Parameter(description = "Enter Contact ID") @PathVariable UUID Id){
        contactService.deleteContact(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get all contacts")
    public ResponseEntity<?> getAllContacts(){
        return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
    }

    @GetMapping("/{phoneNumber}")
    @Operation(summary = "Search for a specific contact using a phone number.")
    public ResponseEntity<?> getContactByEmail(@Parameter(description = "Enter phone number") @PathVariable String phoneNumber){
        return new ResponseEntity<>(contactService.findContactByPhone(phoneNumber), HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    @Operation(summary = "Update or modify the details of a contact.")
    public ResponseEntity<?> updateContact(@Parameter(description = "Enter ID and other contact details") @PathVariable UUID Id, @RequestBody Contact updatedContact){
        return new ResponseEntity<>(contactService.updateContact(Id, updatedContact), HttpStatus.OK);
    }
}
