package com.bafrow.contactbook.domain;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "contacts", schema = "sc_contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid4")
    @Column(name = "contact_id", nullable = false)
    private UUID id;


    @Column(name = "first_name", nullable = false)
    private String firstName;


    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "phone")
    private String phone;

}