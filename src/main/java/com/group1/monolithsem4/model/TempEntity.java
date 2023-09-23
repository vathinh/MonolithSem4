package com.group1.monolithsem4.model;


import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "temps", indexes = @Index(columnList = "id"), uniqueConstraints={@UniqueConstraint(columnNames={"tempName"})})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class TempEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tempName;

    private String tempDes;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private ZonedDateTime createdDate;

    @LastModifiedDate
    private ZonedDateTime modifiedDate;

    private boolean deleteFlag = false;

    @Version
    private Long version;
}
