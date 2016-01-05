package com.slamur.library.daolibrary.event;

import com.slamur.library.daolibrary.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Notifier <
                ItemType extends Item,
                ListenerType extends Listener <ItemType, ListenerType, NotifierType>,
                NotifierType extends Notifier <ItemType, ListenerType, NotifierType>
                > {

    protected List<ListenerType> listeners;

    protected Notifier() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(ListenerType listener) {
        listeners.add(listener);
        listener.setNotifier((NotifierType) this);
    }

    public void removeListener(ListenerType listener) {
        listeners.remove(listener);
        listener.setNotifier(null);
    }
}
