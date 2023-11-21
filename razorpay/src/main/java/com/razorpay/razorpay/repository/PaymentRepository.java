package com.razorpay.razorpay.repository;

import com.razorpay.razorpay.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
