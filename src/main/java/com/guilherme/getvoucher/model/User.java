package com.guilherme.getvoucher.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class User {

    @Id
    private String email;

    private String name;

    private String password;

    @DBRef
    private List<Role> roles;
}
