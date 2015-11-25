package com.xiodine.tap.di.varianta3.helpers;

import java.util.List;

/**
 * File created at: 11/21/15 - 12:00 PM
 */
public interface TwoStrategy<ListT, PickT extends List<ListT>, ReturnT> {


    /**
     * Selects an item with the implemented helpers.
     *
     * @param oldElements     Elements list
     * @param competitionPick The element the competitor picked.
     * @return Element selected
     */
    ReturnT select(PickT oldElements, ReturnT competitionPick);

    /**
     * @param elements Elements list
     * @return True if can select another element
     */
    boolean canSelect(PickT elements);

}
