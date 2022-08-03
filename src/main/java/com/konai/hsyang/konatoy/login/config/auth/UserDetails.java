package com.konai.hsyang.konatoy.login.config.auth;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private SessionUser sessionUser;

    public UserDetails(SessionUser user) {
        this.sessionUser = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return sessionUser.getRole().getKey();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return sessionUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sessionUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
