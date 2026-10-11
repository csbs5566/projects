package Minecraft;

public class Item {
    private String name;
    private int maxStackSize;

    public Item (){

    }
    public Item (String name, int maxStackSize) {
        this.name = name;
        this.maxStackSize = maxStackSize;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }



}
