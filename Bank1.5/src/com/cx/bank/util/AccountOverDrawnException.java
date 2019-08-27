package com.cx.bank.util;

/**
 * 一个异常类继承RuntimeException  取款超出余额时抛出异常
 */
public class AccountOverDrawnException extends RuntimeException {
    /**
     * 无参构造方法
     */
    public AccountOverDrawnException(){

    }

    /**
     * 有参构造方法，为父类私有属性message设值
     * @param msg
     */
    public AccountOverDrawnException(String msg){
        super(msg);
    }
}
