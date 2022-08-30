package com.konai.hsyang.konatoy.exceptions;

public class NoClubFoundException extends RuntimeException{

    public NoClubFoundException(){
        super("해당 동아리가 없습니다.");
    }
}
