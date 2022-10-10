package com.guilherme.getvoucher.service.impl;

import com.guilherme.getvoucher.model.SpecialOffer;
import com.guilherme.getvoucher.model.User;
import com.guilherme.getvoucher.model.Voucher;
import com.guilherme.getvoucher.repository.UserRepository;
import com.guilherme.getvoucher.repository.VoucherRepository;
import com.guilherme.getvoucher.service.SpecialOfferService;
import com.guilherme.getvoucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
