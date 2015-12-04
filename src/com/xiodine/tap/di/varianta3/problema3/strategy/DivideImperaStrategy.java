package com.xiodine.tap.di.varianta3.problema3.strategy;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;
import com.xiodine.tap.di.varianta3.helpers.Point;
import com.xiodine.tap.di.varianta3.problema3.Segment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        elements.sort((a, b) -> Point.compareTo(Point::getX, a, b));
        selectedSegment = dei(elements);
    }

    private Segment dei(List<Point> elements) {

        // simple cases
        if (elements.size() < 2)
            return Segment.NONE;

        // complex cases, need divide et impera

        int middle = (elements.size()) / 2;
        double middlePointX = elements.get(middle).getX();


        // divide

        List<Point> leftList = new ArrayList<>(elements.subList(0, middle));
        List<Point> rightList = new ArrayList<>(elements.subList(middle, elements.size()));

        Segment segLeft = dei(leftList);
        Segment segRight = dei(rightList);
        Segment seg = Segment.min(segLeft, segRight);


        // conquer

        System.out.println("me  : " + elements + " => " + seg);
        System.out.println("left: " + leftList + "  =>  " + segLeft);
        System.out.println("righ: " + rightList + "  =>  " + segRight);


        ArrayList<Point> reconstruct = new ArrayList<>();

        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            final Point min = Point.min(Point::getY, leftList.get(0), rightList.get(0));
            reconstruct.add(min);
            if (min == leftList.get(0)) {
                leftList.remove(0);
            } else {
                rightList.remove(0);
            }
        }

        if (leftList.isEmpty())
            reconstruct.addAll(rightList.stream().collect(Collectors.toList()));
        else
            reconstruct.addAll(leftList.stream().collect(Collectors.toList()));

        System.out.println("reco: " + reconstruct);


        for (int i = 0; i < reconstruct.size(); i++) {
            elements.set(i, reconstruct.get(i));
        }

        reconstruct.clear();


        ArrayList<Point> validPoints = new ArrayList<>();

        for (Point elem : elements) {
            if (Math.abs(elem.getX() - middlePointX) <= seg.getDistanceSquared()) {
                validPoints.add(elem);
            }
        }

        System.out.println("vald: " + validPoints);

        for (int i = 0; i < validPoints.size(); i++)
            for (int j = i + 1; j - i < 8 && j < validPoints.size(); j++)
                seg = Segment.min(seg, new Segment(validPoints.get(i), validPoints.get(j)));

        System.out.println("me:D: " + elements + " => " + seg);
        System.out.println();
        // (66, 77), (71, 95)
        return seg;
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
