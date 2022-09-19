package com.konai.hsyang.konatoy.exceptions;

public class NoCommentFoundException extends RuntimeException{

    public NoCommentFoundException(){
        super("댓글이 없습니다.");
    }
}
