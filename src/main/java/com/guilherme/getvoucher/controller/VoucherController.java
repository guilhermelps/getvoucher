package com.guilherme.getvoucher.controller;

import com.guilherme.getvoucher.model.Voucher;
import com.guilherme.getvoucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/generate")
    public List<Voucher> generateVouchers(
            @RequestParam("specialOfferId") String specialOfferId,
            @RequestParam("expirationDate") Date expirationDate) {
        return voucherService.generateVouchers(specialOfferId, expirationDate);
    }

    @GetMapping("/redeem/{code}")
    public BigDecimal redeem(@PathVariable String code, @RequestParam("email") String email) {
        return voucherService.redeem(code, email);
    }

    @GetMapping("/user/valid")
    public List<Voucher> findValidVouchersByCustomer(@RequestParam("email") String email) {
        return voucherService.findValidVouchersByCustomer(email);
    }
}
