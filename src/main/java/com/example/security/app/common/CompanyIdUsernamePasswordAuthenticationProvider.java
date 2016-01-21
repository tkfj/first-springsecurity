package com.example.security.app.common;

import com.example.security.domain.service.userdetails.SampleUserDetails;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CompanyIdUsernamePasswordAuthenticationProvider
        extends DaoAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication)
                    throws AuthenticationException {

        super.additionalAuthenticationChecks(userDetails, authentication);

        CompanyIdUsernamePasswordAuthenticationToken companyIdUsernamePasswordAuthentication =
                (CompanyIdUsernamePasswordAuthenticationToken) authentication;
        String requestedCompanyId =
                companyIdUsernamePasswordAuthentication.getCompanyId();
        String companyId = ((SampleUserDetails) userDetails).getAccount().getCompanyId();
        if (!companyId.equals(requestedCompanyId)) {
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
    }

    @Override
    protected Authentication createSuccessAuthentication(Object principal,
            Authentication authentication, UserDetails user) {
        String companyId = ((SampleUserDetails) user).getAccount().getCompanyId();
        return new CompanyIdUsernamePasswordAuthenticationToken(user,
                authentication.getCredentials(), companyId, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CompanyIdUsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }

}
