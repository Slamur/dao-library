package com.slamur.library.daolibrary.function;

import com.slamur.library.daolibrary.Item;

public interface ItemPredicate<ItemType extends Item> {

    boolean check(ItemType item);
}
