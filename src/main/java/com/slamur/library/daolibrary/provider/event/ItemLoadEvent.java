package com.slamur.library.daolibrary.provider.event;


import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.provider.ItemProviderEvent;

public class ItemLoadEvent <ItemType extends Item>
        extends ItemProviderEvent<ItemType, ItemType> {

    public ItemLoadEvent(ItemType item) {
        super(item);
    }

    public ItemType getItem() {
        return eventObject;
    }
}
