package com.group1.monolithsem4.dto.account;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    protected String id;
    protected Long createdTimestamp;
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
}
