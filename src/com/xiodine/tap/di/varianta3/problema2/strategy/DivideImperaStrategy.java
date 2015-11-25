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
        this.maxSize = pow2smart(n);
    }

    private int pow2smart(int n) {
        if (n == 1)
            return 2;

        int half = pow2smart(n / 2);

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
        System.err.println(cadrane);
        return 0;
    }

    private ArrayList<Integer> toCadrane(Point point, Point st, Point en) {
        Point tst = new Point(0, 0);
        Point ten = new Point(en.getX() - st.getX(), en.getY() - st.getY());
        Point tp = new Point(point.getX() - st.getX(), point.getY() - st.getY());

        if (tp.getX() == 0 && tp.getY() == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        if (tp.getX() == 1 && tp.getY() == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(1);
            return result;
        }
        if (tp.getX() == 0 && tp.getY() == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(2);
            return result;
        }
        if (tp.getX() == 1 && tp.getY() == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(3);
            return result;
        }

        // always divisible
        Point center = new Point(ten.getX() / 2, ten.getY() / 2);

        int cadran;

        if (tp.getX() <= center.getX() && tp.getY() <= center.getY())
            cadran = 0;
        else if (tp.getX() > center.getX() && tp.getY() <= center.getY())
            cadran = 1;
        else if (tp.getX() <= center.getX() && tp.getY() > center.getY())
            cadran = 2;
        else
            cadran = 3;

        ArrayList<Integer> interior = null;
        // todo: THIS
        switch (cadran) {
            case 0:
                interior = toCadrane(tp, tst, ten);
                break;
            case 1:
                interior = toCadrane(tp, tst, ten);
                break;
            case 2:
                interior = toCadrane(tp, tst, ten);
                break;
            case 3:
                interior = toCadrane(tp, tst, ten);
                break;
        }
        if (interior == null)
            return null;
        interior.add(cadran);
        return interior;
    }

    private int dai(Point element) {
        if (element.getX() < 2 && element.getY() < 2) {
            int cadran = cadran(element.getX(), element.getY()) + 1;
            System.out.println("cadran: " + cadran);
            return cadran;
        }

        int x = element.getX() % 2;
        int y = element.getY() % 2;
        int cadran = cadran(x, y);
        System.out.println("cadran: " + cadran);
        return dai(new Point(element.getX() / 2, element.getY() / 2)) * 4 + cadran;
    }

    private int cadran(int x, int y) {
        if (x == 0 && y == 0)
            return 0;
        if (x == 1 && y == 0)
            return 1;
        if (x == 0 && y == 1)
            return 2;
        return 3;
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
