package com.mainstream.userapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name", nullable = true)
    private String firstName;
    @Column(name = "last_name", nullable = true)
    private String lastName;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "identity_number", nullable = true)
    private String idNumber;
    @Column(name = "physical_address")
    private String physicalAddress;

}
