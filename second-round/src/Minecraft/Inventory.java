package Minecraft;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private List<ItemStack> items;
    private int capacity = 36; // Default capacity

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public List<ItemStack> getItems() {
        return items;
    }


    public int addItem(ItemStack itemStackToAdd) {
        int remainingToAdd = itemStackToAdd.getQuantity();
        Item newItem = itemStackToAdd.getItem();
        for (ItemStack stack : items) {
            //for-each语法，遍历items列表中的每个stack，
            // 等价于for (int i = 0; i < items.size(); i++) { ItemStack stack = items.get(i); }
//            if (stack.getItem() == newItem) 错误。==比较的是内存地址
            if (stack.getItem().getName().equals(newItem.getName())) { //链式调用{
                int maxStackSize = newItem.getMaxStackSize();//单格最大堆叠数
                int availableSpace = maxStackSize - stack.getQuantity();//单格剩余可堆叠数
                if (remainingToAdd > availableSpace) {  //如果要加的数量大于剩余的空位
                    stack.setQuantity(maxStackSize);    //将当前格子填满
                    remainingToAdd -= availableSpace; //减去已经填进去的数量
                } else {                            //如果剩余的空位足够
                    stack.setQuantity(stack.getQuantity() + remainingToAdd); //直接将剩余的数量加到当前格子
                    remainingToAdd = 0;
                    break;
                }
            }

        }
        while (remainingToAdd > 0 && items.size() < capacity) { //如果还有剩余的，说明需要新建堆了
            int putCount = Math.min(remainingToAdd, newItem.getMaxStackSize());
            items.add(new ItemStack(newItem, putCount));//新建堆
            remainingToAdd -= putCount;
        }
        if (remainingToAdd > 0) {
            return -remainingToAdd;//背包已满，返回剩余未添加的数量
        } else {
            return capacity - items.size();//全加完了，返回背包剩余容量

        }
    }

    public void removeItem(String itemName, int amountToRemove) {
//        for (ItemStack stack : items) {
//            if (stack.getItem().getName().equals(itemName)) {
//                if (stack.getQuantity() > amountToRemove) {
//                    stack.setQuantity(stack.getQuantity() - amountToRemove);
//                    return;
//                } else {
////                    items.remove(stack);//错误，不能调用remove
//                    return;
//                }
//            }
        //
        for (int i = 0; i < items.size(); i++) {
            ItemStack stack = items.get(i);

            //  判断名字是否匹配
            if (stack.getItem().getName().equals(itemName)) {
                // 判断当前堆数量与要移除的数量
                if (stack.getQuantity() <= amountToRemove) {
                    // 情况 A：当前堆不够删，先全删掉
                    amountToRemove -= stack.getQuantity(); // 扣减要删的数量
                    items.remove(i);                       // 安全删除当前索引
                    //这里不能 return，继续循环看后面的堆还有没有同名的
                } else {
                    // 情况 B：当前堆够删，直接减数量
                    stack.setQuantity(stack.getQuantity() - amountToRemove);
                    amountToRemove = 0;
                    break; // 已经删完了，不用再找了
                }
            }

            //  如果删完了，提前结束循环（防止多余遍历）
            if (amountToRemove <= 0) {
                break;
            }
        }

    }
    public int getItemCount(String itemName) {
        int count = 0;
        for (ItemStack stack : items) {
            if (stack.getItem().getName().equals(itemName)) {
                count += stack.getQuantity();
            }
        }
        return count;
    }
    public void display() {
        System.out.println("====== 背包状态 ======");

        // 判断是否为空
        if (items.isEmpty()) {
            System.out.println("背包为空");
        } else {
            for (ItemStack stack : items) {
                System.out.println(stack.getItem().getName() + ": " + stack.getQuantity());
            }

        }

        System.out.println("已用格子: " + items.size() + " / " + capacity);
        System.out.println("======================");
    }

}










