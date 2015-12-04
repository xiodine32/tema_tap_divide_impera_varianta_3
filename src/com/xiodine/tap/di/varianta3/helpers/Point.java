package com.xiodine.tap.di.varianta3.helpers;

import java.util.function.Function;

/**
 * Created on 25/11/15.
 */
public class Point {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double distanceSquared(Point a, Point b) {
        return (double) (a.getX() - b.getX()) * (a.getX() - b.getX()) +
                (double) (a.getY() - b.getY()) * (a.getY() - b.getY());
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt((double) (a.getX() - b.getX()) * (a.getX() - b.getX()) +
                (double) (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

    public static Point min(Function<Point, Integer> accessor, Point point1, Point point2) {
        if (accessor.apply(point1) > accessor.apply(point2))
            return point2;
        return point1;
    }

    public static int compareTo(Function<Point, Integer> accessor, Point point1, Point point2) {
        return accessor.apply(point1).compareTo(accessor.apply(point2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
