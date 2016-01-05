package com.slamur.library.daolibrary.provider.event;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.provider.ItemProviderEvent;

import java.util.List;

public class ItemsLoadEvent<ItemType extends Item>
        extends ItemProviderEvent<ItemType, List<ItemType>> {

    public ItemsLoadEvent(List<ItemType> items) {
        super(items);
    }

    public List<ItemType> getItems() {
        return eventObject;
    }
}
