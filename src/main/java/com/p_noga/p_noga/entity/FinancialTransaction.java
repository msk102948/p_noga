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
 * FinancialTransaction: 구분/재무
 * 예산의 유형 대해 지출,수입 등 구분 값을 생성하고 관리할 수 있는 entity
 *
 */

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FinancialTransaction extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "LedgerId", nullable = false)
    @Comment("가계부 Id")
    private Ledger ledger;

    @Column(length = 20, nullable = false)
    @Comment("구분코드")
    private String classCd;

    @Column(length = 100, nullable = false)
    @Comment("한글명 (지출,저축,수입 등)")
    private String classNm;

    @Column
    @Comment("상세설명 (지출,저축,수입 등)")
    private String description;
}
