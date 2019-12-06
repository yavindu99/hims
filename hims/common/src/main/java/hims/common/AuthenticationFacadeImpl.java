package hims.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacadeImpl implements AuthenticationFacadeInt {

    @Override
    public Authentication getAuthentication() {

        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public String getUsername() {

        try {

            return this.getAuthentication().getName();

        }catch (NullPointerException ex){

            return "";

        }
    }
}
