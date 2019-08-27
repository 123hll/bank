package com.cx.bank.manager;

import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

public interface ManagerInterface {
    //存款
    public boolean deposit(String money)throws InvalidDepositException,NumberFormatException;
    //取款
    public boolean withdrawals(String money)throws AccountOverDrawnException,NumberFormatException;
    //转账

    //退出系统
    public void exitSystem();
    //查询余额
    public  double inquiry();
    //注册
    public boolean register(String fname, String fpass);
    //登录
    public boolean login(String fname, String fpass);
}
