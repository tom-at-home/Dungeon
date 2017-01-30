package de.urbaniak.dungeon.items;

public class Item {

    protected String name;
    protected boolean isEatable;

    public Item(String name, boolean isEatable){
        this.name = name;
        this.isEatable = isEatable;
    }

    public String getName() {
        return name;
    }

    public boolean isEatable() {
        return isEatable;
    }
}
