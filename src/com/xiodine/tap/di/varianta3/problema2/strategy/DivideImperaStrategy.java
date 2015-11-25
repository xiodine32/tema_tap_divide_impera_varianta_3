package com.xiodine.tap.di.varianta3.problema2.strategy;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;

import java.util.ArrayList;

/**
 * Created on 25/11/15.
 */
public class DivideImperaStrategy implements OneStrategy<ArrayList<Integer>, Integer> {

    private ArrayList<Integer> output = new ArrayList<>();

    @Override
    public void setElements(ArrayList<Integer> elements) {

    }


    @Override
    public Integer select() {
        Integer out = output.get(0);
        output.remove(0);
        return out;
    }

    @Override
    public boolean canSelect() {
        return !output.isEmpty();
    }

    @Override
    public String toString() {
        return "Divide et Impera Strategy";
    }
}
