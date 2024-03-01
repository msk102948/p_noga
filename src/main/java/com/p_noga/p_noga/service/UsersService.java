package com.p_noga.p_noga.service;

import com.p_noga.p_noga.common.exceptionHandler.CustomResponse;
import com.p_noga.p_noga.common.exceptionHandler.ExceptionCode;
import com.p_noga.p_noga.common.exceptionHandler.customException.BadRequestException;
import com.p_noga.p_noga.dto.UsersDto;
import com.p_noga.p_noga.dto.request.SignupReq;
import com.p_noga.p_noga.entity.Users;
import com.p_noga.p_noga.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.p_noga.p_noga.config.SecurityConfig.passwordEncoder;

@RequiredArgsConstructor
@Transactional
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    private final Logger logger = LoggerFactory.getLogger(UsersService.class);


    @Transactional(readOnly = true)
    public Optional<UsersDto> searchUser(String username) {
        return usersRepository.findUsersByUserName(username)
            .map(UsersDto::from);
    }

    public UsersDto saveUser(SignupReq signupReq){
        signupReq.setPassword( passwordEncoder().encode(signupReq.getPassword()));
        Users users;
        try{
            // 영속성으로 인해 쿼리가 실행되기 전 error을 발생시키기 때문에 try 블럭에서 즉시 실행 후 error을 잡아내는 것으로 함
            users = usersRepository.saveAndFlush(signupReq.toEntity());
        }catch (DataIntegrityViolationException e){
            logger.warn("error {}",  e.getMessage());
            throw new BadRequestException(new CustomResponse(ExceptionCode.E10002));
        }
        return UsersDto.from(users);
    }

}
