package com.guilherme.getvoucher.repository;

import com.guilherme.getvoucher.model.User;
import com.guilherme.getvoucher.model.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoucherRepository extends MongoRepository<Voucher, String> {

    public Voucher findByCodeAndCustomer(String code, User customer);
}
