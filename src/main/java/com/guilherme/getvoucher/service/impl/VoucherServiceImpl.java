package com.guilherme.getvoucher.service.impl;

import com.guilherme.getvoucher.model.SpecialOffer;
import com.guilherme.getvoucher.model.User;
import com.guilherme.getvoucher.model.Voucher;
import com.guilherme.getvoucher.repository.UserRepository;
import com.guilherme.getvoucher.repository.VoucherRepository;
import com.guilherme.getvoucher.service.SpecialOfferService;
import com.guilherme.getvoucher.service.UserService;
import com.guilherme.getvoucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpecialOfferService specialOfferService;

    @Autowired
    private UserService userService;

    @Override
    public List<Voucher> generateVouchers(String specialOfferId, Date expirationDate) {
        SpecialOffer specialOffer = specialOfferService.findById(specialOfferId);

        List<Voucher> vouchers = new ArrayList<>();
        List<User> users = userRepository.findAll();

        users.forEach(user -> {
            Voucher voucher = new Voucher();
            voucher.setExpirationDate(expirationDate);
            voucher.setSpecialOffer(specialOffer);
            voucher.setCustomer(user);
            vouchers.add(voucher);
        });

        return voucherRepository.saveAll(vouchers);
    }

    @Override
    public BigDecimal redeem(String code, String email) {
        User customer = userService.findById(email);
        Voucher voucher = voucherRepository.findByCodeAndCustomer(code, customer);

        Date dateNow = new Date();

        if (voucher == null || voucher.getUsed() || voucher.getExpirationDate().before(dateNow)) {
            throw  new Error("This voucher is invalid!");
        }

        voucher.setUsed(true);
        voucher.setUseDate(dateNow);
        voucherRepository.save(voucher);

        return voucher.getSpecialOffer().getDiscount();
    }

    @Override
    public List<Voucher> findValidVouchersByCustomer(String email) {
        User customer = userService.findById(email);
        Date dateNow = new Date();

        return voucherRepository.findByCustomerAndUsedAndExpirationDateAfter(customer, false, dateNow);
    }
}
