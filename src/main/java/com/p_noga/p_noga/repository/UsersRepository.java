package com.p_noga.p_noga.repository;

import com.p_noga.p_noga.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,String> {
}
