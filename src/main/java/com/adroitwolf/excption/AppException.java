package com.adroitwolf.excption;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName AppExceptiom.java
 * @Description TODO
 * @createTime 2021年02月24日 14:55:00
 */
public class AppException extends RuntimeException{

    private String msg;

    public AppException(String message, Throwable cause) {
        super(message,cause);
    }


    public AppException(String message) {
        super(message);
    }
}
