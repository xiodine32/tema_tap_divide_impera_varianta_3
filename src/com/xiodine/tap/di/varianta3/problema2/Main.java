package com.xiodine.tap.di.varianta3.problema2;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;
import com.xiodine.tap.di.varianta3.problema2.strategy.DivideImperaStrategy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 25/11/15.
 */
@SuppressWarnings("unused")
public class Main {
    public Main() {
        Scanner in = new Scanner(System.in);

        ArrayList<Point> vector = new ArrayList<>();
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 0; i < n; i++)
            vector.add(new Point(in.nextInt(), in.nextInt()));

        OneStrategy<ArrayList<Point>, Integer> strategy = new DivideImperaStrategy(n);

        strategy.setElements(vector);

        while (strategy.canSelect())
            System.out.println(strategy + ": " + strategy.select());
    }
}
