package com.slamur.library.daolibrary.dao;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.event.Listener;

import java.util.Collection;

public interface DaoListener <
        ItemType extends Item,
        DaoListenerType extends DaoListener <ItemType, DaoListenerType, DaoEventType, DaoType, ItemCollection>,
        DaoEventType extends DaoEvent<ItemType>,
        DaoType extends Dao<ItemType, DaoListenerType, DaoEventType, ItemCollection, DaoType>,
        ItemCollection extends Collection<ItemType>
        >
        extends Listener<ItemType, DaoListenerType, DaoType> {

    void onItemAdded(DaoEventType addItemEvent);
    void onItemUpdated(DaoEventType updateItemEvent);
    void onItemRemoved(DaoEventType removeItemEvent);
}
