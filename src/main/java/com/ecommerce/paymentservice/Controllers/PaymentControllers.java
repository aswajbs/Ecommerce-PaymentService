package com.ecommerce.paymentservice.Controllers;

import com.ecommerce.paymentservice.Dtos.OrderDto;
import com.ecommerce.paymentservice.Services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Payments")
public class PaymentControllers {
    private PaymentService paymentService;
    public PaymentControllers(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping ("/welcome")
    public String welcome(){
        return "Welcome to PaymentService";
    }
    @PostMapping
    public String generatePaymentLink(@RequestBody OrderDto orderDto) throws StripeException {
        return paymentService.generatePaymentGatewayLink(orderDto.getOrderId());
    }
}
