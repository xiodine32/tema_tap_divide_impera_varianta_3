package com.xiodine.tap.di.varianta3.problema1;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;
import com.xiodine.tap.di.varianta3.problema1.strategy.DivideImperaStrategy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 25/11/15.
 */
@SuppressWarnings("unused")
public class Main {

    ArrayList<Integer> vector;

    OneStrategy<ArrayList<Integer>, Integer> strategy;

    public Main() {
        Scanner in = new Scanner(System.in);
        vector = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            vector.add(in.nextInt());

        strategy = new DivideImperaStrategy();

        strategy.setElements(vector);

        System.out.println(strategy + " picks element: " + strategy.select() + " at position: " + strategy.select());
    }
}
