package com.konai.hsyang.konatoy.login.config.auth;

import com.konai.hsyang.konatoy.login.domain.Role;
import com.konai.hsyang.konatoy.login.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String username;
    private String password;
    private Role role;

    public SessionUser(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
    }
}
