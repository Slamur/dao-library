package com.slamur.library.daolibrary.provider.event;

import com.slamur.library.daolibrary.Item;
import com.slamur.library.daolibrary.provider.ItemProviderEvent;

public class ItemParameterLoadEvent<ItemType extends Item, ParameterType>
        extends ItemProviderEvent<ItemType, ParameterType> {

    protected final String parameterName;

    public ItemParameterLoadEvent(ParameterType parameter, String parameterName) {
        super(parameter);
        this.parameterName = parameterName;
    }

    public ParameterType getParameter() {
        return eventObject;
    }

    public String getParameterName() {
        return parameterName;
    }
}
