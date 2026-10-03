package 银行管理系统;

import java.util.Scanner;

public class bank_manage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long balance = 0;

        while (true) {


        System.out.println("欢迎使用银行管理系统");
        System.out.println("请选择操作：");
        System.out.println("1. 存款");
        System.out.println("2. 取款");
        System.out.println("3. 查询余额");
        System.out.println("4. 退出");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("请输入存款金额：");
                long money = scanner.nextLong();
                balance += money;
                System.out.println("存款成功，当前余额为：" + balance);

                break;
            case 2:
                System.out.println("请输入取款金额：");
                long amount = scanner.nextLong();
                if (amount>balance){
                    System.out.println("余额不足");
                }
                else {
                    balance -= amount;
                    System.out.println("取款成功，当前余额为：" + balance);
                }

                break;
            case 3:
                System.out.println("当前余额为：" + balance);

                break;
            case 4:
                System.out.println("退出系统,谢谢使用");
                return;
            default:
                System.out.println("无效的选择");
        }

        }





    }
}
