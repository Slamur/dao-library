package com.slamur.library.daolibrary.dao;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.event.Event;

public abstract class DaoEvent<ItemType extends Item> implements Event<ItemType> {

    public enum Action {
        ADD, UPDATE, REMOVE
    }

    protected final ItemType item;

    protected DaoEvent(ItemType item) {
        this.item = item;
    }

    public ItemType getItem() {
        return item;
    }
}
