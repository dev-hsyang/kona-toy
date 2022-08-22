package com.konai.hsyang.konatoy.login.service;

import com.konai.hsyang.konatoy.login.domain.Role;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.dto.UserJoinRequestDto;
import com.konai.hsyang.konatoy.login.repository.ClubRepository;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ClubRepository clubRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long join(UserJoinRequestDto requestDto){
        String rawPassword = requestDto.getPassword();

        System.out.println(requestDto.getUsername());
        System.out.println(requestDto.getPassword());
        System.out.println(requestDto.getNickname());

        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        requestDto.setEncPassword(encPassword);
        requestDto.setRole(Role.USER);

        return userRepository.save(requestDto.toEntity()).getUserID();
    }

    public int duplicateID(String name){
        User user = userRepository.findByUsername(name).orElse(null);
        if(user==null)
            return 1;
        return -1;
    }

    public int duplicateNick(String name){
        User user = userRepository.findByNickname(name).orElse(null);
        if(user==null)
            return 1;
        return -1;
    }
}
