package com.xiodine.tap.di.varianta3.problema1.strategy;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;

import java.util.ArrayList;

/**
 * Created on 25/11/15.
 */
public class DivideImperaStrategy implements OneStrategy<ArrayList<Integer>, Integer> {

    private Integer selectedItem;
    private Integer selectedIndex;

    @Override
    public void setElements(ArrayList<Integer> elements) {
        dei(elements, 0, elements.size() - 1);
    }

    private void dei(ArrayList<Integer> elements, int st, int dr) {
        int m = (st + dr) / 2;
        int e1 = elements.get(m - 1);
        int e2 = elements.get(m);
        int e3 = elements.get(m + 1);
        if (e1 < e2 && e2 > e3) {
            selectedIndex = m;
            selectedItem = e2;
            return;
        }
        if (e1 < e2 && e2 < e3) {
            dei(elements, m, dr);
        } else if (e1 > e2 && e2 > e3) {
            dei(elements, st, m);
        }
    }

    @Override
    public Integer select() {
        if (selectedItem != null) {
            Integer newSelected = selectedItem;
            selectedItem = null;
            return newSelected;
        }

        Integer newSelected = selectedIndex;
        selectedIndex = null;
        return newSelected;
    }

    @Override
    public boolean canSelect() {
        return false;
    }

    @Override
    public String toString() {
        return "Divide et Impera Strategy";
    }
}
