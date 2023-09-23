package com.group1.monolithsem4.dto.temp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TempRequest {

    @NotBlank
    private String tempName;

    @NotBlank
    private String tempDes;


    private Long version;
}
