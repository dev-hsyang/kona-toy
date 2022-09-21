package com.konai.hsyang.konatoy.exceptions;

public class NoLocationFoundException extends RuntimeException{

    public NoLocationFoundException(){

        super("위치정보를 찾을 수 없습니다.");
    }
}
