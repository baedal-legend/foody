package com.sparta.baedallegend.domains.payment.repo;

import com.sparta.baedallegend.domains.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
