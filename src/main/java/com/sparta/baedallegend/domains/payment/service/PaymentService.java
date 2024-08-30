package com.sparta.baedallegend.domains.payment.service;

import com.sparta.baedallegend.domains.payment.repo.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;
}
