package com.guilherme.getvoucher.repository;

import com.guilherme.getvoucher.model.SpecialOffer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpecialOfferRepository extends MongoRepository<SpecialOffer, String> {
}
