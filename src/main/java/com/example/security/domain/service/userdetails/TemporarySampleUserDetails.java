package com.example.security.domain.service.userdetails;

import java.util.List;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.security.domain.model.Account;


public class TemporarySampleUserDetails extends User {
    private static final long serialVersionUID = 1L;

    private SampleUserDetails sampleUserDetails;// 選ばれしユーザ

    private final List<Account> candidates;// ユーザ候補

    public TemporarySampleUserDetails(List<Account> candidates) {
        // 誰のロールを設定してることになるの？適当にROLE_USERとかにしといていいの？
        super(candidates.get(0).getUsername(), candidates.get(0).getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_TEMPORARY"));
        this.sampleUserDetails = null;
        this.candidates = candidates;
    }


    public void setSampleUserDetails(SampleUserDetails sampleUserDetails) {
        this.sampleUserDetails = sampleUserDetails;
    }

    public SampleUserDetails getSampleUserDetails() {
        return sampleUserDetails;
    }

    public List<Account> getCandidates() {
        return candidates;
    }

}
