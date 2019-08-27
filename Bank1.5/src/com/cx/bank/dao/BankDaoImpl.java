package com.cx.bank.dao;

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 持久层,和properties文件之间进行数据读取，修改
 */
public class BankDaoImpl implements BankDaoInterface{
    MoneyBean moneybean=MoneyBean.getMoneyBean();

    /**
     * 注册方法的实现
     * @param user
     * @return
     */
    public boolean register(UserBean user){
        String name=user.getUsername();
        String password=user.getPassword();
        File f=new File(name+".properties");
        if(f.exists()){
            System.out.println("该用户已存在，请重新注册");
            return false;
        }else{
            if(" ".equals(name)&&" ".equals(password)){
                System.out.println("用户名和密码不能为空，请重新输入");
                return false;
            }else{
                try{
                    //实例化一个Properties对象
                    Properties props=new  Properties();
                    //创建文件字节输入流，从Properties文件通过流读取
                    FileInputStream fis=new FileInputStream(new File("Bank.properties"));
                    //加载流内容至Properties对象
                    props.load(fis);
                    fis.close();
                    props.setProperty("username", name);
                    props.setProperty("password", password);
                    props.setProperty("money", "10");
                    FileOutputStream fos=new FileOutputStream(name+".properties");
                    props.store(fos, name+".properties");
                    fos.close();
                    //System.out.println("注册成功!");
                    return true;
                }catch(IOException e){
                    System.out.println("读取文件出错！");
                    return false;
                }
            }

        }

    }
    //登录
    public boolean login(UserBean user) {
        String name=user.getUsername();
        String password=user.getPassword();
        try{
            Properties props=new Properties();
            File f=new File(".\\"+name+".properties");
            FileInputStream fis=new FileInputStream(f);
            props.load(fis);
            fis.close();
            if(name.equals(props.getProperty("username"))&&password.equals(props.getProperty("password"))){
                moneybean.setMoney(Double.parseDouble(props.getProperty("money")));
                System.out.println("登录成功！");
                return true;
            }else{
                System.out.println("密码错误！");
                return false;
            }
        }catch(IOException e){
            System.out.println("用户不存在！");
            return false;
        }

    }

    //转账
   // public boolean transfer(){

    /**
     * /存储方法实现
     * @param loginname
     * @throws Exception
     */
    public void AddBank(String loginname) throws Exception {
        //读取文件
        Properties props=new Properties();
        File f=new File(loginname+".properties");
        //创建文件字节输入流对象,并且和Properties文件关联 必须有当前文件
        FileInputStream fis=new FileInputStream(f);
        fis.close();
        props.setProperty("money",new Double(moneybean.getMoney()).toString());
        //创建文件字节输出流对象
        FileOutputStream fos=new FileOutputStream(loginname+".properties");
        props.store(fos, loginname+".properties");
        fos.close();
    }
    /**获取余额实现—getBalance()
     *
     */
    public void getBalance(UserBean user) throws Exception {
        String name=user.getUsername();
        String password=user.getPassword();
        //读取文件
        Properties props=new Properties();
        File f=new File(name+".properties");
        //创建文件字节输入流对象,并且和Properties文件关联 必须有当前文件
        FileInputStream fis=new FileInputStream(f);
        fis.close();
        props.setProperty("money",new Double(moneybean.getMoney()).toString());
        props.setProperty("username",name);
        props.setProperty("password",password);
        //创建文件字节输出流对象
        FileOutputStream fos=new FileOutputStream(name+".properties");
        props.store(fos, name+".properties");
        fos.close();
    }
    /*public boolean getBalance(UserBean user){
        String name=user.getUsername();
        String password=user.getPassword();
        // MoneyBean money=new MoneyBean();
        try{
            Properties props=new Properties();
            File f=new File(name+".properties");
            FileInputStream fis=new FileInputStream(f);
            props.load(fis);
            fis.close();
            moneybean.setMoney(Double.parseDouble(props.getProperty("money")));
            props.setProperty("username", name);
            props.setProperty("password", password);
            //props.setProperty("money", Double.toString(moneybean.getMoney()));
            FileOutputStream fos=new FileOutputStream(name+".properties");
            props.store(fos, name+".properties");
            fos.close();
            return true;
        }catch(IOException e){
            System.out.println("获取余额失败！");
            return false;
        }
    }*/
}
