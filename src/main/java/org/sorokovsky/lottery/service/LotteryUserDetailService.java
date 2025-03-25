package org.sorokovsky.lottery.service;

import lombok.RequiredArgsConstructor;
import org.sorokovsky.lottery.model.LotteryUserDetails;
import org.sorokovsky.lottery.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LotteryUserDetailService implements UserDetailsService {
    private final UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var exception = new UsernameNotFoundException("User with email %s not found".formatted(username));
        return new LotteryUserDetails(repository.findByEmail(username).orElseThrow(() -> exception));
    }
}
