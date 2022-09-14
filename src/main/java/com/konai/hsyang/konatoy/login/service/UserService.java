package com.konai.hsyang.konatoy.login.service;

import com.konai.hsyang.konatoy.exceptions.NoUserFoundException;
import com.konai.hsyang.konatoy.login.etc.Role;
import com.konai.hsyang.konatoy.login.domain.User;
import com.konai.hsyang.konatoy.login.dto.UserJoinRequestDto;
import com.konai.hsyang.konatoy.login.dto.UserUpdateRequestDto;
import com.konai.hsyang.konatoy.login.repository.UserRepository;
import com.konai.hsyang.konatoy.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PostsRepository postsRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

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

    public int validateID(String name){

        return userRepository.findByUsername(name).orElse(null) == null ? 1 : -1;
    }

    public int validateNickname(String name){

        return userRepository.findByNickname(name).orElse(null) == null ? 1 : -1;
    }

    public boolean validatePassword(User user, String inputPassword){ // 입력한 비밀번호가 회원정보의 암호화된 비밀번호와 일치하는지 검사

        return bCryptPasswordEncoder.matches(inputPassword, user.getPassword());
    }

    @Transactional
    public Long updateNickname(Long id, UserUpdateRequestDto requestDto){

        User user = userRepository.findById(id).orElseThrow(() -> new NoUserFoundException());
        if(!validatePassword(user, requestDto.getOldPassword())) // 현재 비밀번호가 일치하지 않으면
            return -1L; // -1 반환
        user.updateNickname(requestDto);
        // 세션 업데이트
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), requestDto.getOldPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return id;
    }

    @Transactional
    public Long updatePassword(Long id, UserUpdateRequestDto requestDto){

        User user = userRepository.findById(id).orElseThrow(() -> new NoUserFoundException());
        String rawPassword = requestDto.getNewPassword(); // 수정할 비밀번호
        String encPassword = bCryptPasswordEncoder.encode(rawPassword); // 수정할 비밀번호 암호화
        if(validatePassword(user, requestDto.getOldPassword())) { // 현재 비밀번호가 일치하면
            requestDto.setEncPassword(encPassword); // 비밀번호 수정절차 진행
            user.updatePassword(requestDto);
            return id;
        }else
            return -1L;
    }

    @Transactional
    public void delete(Long id){

        postsRepository.deleteAllByUser(id); // 유저가 작성했던 게시글들 전부 삭제
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> new NoUserFoundException()));
    }
}
