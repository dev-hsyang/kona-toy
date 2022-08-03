package com.konai.hsyang.konatoy.login.config.auth;

import com.konai.hsyang.konatoy.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SessionUser user = new SessionUser(userRepository.findByUsername(username));

        if(user != null){
            //httpSession.setAttribute("user", user); // 로그인 성공 시점으로 옮겨야한다.
            System.out.println("log 1");
            return new UserDetails(user);
        }
        else throw new UsernameNotFoundException("존재하지 않는 Username입니다.");
    }
}
