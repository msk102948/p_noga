package com.p_noga.p_noga.entity;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // BaseEntity를 상속한 entity들이 아래 필드들을 컬럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class) // 자동 값 맵핑 설정
public abstract class BaseEntity {
    @Id
    @Column(length = 50)
    @Comment("고유번호")
    private String id;

    @CreatedDate
    @Column( nullable = false, updatable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateAt;

    @Column(nullable = false)
    @ColumnDefault("false")
    @Comment("삭제여부")
    private boolean isDeleted = false;
}
