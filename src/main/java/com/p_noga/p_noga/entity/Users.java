package com.p_noga.p_noga.entity;

import com.p_noga.p_noga.dto.request.SignupReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {

    @Column(length = 20, unique = true, nullable = false)
    @Comment("유저가 직접 입력한 Id")
    private String userName;

    @Column(nullable = false)
    @Comment("비밀번호")
    private String password;

    @Column(length = 100, unique = true, nullable = false)
    @Comment("이메일")
    private String email;

    @OneToMany
    private List<Ledger> ledgers;

    public static Users of(String userName, String password, String email){
        return new Users(userName,password,email,null);
    }
}
