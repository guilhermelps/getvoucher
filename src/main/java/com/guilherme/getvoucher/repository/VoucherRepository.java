package com.guilherme.getvoucher.repository;

import com.guilherme.getvoucher.model.User;
import com.guilherme.getvoucher.model.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface VoucherRepository extends MongoRepository<Voucher, String> {

    public Voucher findByCodeAndCustomer(String code, User customer);

    public List<Voucher> findByCustomerAndUsedAndExpirationDateAfter(User customer, Boolean used, Date dateNow);
}
