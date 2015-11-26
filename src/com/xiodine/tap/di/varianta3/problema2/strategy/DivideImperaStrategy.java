package com.xiodine.tap.di.varianta3.problema2.strategy;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;
import com.xiodine.tap.di.varianta3.problema2.Point;

import java.util.ArrayList;

/**
 * Created on 25/11/15.
 */
public class DivideImperaStrategy implements OneStrategy<ArrayList<Point>, Integer> {

    private int maxSize;
    private ArrayList<Integer> output = new ArrayList<>();

    public DivideImperaStrategy(int n) {
        this.maxSize = powsmart(n, 2);
    }

    private int powsmart(int n, int start) {
        if (n == 1)
            return start;

        int half = powsmart(n / 2, start);

        if (n % 2 == 0)
            return half * half;
        return half * half * 2;
    }

    @Override
    public void setElements(ArrayList<Point> elements) {
        elements.forEach(element -> output.add(solve(element)));
    }

    private int solve(Point point) {
        ArrayList<Integer> cadrane = toCadrane(point, new Point(1, 1), new Point(this.maxSize, this.maxSize));
        int putere = 1;
        int numar = 0;
        if (cadrane == null)
            return -1;
        for (int item : cadrane) {
            numar += putere * item;
            putere *= 4;
        }

        return numar + 1;
    }

    private ArrayList<Integer> toCadrane(Point point, Point st, Point en) {
        Point tst = new Point(0, 0);
        Point ten = new Point(en.getX() - st.getX(), en.getY() - st.getY());
        Point tp = new Point(point.getX() - st.getX(), point.getY() - st.getY());

        if (tp.getX() == 0 && tp.getY() == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
//            System.out.println("target: " + tp + " cu " + tst + " - " + ten + " => 0");
            return result;
        }
        if (tp.getX() == 1 && tp.getY() == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(1);
//            System.out.println("target: " + tp + " cu " + tst + " - " + ten + " => 1");
            return result;
        }
        if (tp.getX() == 0 && tp.getY() == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(2);
//            System.out.println("target: " + tp + " cu " + tst + " - " + ten + " => 2");
            return result;
        }
        if (tp.getX() == 1 && tp.getY() == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(3);
//            System.out.println("target: " + tp + " cu " + tst + " - " + ten + " => 3");
            return result;
        }

        // always divisible
        Point center = new Point((tst.getX() + ten.getX()) / 2, (tst.getY() + ten.getY()) / 2);




        int cadran;

        if (tp.getX() <= center.getX() && tp.getY() <= center.getY())
            cadran = 0;
        else if (tp.getX() > center.getX() && tp.getY() <= center.getY())
            cadran = 1;
        else if (tp.getX() <= center.getX() && tp.getY() > center.getY())
            cadran = 2;
        else
            cadran = 3;

//        System.out.println("target: " + tp + " cu " + tst + " - " + center + " - " + ten + " => " + cadran);

        ArrayList<Integer> interior = null;
        switch (cadran) {
            case 0:
                interior = toCadrane(tp, tst, center);
                break;
            case 1:
                interior = toCadrane(tp, new Point(center.getX() + 1, tst.getY()), ten);
                break;
            case 2:
                interior = toCadrane(tp, new Point(tst.getX(), center.getY() + 1), new Point(center.getX(), ten.getY()));
                break;
            case 3:
                interior = toCadrane(tp, new Point(center.getX() + 1, center.getY() + 1), ten);
                break;
        }
        if (interior == null)
            return null;
        interior.add(cadran);
        return interior;
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
