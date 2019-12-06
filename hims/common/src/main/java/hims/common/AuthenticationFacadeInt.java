package hims.common;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacadeInt {

    Authentication getAuthentication();
    String getUsername();

}
