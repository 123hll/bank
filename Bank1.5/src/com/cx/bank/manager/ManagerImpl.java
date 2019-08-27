package com.cx.bank.manager;

import com.cx.bank.dao.BankDaoImpl;
import com.cx.bank.dao.BankDaoInterface;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

/**
 * 业务层，封装操作
 */
public class ManagerImpl implements ManagerInterface{
    //单利以保证若一个人对同一个账户进行转账和存款操作而导致异常
    private static ManagerImpl manager;//定义一个私有的静态全局变量
    private ManagerImpl(){

    }
    //获取一个业务对象
    public static ManagerImpl getManagerImpl(){
        if(manager==null){
            manager=new ManagerImpl();
        }
        return manager;
    }
    MoneyBean moneybean=MoneyBean.getMoneyBean();//实例化银行账户钱对象
    UserBean userbean=new  UserBean();//实例化一个业务对象，封装业务信息
    BankDaoInterface dao=new BankDaoImpl();

    /**
     * 查询余额
     * @return
     */
    public  double inquiry(){
       // boolean flag=dao.getBalance(userbean);
        return moneybean.getMoney();
    }

    /**
     * 存款方法的实现
     * @param money
     * @return
     * @throws InvalidDepositException
     * @throws NumberFormatException
     */
    public boolean deposit(String money)throws InvalidDepositException,NumberFormatException{
        double nmoney=Double.parseDouble(money);
        double 	l= moneybean.getMoney();
        if (nmoney < 0)
        {throw new InvalidDepositException("存款金额需要大于零");}
        moneybean.setMoney(l+nmoney);
        return true;
    }
    /**
     * 取款方法
     * @param money
     * @return
     * @throws AccountOverDrawnException
     * @throws NumberFormatException
     */
    public boolean withdrawals(String money)throws AccountOverDrawnException,NumberFormatException{
        double nmoney=Double.parseDouble(money);
        double l=moneybean.getMoney()-nmoney;
        if(l<0){
            throw new AccountOverDrawnException("你好，余额不足");
        }if(nmoney<0){
            throw new AccountOverDrawnException("你好，取款金额需要大于零");
        }
        moneybean.setMoney(l);
        return true;
    }
    //转账
    // public boolean transfer(){
    /**
     * 退出系统方法的实现
     */
    public void exitSystem(){
       // String name=userbean.getUsername();
        try {
            dao.getBalance(userbean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 注册方法的实现
     * @param fname
     * @param fpass
     * @return
     */
    public boolean register(String fname, String fpass) {
        //从测试层传来两个参数
        userbean.setUsername(fname);
        userbean.setPassword(fpass);
        boolean flag = dao.register(userbean);
        return flag;
    }
    /**
     * 登录方法的实现
     * @param fname
     * @param fpass
     * @return
     */
    public boolean login(String fname, String fpass) {
        userbean.setUsername(fname);
        userbean.setPassword(fpass);
        boolean flag=dao.login(userbean);
        return flag;
    }
}
