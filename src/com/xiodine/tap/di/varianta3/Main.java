package com.xiodine.tap.di.varianta3;

import com.xiodine.tap.di.varianta3.helpers.Menu;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean result = true;
        while (result) {
            result = (new Main()).run();
        }
        System.out.println("Goodbye!");
    }

    private boolean run() {
        // create problem picker
        Menu menuHelper = Menu.factory("Pick exercise number", new String[]{
                "Problem 1",
                "Problem 2",
                "Problem 3",
                "Problem 4",
                "Problem 5",
                "exit"});

        // pick problem
        menuHelper.run(System.out, new Scanner(System.in));

        // get answer
        int problema = menuHelper.getAnswer();

        if (problema == 5)
            return false;
        problema++;

        // construct class
        Class<?> selectedClass = null;
        try {
            selectedClass = Class.forName("com.xiodine.tap.di.varianta3.problema" + problema + ".Main");
        } catch (Exception e) {
            System.err.println("Error loading problem!");
        }
        if (selectedClass == null)
            return true;

        Constructor constructor = null;
        try {
            constructor = selectedClass.getConstructor();
        } catch (Exception e) {
            System.err.println("Error getting constructor for the problem!");
        }

        if (constructor == null)
            return true;


        // start loading redirects
        String location = "src/com/xiodine/tap/di/varianta3/problema" + problema + "/input.in";
        InputStream in;
        try {
            in = new FileInputStream(location);
        } catch (FileNotFoundException e) {
            System.err.println("Location not found: " + location);
            return true;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // save old redirects
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;


        // redirect
        System.setOut(new PrintStream(out));
        System.setIn(in);

        // prepare timer
        NanoTimer timer = new NanoTimer();
        timer.setLambda(constructor);

        // run test
        try {
            timer.runTest();
        } catch (Exception e) {
            System.err.println("Uh oh, program crashed!");
            e.printStackTrace();
        }

        // get output
        String result = null;
        try {
            result = out.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println("Result cannot be encoded to UTF-8.");
        }


        // restore redirects
        System.setOut(oldOut);
        System.setIn(oldIn);


        // write to output
        System.out.println("Result:\n\n" + result + "\n");
        System.out.printf("Time elapsed: %.5fs\n", timer.getTimerDuration() / 1000000000.0);
        System.out.println();
        return true;
    }
}
