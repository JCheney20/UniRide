package com.uniride.external;

import org.springframework.stereotype.Service;

@Service
public class PaymentPlatformImpl implements PaymentPlatform {

    @Override
    public void processTransaction() {
        System.out.println("Processing transaction...");
    }

    @Override
    public void validatePayment() {
        System.out.println("Validating payment...");
    }

    @Override
    public void handleRefunds() {
        System.out.println("Handling refunds...");
    }

    @Override
    public void splitRidePayments() {
        System.out.println("Splitting ride payments...");
    }
}
