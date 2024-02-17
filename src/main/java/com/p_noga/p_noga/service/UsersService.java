package com.p_noga.p_noga.service;

import com.p_noga.p_noga.dto.UsersDto;
import com.p_noga.p_noga.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public Optional<UsersDto> searchUser(String username) {
        return usersRepository.findById(username)
            .map(UsersDto::from);
    }
}
