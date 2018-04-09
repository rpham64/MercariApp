package com.mercari.mercaritest.base;

import com.mercari.mercaritest.data.model.Item;

import java.util.List;

/**
 * A base interface or contract for MainFragment. Contains methods for processing View class events.
 */
public interface BaseView {
    void showItems(List<Item> data);
}
