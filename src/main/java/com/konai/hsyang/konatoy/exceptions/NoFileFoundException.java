package com.konai.hsyang.konatoy.exceptions;

public class NoFileFoundException extends RuntimeException {

    public NoFileFoundException(){
        super("파일이 없습니다.");
    }
}
