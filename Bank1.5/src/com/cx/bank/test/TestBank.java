package com.cx.bank.test;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.ManagerInterface;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

import java.util.Scanner;

public class TestBank {
    /**
     * 定义登陆界面
     */
    private static void loginMenu() {
        System.out.println("------银行系统1.4------");
        System.out.println("------1.注     册------");
        System.out.println("------2.登     录------");
        System.out.println("------3.退出系统-------");
        System.out.println("----欢迎进入银行系统------");
    }

    /**
     * 定义主界面
     */
    private static void printMenu() {
        System.out.println("------主界面！！------");
        System.out.println("------1.显示余额------");
        System.out.println("------2.存    款------");
        System.out.println("------3.取    款-------");
        System.out.println("------4.转    账------");
        System.out.println("------5.退出系统------");
    }

    public static void main(String[] args) {
        ManagerInterface manager = ManagerImpl.getManagerImpl();//获取业务层对象
        Scanner scanner = new Scanner(System.in);
        loginMenu();
        while (true) {
            System.out.println("请输入您的操作：");
            String firstflag = scanner.nextLine();
            if ("1".equals(firstflag)) {
                System.out.println("请输入用户名：");
                String username = scanner.nextLine();
                System.out.println("请输入用户密码：");
                String password = scanner.nextLine();
                boolean a1 = manager.register(username, password);
                if (a1 == true) {
                    System.out.println("恭喜你，注册成功！");
                    loginMenu();
                    continue;
                }
                if (a1 == false) {
                    System.out.println("注册失败！");
                    loginMenu();
                    continue;
                }
            } else if ("2".equals(firstflag)) {
                System.out.println("请输入用户名：");
                String username = scanner.nextLine();
                System.out.println("请输入用户密码：");
                String password = scanner.nextLine();
                boolean a2 = manager.login(username, password);
                if (a2 == true) {
                    System.out.println("恭喜你，登录成功！");
                    printMenu();
                    break;
                }
                if (a2 == false) {
                    System.out.println("密码错误，请重新输入！");
                    loginMenu();
                    continue;
                }
            } else if ("3".equals(firstflag)) {
                System.exit(0);
            }
        }
        while (true) {
            System.out.println("请输入您的操作：");
            String secondflag = scanner.nextLine();
            if ("1".equals(secondflag)) {//显示余额
                System.out.println("你当前余额为" + manager.inquiry());
            } else if ("2".equals(secondflag)) {//存款
                System.out.println("你需要存款的金额为");
                String money=scanner.nextLine();
                try {
                    manager.deposit(money);
                    System.out.println("恭喜你，存款成功：" + manager.inquiry());
                }catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidDepositException e) {
                    System.out.println(e.getMessage());
                }
            } else if ("3".equals(secondflag)) {//取款
                System.out.println("你需要取款的金额为");
                // String i = scanner.next();
                try {
                    String money=scanner.nextLine();
                    manager.withdrawals(money);
                    System.out.println("恭喜你，取款成功：" + manager.inquiry());
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                } catch (AccountOverDrawnException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if ("4".equals(secondflag)) {
                System.out.println("转账");
            }else if ("5".equals(secondflag)) {
                System.out.println("退出成功！");
                manager.exitSystem();

            }
        }
    }
}
