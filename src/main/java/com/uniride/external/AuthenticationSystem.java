
package com.uniride.external;

public interface AuthenticationSystem {
    void authenticate();
    void provideMFA();
    void validateToken();
    void logout();
    void appAuthentication();
}
