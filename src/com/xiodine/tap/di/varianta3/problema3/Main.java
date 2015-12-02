package com.xiodine.tap.di.varianta3.problema3;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;
import com.xiodine.tap.di.varianta3.problema3.strategy.DivideImperaStrategy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 Se consideră un vector cu n elemente.
 Se numeşte inversiune semnificativă a vectorului o pereche perechi (i, j) cu proprietatea că i < j şi ai > 2*aj.
 Să de determine numărul de inversiuni semnificative din vector.
 De exemplu, vectorul 4, 8, 11, 3, 5 are 3 inversiuni semnificative: (8,3), (11,3), (11,5) - O(n log n) exc. 2, cap. 5 (3p)
 */
@SuppressWarnings("unused")
public class Main {
    public Main() {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> vector = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            vector.add(in.nextInt());

        OneStrategy<ArrayList<Integer>, Integer> strategy = new DivideImperaStrategy();

        strategy.setElements(vector);

        int index = 0;
        System.out.println(vector + " with " + strategy + " returns " + strategy.select());
    }
}
