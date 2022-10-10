package com.guilherme.getvoucher.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Document
public class Voucher {

    @Id
    private String code = UUID.randomUUID().toString();

    private Date expirationDate;

    private Date useDate;

    private Boolean used = false;

    @DBRef
    private SpecialOffer specialOffer;

    @DBRef
    private User customer;
}
