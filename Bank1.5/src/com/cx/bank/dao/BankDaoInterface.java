package com.cx.bank.dao;

import com.cx.bank.model.UserBean;

public interface BankDaoInterface {
    //注册
    public boolean register(UserBean user);

    //登录
    public boolean login(UserBean user);
  //存储方法
    public void AddBank(String loginname) throws Exception;
    //获取余额
    public void getBalance(UserBean user)throws Exception;
}
