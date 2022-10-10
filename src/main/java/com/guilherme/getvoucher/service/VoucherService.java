package com.guilherme.getvoucher.service;

import com.guilherme.getvoucher.model.Voucher;

import java.util.Date;
import java.util.List;

public interface VoucherService {

    public List<Voucher> generateVouchers(String specialOfferId, Date expirationDate);
}
