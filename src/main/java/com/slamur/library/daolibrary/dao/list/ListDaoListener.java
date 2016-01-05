package com.slamur.library.daolibrary.dao.list;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.dao.DaoListener;

import java.util.List;

public interface ListDaoListener<
        ItemType extends Item,
        ListDaoType extends ListDao<ItemType, ListDaoType>
        >
    extends DaoListener<
            ItemType,
            ListDaoListener<ItemType, ListDaoType>,
            ListEvent<ItemType>,
            ListDaoType,
            List<ItemType>
            > {

}
