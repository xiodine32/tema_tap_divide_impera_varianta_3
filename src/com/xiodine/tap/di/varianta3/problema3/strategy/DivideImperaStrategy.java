package com.xiodine.tap.di.varianta3.problema3.strategy;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;
import com.xiodine.tap.di.varianta3.helpers.Point;
import com.xiodine.tap.di.varianta3.problema3.Segment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 25/11/15.
 */

/**
 * Strategia implementeaza merge sort, avand grija ca in momentul reconstruirii sa verifice daca adauga din list dreapta.
 * Daca da, cauta binar in lista stanga 2 * numarDreapta si adauga ca inversiuni dim(listaStanga) - indiceGasit + 1
 */
public class DivideImperaStrategy implements OneStrategy<ArrayList<Point>, Segment> {

    public static final boolean showDebug = false;
    private Segment selectedSegment = null;

    @Override
    public String toString() {
        return "Divide et Impera Strategy";
    }


    @Override
    public void setElements(ArrayList<Point> elements) {
        elements.sort((a, b) -> a.getX() - b.getX());
        selectedSegment = dei(elements);
    }

    private Segment dei(List<Point> elements) {

        // simple cases
        if (elements.size() == 1)
            return Segment.NONE;

        if (elements.size() == 2)
            return new Segment(elements.get(0), elements.get(1));

        if (elements.size() == 3) {
            return Segment.min(
                    Segment.min(
                            new Segment(elements.get(0), elements.get(1)),
                            new Segment(elements.get(1), elements.get(2))
                    ),
                    new Segment(elements.get(0), elements.get(2))
            );
        }

        // complex cases, need divide et impera

        int middle = (elements.size() - 1) / 2;
        Point middlePoint = elements.get(middle);


        // divide

        List<Point> leftList = elements.subList(0, middle);
        List<Point> rightList = elements.subList(middle, elements.size());

        Segment segLeft = dei(leftList);
        Segment segRight = dei(rightList);

        // conquer

        System.out.println(leftList + "  =>  " + segLeft);
        System.out.println(rightList + "  =>  " + segRight);

        return Segment.min(segLeft, segRight);
    }

    @Override
    public Segment select() {
        return selectedSegment;
    }

    @Override
    public boolean canSelect() {
        return true;
    }
}
