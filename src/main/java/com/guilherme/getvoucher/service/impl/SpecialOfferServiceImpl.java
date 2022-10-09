package com.guilherme.getvoucher.service.impl;

import com.guilherme.getvoucher.model.SpecialOffer;
import com.guilherme.getvoucher.repository.SpecialOfferRepository;
import com.guilherme.getvoucher.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialOfferServiceImpl implements SpecialOfferService {

    @Autowired
    private SpecialOfferRepository specialOfferRepository;

    @Override
    public SpecialOffer create(SpecialOffer specialOffer) {
        return this.specialOfferRepository.save(specialOffer);
    }
}
