package com.konai.hsyang.konatoy.login.config.auth;

import com.konai.hsyang.konatoy.login.domain.Club;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.etc.Role;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Profile("test")
public class TestPrincipalDetailsService implements UserDetailsService {

    public static final String USERNAME = "testname";
    public static final String NICKNAME = "testnick";
    public static final String PASSWORD = "testpw";
    public static final String CLUB = "testclub";

    private SessionUser getUser(){
        return new SessionUser(User.builder()
                .userID(1L)
                .userName(USERNAME)
                .userNickname(NICKNAME)
                .userPw(PASSWORD)
                .club(Club.builder()
                        .clubname(CLUB)
                        .build())
                .role(Role.USER)
                .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals(USERNAME)) {
            return new PrincipalDetails(getUser());
        }
        return null;
    }
}
