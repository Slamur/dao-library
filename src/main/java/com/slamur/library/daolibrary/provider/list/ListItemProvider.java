package com.slamur.library.daolibrary.provider.list;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.provider.ItemProvider;

public abstract class ListItemProvider<
        ItemType extends Item,
        ListItemProviderType extends ListItemProvider<ItemType, ListItemProviderType>>
    extends ItemProvider<ItemType, ListItemProviderType> {

    public abstract void loadItem(int index);

    public abstract void saveItem(int index, ItemType item);
}
