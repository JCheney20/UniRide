package com.uniride.external;

import org.springframework.stereotype.Service;

@Service
public class StudentVerificationSystemImpl implements StudentVerificationSystem {

    @Override
    public void verifyStudent() {
        System.out.println("Verifying student...");
    }

    @Override
    public void checkEnrollment() {
        System.out.println("Checking enrollment...");
    }

    @Override
    public void validateCredentials() {
        System.out.println("Validating credentials...");
    }

    @Override
    public void sendVerificationCodes() {
        System.out.println("Sending verification codes...");
    }
}
