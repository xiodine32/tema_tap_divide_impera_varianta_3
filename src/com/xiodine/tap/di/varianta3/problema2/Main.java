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

        ArrayList<Integer> vector = new ArrayList<>();
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 0; i < n; i++)
            vector.add(in.nextInt());

        OneStrategy<ArrayList<Integer>, Integer> strategy = new DivideImperaStrategy();

        strategy.setElements(vector);
    }
}
