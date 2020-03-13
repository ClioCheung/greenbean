package com.clio.greenbean.exception;

/**
 * created by 吾乃逆世之神也 on 2020/3/13
 */
public class UserRatingDuplicatedException extends RuntimeException{
    
    public UserRatingDuplicatedException(String message) {
        super(message);
    }
}
