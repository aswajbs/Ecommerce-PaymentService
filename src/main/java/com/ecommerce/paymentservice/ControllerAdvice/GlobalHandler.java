package com.ecommerce.paymentservice.ControllerAdvice;

import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(StripeException.class)
    public String handleStripeException(StripeException e) {
        return e.getMessage();
    }
}
