package com.clio.greenbean.exception;

/**
 * created by 吾乃逆世之神也 on 2019/11/5
 */
public class UsernameDuplicatedException extends RuntimeException {
    
    public UsernameDuplicatedException(String message) {
        super(message);
    }
}
