package com.konai.hsyang.konatoy.login.config.auth;

import com.konai.hsyang.konatoy.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    // 로그인시 실행
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SessionUser user = new SessionUser(userRepository.findByUsername(username).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 Username입니다.")));
        if(user != null){
            return new PrincipalDetails(user);
        }
        else throw new UsernameNotFoundException("존재하지 않는 Username입니다.");
    }
}
