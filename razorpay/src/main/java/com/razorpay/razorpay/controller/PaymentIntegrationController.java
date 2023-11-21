package com.razorpay.razorpay.controller;


import com.razorpay.Order;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.razorpay.model.Payment;
import com.razorpay.razorpay.repository.PaymentRepository;
import com.razorpay.razorpay.util.Signature;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.SignatureException;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin
public class PaymentIntegrationController {
    @Value("${rzp_key_id}")
    private String keyId;

    @Value("${rzp_key_secret}")
    private String secret;
    @Autowired
    PaymentRepository paymentRepository;
    @GetMapping("/payment/{amount}")
    public String Payment(@PathVariable String amount) throws RazorpayException {
        System.out.println("inside payment amount>>>>>>>>");
        RazorpayClient razorpayClient = new RazorpayClient(keyId, secret);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "order_receipt_11");

        Order order = razorpayClient.orders.create(orderRequest);
        String orderId = order.get("id");
        System.out.println(orderId);
        return orderId;
    }



    @GetMapping("/payments")
    public List<Payment> getPayments(){
        return paymentRepository.findAll();
    }

    @PostMapping("/create_order")
    public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
        int amount = Integer.parseInt(data.get("amount").toString());
        RazorpayClient razorpayClient = new RazorpayClient(keyId, secret);

        JSONObject ob = new JSONObject();
        ob.put("amount", amount*100);
        ob.put("currency", "INR");
        ob.put("receipt", "rec_1234");

        Order order = razorpayClient.orders.create(ob);
        System.out.println(order);
        return order.toString();
    }

    @PostMapping("/payment")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) throws SignatureException {
        String generatedSignature = Signature.calculateRFC2104HMAC(payment.getRazorpayOrderId() + "|" +payment.getRazorpayPaymentId(), "iYHfHn2hAVANk25M7m3OFJG5");
        if(payment.getRazorpaySignature().equals(generatedSignature)) {
            payment.setPaymentDateTime(LocalDateTime.now());
            return ResponseEntity.ok(paymentRepository.save(payment));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Transaction, Signature not verified");
    }
}
