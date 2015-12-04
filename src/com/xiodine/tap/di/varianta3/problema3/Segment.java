package com.xiodine.tap.di.varianta3.problema3;

import com.xiodine.tap.di.varianta3.helpers.Point;

/**
 * Created on 04/12/15.
 */
public class Segment {
    public static Segment NONE = new Segment(
            new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
            new Point(Integer.MAX_VALUE, Integer.MAX_VALUE));

    private Point a;
    private Point b;
    private Double distance;
    private Double distanceSquared;

    public Segment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public static Segment min(Segment a, Segment b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        return a.getDistanceSquared() > b.getDistanceSquared() ? b : a;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public double getDistance() {
        if (this == NONE)
            return Double.POSITIVE_INFINITY;
        if (distance == null)
            distance = Point.distance(a, b);
        return distance;
    }

    public double getDistanceSquared() {
        if (this == NONE)
            return Double.POSITIVE_INFINITY;
        if (distanceSquared == null)
            distanceSquared = Point.distanceSquared(a, b);
        return distanceSquared;
    }

    @Override
    public String toString() {
        if (this == NONE)
            return "{NONE}";
        return "{" +
                "" + a +
                ", " + b +
                ", distance " + String.format("%.6f", getDistance()) +
                '}';
    }
}
