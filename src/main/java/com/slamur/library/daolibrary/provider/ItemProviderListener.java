package com.slamur.library.daolibrary.provider;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.event.Listener;
import com.slamur.library.daolibrary.provider.event.ItemLoadEvent;
import com.slamur.library.daolibrary.provider.event.ItemParameterLoadEvent;
import com.slamur.library.daolibrary.provider.event.ItemsLoadEvent;

public interface ItemProviderListener<
        ItemType extends Item,
        ItemProviderType extends ItemProvider<ItemType, ItemProviderType>
        >
        extends Listener<ItemType, ItemProviderListener<ItemType, ItemProviderType>, ItemProviderType> {

    void onItemLoaded(ItemLoadEvent<ItemType> loadItemEvent);
    void onItemsLoaded(ItemsLoadEvent<ItemType> loadItemsEvent);
    <ParameterType> void onItemParameterLoaded(ItemParameterLoadEvent<ItemType, ParameterType> loadItemParameterEvent);
}
