package org.sorokovsky.lottery.model;

import lombok.Data;
import org.sorokovsky.lottery.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class LotteryUserDetails implements UserDetails {
    private String email;
    private String password;

    public LotteryUserDetails(UserEntity entity) {
        this.email = entity.getEmail();
        this.password = entity.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
