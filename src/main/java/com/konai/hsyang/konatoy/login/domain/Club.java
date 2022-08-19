package com.konai.hsyang.konatoy.login.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubID;
    private String clubname;
    private String clubinfo;

    @Builder
    public Club(String clubname, String clubinfo){
        this.clubname = clubname;
        this.clubinfo = clubinfo;
    }
}
