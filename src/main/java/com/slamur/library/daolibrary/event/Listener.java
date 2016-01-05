package com.slamur.library.daolibrary.event;

import com.slamur.library.daolibrary.Item;

public interface Listener <
        ItemType extends Item,
        ListenerType extends Listener <ItemType, ListenerType, NotifierType>,
        NotifierType extends Notifier <ItemType, ListenerType, NotifierType>
        > {

    void setNotifier(NotifierType notifier);
}
