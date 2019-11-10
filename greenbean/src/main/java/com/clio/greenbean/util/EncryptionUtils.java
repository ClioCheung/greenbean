package com.clio.greenbean.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * created by 吾乃逆世之神也 on 2019/11/10
 */
public class EncryptionUtils {
    public static String encode(String password){
        // XXX 这里的BCryptPasswordEncoder是否可以单例
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
