package com.guilherme.getvoucher.service;

import com.guilherme.getvoucher.model.Voucher;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface VoucherService {

    public List<Voucher> generateVouchers(String specialOfferId, Date expirationDate);

    public BigDecimal redeem(String code, String email);

    public List<Voucher> findValidVouchersByCustomer(String email);
}
