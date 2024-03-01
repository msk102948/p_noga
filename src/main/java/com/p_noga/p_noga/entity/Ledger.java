package com.p_noga.p_noga.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ledger extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    @Comment("사용자")
    private Users users;

    @Column
    @Comment("기준일자")
    private Date baseDate;
}
