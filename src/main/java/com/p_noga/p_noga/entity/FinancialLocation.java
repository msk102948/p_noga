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
 * FinancialLocation: 입/출금 위치
 * 예산에 대한 거래처(은행계좌/카드 등)를 관리 할 수 있는 entity
 *
 */

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FinancialLocation extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "LedgerId", nullable = false)
    @Comment("가계부 Id")
    private Ledger ledger;

    @Column(length = 20, nullable = false)
    @Comment("구분코드")
    private String classCd;

    @Column(length = 100, nullable = false)
    @Comment("한글명 (은행이름,카드명 등)")
    private String classNm;

    @Column
    @Comment("상세설명 (거래처에 대한 설명이나 용도 설명 등)")
    private String description;
}
