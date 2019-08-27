package com.cx.bank.util;

/**
 * 存款为负数时抛出异常
 */
public class InvalidDepositException extends Exception{

    /**
     * 无参构造方法
     */
    public InvalidDepositException(){

    }

    /**
     * 有参构造方法，为父类私有属性message设值
     * @param msg
     */
    public InvalidDepositException(String msg){
        super(msg);
    }
}
