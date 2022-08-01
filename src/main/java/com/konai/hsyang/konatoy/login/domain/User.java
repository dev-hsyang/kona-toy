package com.konai.hsyang.konatoy.login.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clubID;
    private String username;
    private String password;
    private String nickname;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    @Builder
    public User(String userName, String userPw, String userNickname, Long clubID){
        this.username = userName;
        this.password = userPw;
        this.nickname = userNickname;
        this.clubID = clubID;
    }
}
