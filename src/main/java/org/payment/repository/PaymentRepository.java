package org.payment.repository;

import org.payment.model.Payment;
import org.payment.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByOrderId(String orderId);

    List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);

    Optional<Payment> findByTransactionId(String transactionId);
}

