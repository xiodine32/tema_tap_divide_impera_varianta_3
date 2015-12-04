package com.xiodine.tap.di.varianta3.problema3;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;
import com.xiodine.tap.di.varianta3.helpers.Point;
import com.xiodine.tap.di.varianta3.problema3.strategy.DivideImperaStrategy;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Dată o mulţime de puncte în plan (prin coordonatele lor), să de determine cea mai apropiată pereche
 * de puncte (se vor afişa distanţa şi punctele).
 */
@SuppressWarnings("unused")
public class Main {
    public Main() {
        Scanner in = new Scanner(System.in);

        ArrayList<Point> vector = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            vector.add(new Point(in.nextInt(), in.nextInt()));

        OneStrategy<ArrayList<Point>, Segment> strategy = new DivideImperaStrategy();

        strategy.setElements(vector);

        System.out.println(strategy + " returns " + strategy.select());
    }
}
