package com.slamur.library.daolibrary.provider;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.event.Notifier;

import java.util.List;

public abstract class ItemProvider <
        ItemType extends Item,
        ItemProviderType extends ItemProvider<ItemType, ItemProviderType>
        >
        extends Notifier<ItemType, ItemProviderListener<ItemType, ItemProviderType>, ItemProviderType> {

    public abstract void loadItems();

    public abstract void saveItems(List<ItemType> items);

    public abstract void loadItem(long id);

    public abstract void saveItem(ItemType item);

    public abstract void loadItemsCount();
}
