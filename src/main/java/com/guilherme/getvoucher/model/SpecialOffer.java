package com.guilherme.getvoucher.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class SpecialOffer {

    @Id
    private String id;

    private String name;

    private BigDecimal discount;
}
