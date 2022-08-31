package com.konai.hsyang.konatoy.exceptions;

public class NoPostsFoundException extends RuntimeException{

    public NoPostsFoundException(){
        super("게시글을 찾을 수 없습니다.");
    }
}
