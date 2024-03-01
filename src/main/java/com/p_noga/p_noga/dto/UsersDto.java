package com.p_noga.p_noga.dto;

import com.p_noga.p_noga.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersDto {
    // user ID
    private String userName;

    private String password;

    private String email;

//    private List<Ledger> ledgers;

    public static UsersDto from(Users entity) {
        return new UsersDto(
            entity.getUserName(),
            entity.getPassword(),
            entity.getEmail()
            );
    }

//    public Users toEntity() {
//        return UserAccount.of(
//            userId,
//            userPassword,
//            email,
//            nickname,
//            memo
//        );
//    }
}

