package com.slamur.library.daolibrary.provider;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.event.Event;

public abstract class ItemProviderEvent<ItemType extends Item, EventObjectType> implements Event<ItemType> {

    public enum Action {
        LOAD_ITEM, LOAD_ITEMS, LOAD_ITEM_PARAMETER
    }

    protected final EventObjectType eventObject;

    protected ItemProviderEvent(EventObjectType eventObject) {
        this.eventObject = eventObject;
    }
}
