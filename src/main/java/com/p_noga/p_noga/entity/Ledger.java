package com.p_noga.p_noga.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ledger  extends BaseEntity {
    @Column()
    @Comment("내용")
    private String content;

    @Column
    @Comment("금액")
    private float budget;

    @Column
    @Comment("집행 여부")
    @ColumnDefault("false")
    private boolean actYn = false;

    @Column(nullable = false)
    @Comment("집행 예정일")
    @ColumnDefault("now()")
    private LocalDate actDueDate = LocalDate.now();

    @Column
    @Comment("비고")
    private String remark;

    @ManyToOne
    @Comment("사용자")
    private Users users;

    @Column
    @Comment("기준일자")
    private Date baseDate;

}
