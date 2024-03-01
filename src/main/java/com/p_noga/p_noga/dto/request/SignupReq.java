package com.p_noga.p_noga.dto.request;

import com.p_noga.p_noga.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class SignupReq {

    // todo: java 버전 upgrade 후에 valid를 위한 컬럼 추가

    String userName;
    @Setter
    String password;
    String email;

    public Users toEntity(){
        return Users.of(
            userName,
            password,
            email
        );
    }
}
