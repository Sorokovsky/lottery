package org.sorokovsky.lottery.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.sorokovsky.lottery.contract.GetUser;
import org.sorokovsky.lottery.entity.UserEntity;
import org.sorokovsky.lottery.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public Optional<UserEntity> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }

    public UserEntity create(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    public GetUser toGetUser(UserEntity user) {
        return modelMapper.map(user, GetUser.class);
    }
}
