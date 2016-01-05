package com.slamur.library.daolibrary.dao.list;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.dao.DaoEvent;

public class ListEvent<ItemType extends Item> extends DaoEvent<ItemType> {

    protected final int index;

    public ListEvent(ItemType item, int index) {
        super(item);

        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
