package com.konai.hsyang.konatoy.login.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClubEnum {

    ORCH("CLUB_ORCHESTRA", "아주팝스오케스트라"),
    CNCT("CLUB_CONNECT", "커넥트");


    private final String key;
    private final String title;
}
