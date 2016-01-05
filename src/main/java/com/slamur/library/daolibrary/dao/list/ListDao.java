package com.slamur.library.daolibrary.dao.list;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.dao.Dao;
import com.slamur.library.daolibrary.dao.DaoEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class ListDao <
        ItemType extends Item,
        ListDaoType extends ListDao<ItemType, ListDaoType>
        >
    extends Dao<
            ItemType,
            ListDaoListener<ItemType, ListDaoType>,
            ListEvent<ItemType>,
            List<ItemType>,
            ListDaoType
            > {

    protected ListDao() {
        super(new ArrayList<ItemType>());
    }

    @Override
    public List<ItemType> getItems() {
        return items;
    }

    public ItemType getItem(int index) {
        return items.get(index);
    }

    @Override
    public void addItem(ItemType item) {
        items.add(item);

        notifyListeners(new ListEvent<>(item, items.size() - 1), DaoEvent.Action.ADD);
    }

    public void insertItem(int index, ItemType item) {
        if (0 <= index && items.size() > index) {
            items.add(index, item);

            notifyListeners(new ListEvent<>(item, index), DaoEvent.Action.ADD);
        } else if (items.size() == index) {
            addItem(item);
        }
    }

    protected void updateItems(List<ItemType> updatedItems) {
        for (int index = 0, size = Math.min(items.size(), updatedItems.size()); index < size; ++index) {
            updateItem(index, updatedItems.get(index));
        }

        for (int index = items.size() - 1; index >= updatedItems.size(); --index) {
            removeItem(index);
        }

        for (int index = items.size(); index < updatedItems.size(); ++index) {
            addItem(updatedItems.get(index));
        }
    }

    public void updateItem(int index, ItemType item) {
        if (0 <= index && items.size() > index) {
            items.set(index, item);

            notifyListeners(new ListEvent<>(item, index), DaoEvent.Action.UPDATE);
        } else if (items.size() == index) {
            addItem(item);
        }
    }

    @Override
    public void removeItem(ItemType item) {
        removeItem(items.indexOf(item));
    }

    public void removeItem(int index) {
        if (0 <= index && items.size() > index) {
            ListEvent<ItemType> removeItemEvent = new ListEvent<>(items.get(index), index);

            items.remove(index);

            notifyListeners(removeItemEvent, DaoEvent.Action.REMOVE);
        }
    }
}
