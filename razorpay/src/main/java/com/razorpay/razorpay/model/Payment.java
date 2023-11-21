package com.razorpay.razorpay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String mobileNumber;
    private String emailId;
    private BigDecimal amount;
    private String razorpayPaymentId;
    private String razorpayOrderId;
    private String razorpaySignature;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentDateTime;
    private String status;
}
