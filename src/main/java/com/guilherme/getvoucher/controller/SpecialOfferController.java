package com.guilherme.getvoucher.controller;

import com.guilherme.getvoucher.model.SpecialOffer;
import com.guilherme.getvoucher.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/special-offers")
public class SpecialOfferController {

    @Autowired
    private SpecialOfferService specialOfferService;

    @PostMapping
    public SpecialOffer create(@RequestBody SpecialOffer specialOffer) {
        return this.specialOfferService.create(specialOffer);
    }
}
