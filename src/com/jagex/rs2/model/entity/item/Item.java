package com.jagex.rs2.model.entity.item;

import com.jagex.rs2.model.Model;
import com.jagex.rs2.model.anim.Animable;


public final class Item extends Animable {

    public final Model getRotatedModel() {
        ItemDef itemDef = ItemDef.forID(ID);
        return itemDef.method201(anInt1559);
    }

    public Item() {
    }

    public int ID;
    public int x;
    public int y;
    public int anInt1559;
}
