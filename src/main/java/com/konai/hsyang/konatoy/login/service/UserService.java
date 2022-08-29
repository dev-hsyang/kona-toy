package com.konai.hsyang.konatoy.login.service;

import com.konai.hsyang.konatoy.exceptions.NoUserFoundException;
import com.konai.hsyang.konatoy.login.domain.Role;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.dto.UserJoinRequestDto;
import com.konai.hsyang.konatoy.login.dto.UserUpdateRequestDto;
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
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        requestDto.setEncPassword(encPassword);
        requestDto.setRole(Role.USER);

        return userRepository.save(requestDto.toEntity()).getUserID();
    }

    public Optional<User> findByUsername(String name){
        return userRepository.findByUsername(name);
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

    @Transactional
    public Long updateNickname(Long id, UserUpdateRequestDto requestDto){
        User user = userRepository.findById(id).orElseThrow(() -> new NoUserFoundException());
        user.updateNickname(requestDto);

        return id;
    }

    @Transactional
    public Long updatePassword(Long id, UserUpdateRequestDto requestDto){
        User user = userRepository.findById(id).orElseThrow(() -> new NoUserFoundException());
        String rawPassword = requestDto.getNewPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        System.out.println(validatePassword(user, requestDto.getOldPassword()));
        System.out.println(rawPassword);
        System.out.println(user.getPassword());
        if(validatePassword(user, requestDto.getOldPassword())) {
            requestDto.setEncPassword(encPassword);
            user.updatePassword(requestDto);
            return id;
        }else
            return -1L;
    }

    public boolean validatePassword(User user, String inputPassword){
        if(bCryptPasswordEncoder.matches(inputPassword, user.getPassword()))
            return true;
        else
            return false;
    }

    @Transactional
    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new NoUserFoundException());
        userRepository.delete(user);
    }

}
