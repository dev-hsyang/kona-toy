package com.konai.hsyang.konatoy.login.service;

import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.dto.UserJoinRequestDto;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long join(UserJoinRequestDto requestDto){
        String rawPassword = requestDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        requestDto.setEncPassword(encPassword);

        return userRepository.save(requestDto.toEntity()).getId();
    }

    public boolean duplicateID(String name){
        User user = userRepository.findByUsernameContaining(name);
        return user != null;
    }

    public boolean duplicateNick(String name){
        User user = userRepository.findByNicknameContaining(name);
        return user != null;
    }
}
