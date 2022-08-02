package com.konai.hsyang.konatoy.login.config.auth;

import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if(userEntity != null){
            return new UserDetails(userEntity);
        }
        else throw new UsernameNotFoundException("존재하지 않는 Username입니다.");
    }
}
