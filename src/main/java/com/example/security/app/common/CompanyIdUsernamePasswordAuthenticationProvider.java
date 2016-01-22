package com.example.security.app.common;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.security.domain.model.Account;
import com.example.security.domain.service.userdetails.SampleUserDetails;
import com.example.security.domain.service.userdetails.TemporarySampleUserDetails;

public class CompanyIdUsernamePasswordAuthenticationProvider extends
        DaoAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {

        CompanyIdUsernamePasswordAuthenticationToken companyIdUsernamePasswordAuthentication =
                (CompanyIdUsernamePasswordAuthenticationToken) authentication;
        TemporarySampleUserDetails sampleUserDetails =
                (TemporarySampleUserDetails) userDetails;

        // 候補からユーザ情報を絞り込む
        for (Account account : sampleUserDetails.getCandidates()) {
            if (account.getCompanyId().equals(
                    companyIdUsernamePasswordAuthentication.getCompanyId())) {
                // 絞り込まれた情報をUserDetailsに格納する
                sampleUserDetails.setSampleUserDetails(new SampleUserDetails(account));
            }
        }

        // (id,password)の認証をする
        super.additionalAuthenticationChecks(sampleUserDetails.getSampleUserDetails(),
                authentication);

        // componyIdの認証をする
        String requestedCompanyId =
                companyIdUsernamePasswordAuthentication.getCompanyId();
        String companyId =
                sampleUserDetails.getSampleUserDetails().getAccount().getCompanyId();

        if (!companyId.equals(requestedCompanyId)) {
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
    }

    // 認証後に利用されるUserDetailsはSampleUserDetailsにする
    @Override
    protected Authentication createSuccessAuthentication(Object principal,
            Authentication authentication, UserDetails user) {

        TemporarySampleUserDetails temporarySampleUserDetails =
                (TemporarySampleUserDetails) user;
        SampleUserDetails sampleUserDetails =
                temporarySampleUserDetails.getSampleUserDetails();

        String companyId = sampleUserDetails.getAccount().getCompanyId();
        return new CompanyIdUsernamePasswordAuthenticationToken(sampleUserDetails,
                authentication.getCredentials(), companyId,
                sampleUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CompanyIdUsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }

}
