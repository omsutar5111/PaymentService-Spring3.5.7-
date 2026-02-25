package org.payment.service;

import org.payment.dto.PaymentRequest;
import org.payment.dto.PaymentResponse;
import org.payment.model.PaymentStatus;

import java.util.List;

public interface PaymentService {

    PaymentResponse createPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentById(Long id);

    List<PaymentResponse> getAllPayments();

    List<PaymentResponse> getPaymentsByStatus(PaymentStatus status);

    PaymentResponse updatePaymentStatus(Long id, PaymentStatus status);

    void deletePayment(Long id);
}

