package com.ecommerce.paymentservice.Services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentService{

    @Override
    public String generatePaymentGatewayLink(Long id) throws StripeException {

        Stripe.apiKey = "sk_test_51Pk3gg042nJPgQeHSulPmpdxB3GBlb4NM7nMS7iCdhe710tcGQtDYLeTwldVo3WlK7KElroreXiIzKcagrVdklAY00yErHeRZb";
        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(10000L)
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Product Bill").build()
                        )
                        .build();

        Price price = Price.create(priceCreateParams);



        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                                                               .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);







        return paymentLink.toString();
    }
}
