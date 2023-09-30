package com.group1.monolithsem4.dto.user;

import com.group1.monolithsem4.dto.PagingRequest;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria implements PagingRequest {

    private int id;
    private Integer managerId;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String userType;
    private String keycloakId;

    private String search;
    private int size;
    private int page;
    private String lastedValue = "";
    private int lastedPage;
    private String firstValue = "";
    private List<String> sort;
}
