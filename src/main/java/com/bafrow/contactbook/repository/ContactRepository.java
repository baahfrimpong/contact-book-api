package com.bafrow.contactbook.repository;

import com.bafrow.contactbook.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    Optional<Contact> findContactByPhone(@Param("phoneNumber") String phoneNumber);
}