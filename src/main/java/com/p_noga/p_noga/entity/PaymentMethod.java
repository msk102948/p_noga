package com.p_noga.p_noga.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * PaymentMethod: 경로/거래유형
 * 예산의 현금/카드 등 거래유형을 생성하고 관리할 수 있는 entity
 *
 */

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "LedgerId", nullable = false)
    @Comment("가계부 Id")
    private Ledger ledger;

    @Column(length = 20, nullable = false)
    @Comment("구분코드")
    private String classCd;

    @Column(length = 100, nullable = false)
    @Comment("한글명 (현금,카드 등)")
    private String classNm;

    @Column
    @Comment("상세설명 (현금,카드 등)")
    private String description;
}
