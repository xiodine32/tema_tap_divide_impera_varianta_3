package com.xiodine.tap.di.varianta3.helpers;

/**
 * File created at: 11/21/15 - 12:00 PM
 */
public interface OneStrategy<PickT, ReturnT> {

    /**
     * Prepares strategy to pick from the elements
     *
     * @param elements Elem
     */
    void setElements(PickT elements);

    /**
     * Selects an item with the implemented helpers.
     *
     * @return Element selected
     */
    ReturnT select();

    /**
     * @return True if can select another element
     */
    boolean canSelect();

}
