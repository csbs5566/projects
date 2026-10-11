package Minecraft;

import java.sql.SQLOutput;

public class RunTest {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

// 测试1：添加30个石头
        int result1 = inv.addItem(new ItemStack(new Item("石头", 64), 30));


// 测试2：添加40个石头
        int result2 = inv.addItem(new ItemStack(new Item("石头", 64), 40));
//
//
//        inv.addItem(new ItemStack(new Item("钻石剑", 1), 1));
//        for (int i = 0; i < 35; i++) {
//            int result = inv.addItem(new ItemStack(new Item("木板", 64), 64));
//            if (result < 0) {
//                System.out.println("第 " + (i + 1) + " 次添加木板失败，背包已满，未添加数量: " + (-result));
//            }
//        }



//
//
        inv.removeItem("石头",10);
//        System.out.println("移除10个石头后，第一堆数量: " + inv.getItems().get(0).getQuantity()); // 预期：54
//        System.out.println("-------------------------------------------------");
        inv.display();
//        System.out.println("石头总数: " + inv.getItemCount("石头"));

    }


}




