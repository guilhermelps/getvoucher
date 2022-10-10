package com.guilherme.getvoucher.service;

import com.guilherme.getvoucher.model.SpecialOffer;

public interface SpecialOfferService {

    public SpecialOffer create(SpecialOffer user);

    public SpecialOffer findById(String id);
}
