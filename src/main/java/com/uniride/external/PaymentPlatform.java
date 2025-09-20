
package com.uniride.external;

public interface PaymentPlatform {
    void processTransaction();
    void validatePayment();
    void handleRefunds();
    void splitRidePayments();
}
