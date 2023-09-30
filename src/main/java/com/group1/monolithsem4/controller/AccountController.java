package com.group1.monolithsem4.controller;


import com.group1.monolithsem4.dto.account.AccountResponse;
import com.group1.monolithsem4.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

import static com.group1.monolithsem4.controller.EndPoints.ACCOUNT_PATH;


@RestController
@Slf4j
@Validated
@RequestMapping(ACCOUNT_PATH)
@RequiredArgsConstructor
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Page<AccountResponse> getAllAccounts(@QueryParam("search") String search, @QueryParam("first") Integer first, @QueryParam("max") Integer max, @QueryParam("briefRepresentation") boolean briefRepresentation) {
        return accountService.getAllAccounts(search, first, max, briefRepresentation);
    }
}
