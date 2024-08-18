package com.service.customer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseEntity {

    private boolean deleted = Boolean.FALSE;

    @CreatedDate
    @Column(name = "create_at")
    public LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "update_at")
    public LocalDateTime updateAt;

}
