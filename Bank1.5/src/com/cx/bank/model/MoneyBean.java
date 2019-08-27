package com.cx.bank.model;

public class MoneyBean {
    //单利模式，数据共享，降低耦合性
    private static MoneyBean moneyBean;//定义一个私有的moneyBean
    //定义私有的构造方法
    private MoneyBean(){

    }
    //获取一个MoneyBean对象
    public static MoneyBean getMoneyBean(){
        if(moneyBean==null){
            moneyBean=new MoneyBean();
        }
        return moneyBean;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private double money;//定义私有属性money

}
