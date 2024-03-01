package com.p_noga.p_noga.repository;

import com.p_noga.p_noga.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,String> {
    Optional<Users> findUsersByUserName(String userName);
}
