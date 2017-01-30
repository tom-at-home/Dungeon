package de.urbaniak.dungeon.items;

public class Food extends Item{

    private int hp;

    public Food(String name, int hp) {
        super(name, true);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }
}
