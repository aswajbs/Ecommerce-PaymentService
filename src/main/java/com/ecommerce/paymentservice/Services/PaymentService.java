package com.ecommerce.paymentservice.Services;

import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    String generatePaymentGatewayLink(Long id) throws StripeException;
}
