
package com.uniride.external;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationSystemImpl implements AuthenticationSystem {

    @Override
    public void authenticate() {
        System.out.println("Authenticating user...");
    }

    @Override
    public void provideMFA() {
        System.out.println("Providing MFA...");
    }

    @Override
    public void validateToken() {
        System.out.println("Validating token...");
    }

    @Override
    public void logout() {
        System.out.println("Logging out...");
    }

    @Override
    public void appAuthentication() {
        System.out.println("Authenticating app...");
    }
}
