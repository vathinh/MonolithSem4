package com.group1.monolithsem4.service;


import com.group1.monolithsem4.dto.account.AccountRequest;
import com.group1.monolithsem4.dto.account.AccountResponse;
import com.group1.monolithsem4.dto.user.UserRequest;
import org.springframework.data.domain.Page;

import javax.ws.rs.NotFoundException;

public interface AccountService {
    void updatePassword(AccountRequest accountRequest)
            throws NotFoundException;

    String createKeycloak(UserRequest userRequest);

    Page<AccountResponse> getAllAccounts(String search, Integer first, Integer max, boolean briefRepresentation);

}
