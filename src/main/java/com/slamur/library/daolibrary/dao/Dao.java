package com.slamur.library.daolibrary.dao;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.event.Notifier;
import com.slamur.library.daolibrary.function.ItemPredicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Dao <
        ItemType extends Item,
        DaoListenerType extends DaoListener<ItemType, DaoListenerType, DaoEventType, DaoType, ItemCollection>,
        DaoEventType extends DaoEvent<ItemType>,
        ItemCollection extends Collection<ItemType>,
        DaoType extends Dao<ItemType, DaoListenerType, DaoEventType, ItemCollection, DaoType>
        >
        extends Notifier<ItemType, DaoListenerType, DaoType> {

    protected ItemCollection items;

    protected Dao(ItemCollection items) {
        this.items = items;
    }

    public abstract Class<ItemType> getItemClass();

    public abstract List<ItemType> getItems();

    public int getItemCount() {
        return items.size();
    }

    public List<ItemType> filterItems(ItemPredicate<ItemType> predicate) {
        List<ItemType> filtered = new ArrayList<>();
        for (ItemType item : items) {
            if (predicate.check(item)) {
                filtered.add(item);
            }
        }

        return filtered;
    }

    public ItemType filterItem(ItemPredicate<ItemType> predicate) {
        List<ItemType> filtered = filterItems(predicate);
        if (filtered.isEmpty()) {
            return null;
        } else {
            return filtered.get(0);
        }
    }

    public ItemType getItem(final long id) {
        return filterItem(new ItemPredicate<ItemType>() {
            @Override
            public boolean check(ItemType item) {
                return (item.getId() == id);
            }
        });
    }

    public abstract void addItem(ItemType item);

    public abstract void removeItem(ItemType item);

    public void notifyListeners(DaoEventType event, DaoEvent.Action eventAction) {
        for (DaoListenerType daoListener : listeners) {
            switch (eventAction) {
                case ADD: daoListener.onItemAdded(event); break;
                case UPDATE: daoListener.onItemUpdated(event); break;
                case REMOVE: daoListener.onItemRemoved(event); break;
            }
        }
    }
}
