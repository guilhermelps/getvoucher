package com.guilherme.getvoucher.controller;

import com.guilherme.getvoucher.model.Voucher;
import com.guilherme.getvoucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @PostMapping("/generate")
    public List<Voucher> generateVouchers(
            @RequestParam("specialOfferId") String specialOfferId,
            @RequestParam("expirationDate") Date expirationDate) {
        return this.voucherService.generateVouchers(specialOfferId, expirationDate);
    }
}
