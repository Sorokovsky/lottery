package org.sorokovsky.lottery.service;

import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.entity.UserEntity;
import org.sorokovsky.lottery.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public Optional<UserEntity> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
