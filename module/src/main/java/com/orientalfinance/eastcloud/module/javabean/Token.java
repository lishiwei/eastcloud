package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/27.
 */

public class Token {
    String token ;

    public Token(String obj) {
        this.token  = obj;
    }

    public String getToken () {
        return token ;
    }

    public void setToken (String obj) {
        this.token  = obj;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token  + '\'' +
                '}';
    }
}
