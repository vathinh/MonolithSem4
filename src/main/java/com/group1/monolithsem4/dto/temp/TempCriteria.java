package com.group1.monolithsem4.dto.temp;

import com.group1.monolithsem4.dto.PagingRequest;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TempCriteria implements PagingRequest {

    private String tempName;
    private String tempDes;

    private String search;
    private int size;
    private int page;
    private String lastedValue = "";
    private int lastedPage;
    private String firstValue = "";
    private List<String> sort;
}
