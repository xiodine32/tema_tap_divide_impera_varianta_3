package com.xiodine.tap.di.varianta3;

import com.xiodine.tap.di.varianta3.helpers.Menu;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Main {

    public static final String[] OPTIONS = new String[]{
            "Problem 1",
            "Problem 2",
            "Problem 3",
            "exit"};
    private static boolean inTesting = false;
    private static int testingNumber = 2;

    public static void main(String[] args) {
        boolean result = true;
        while (result) {
            try {
                result = (new Main()).run();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (inTesting) {
                result = false;
            }
        }
        System.out.println("Goodbye!");
    }

    private boolean run() throws Exception {
        int problema = getProblema(OPTIONS);

        if (problema == OPTIONS.length)
            return false;

        // construct class
        Class<?> selectedClass = getClass(problema);
        Constructor constructor = getConstructor(selectedClass);

        // save old redirects
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        // start loading redirects
        InputStream in = getInputStream(problema);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        redirectInputOutput(in, new PrintStream(out));

        NanoTimer timer = new NanoTimer(constructor);

        // run once for output
        runTest(out, timer);
        String result = getResult(out);

        writeOutput(timer, result, oldOut);

        // restore redirects
        redirectInputOutput(oldIn, oldOut);


        return true;
    }

    private void redirectInputOutput(InputStream in, PrintStream out2) {
        System.setOut(out2);
        System.setIn(in);
    }

    private String getResult(ByteArrayOutputStream out) throws UnsupportedEncodingException {
        return out.toString("UTF-8");
    }

    private int getProblema(String[] options) {
        // create problem picker
        Menu menuHelper = Menu.factory("Pick exercise number", options);

        // pick problem
        int problema;

        if (!inTesting) {
            menuHelper.run(System.out, new Scanner(System.in));

            // get answer
            problema = menuHelper.getAnswer();
        } else {
            problema = testingNumber;
        }
        return problema;
    }

    private void writeOutput(NanoTimer timer, String result, PrintStream printStream) {
        result = result.trim();
        printStream.println("Result:\n\n . " + result.replace("\n", "\n . ") + "\n");
        printStream.printf("Time elapsed: %.8fs\n", timer.getTimerDuration() / 1000000000.0);
        printStream.println();
    }

    private void runTest(ByteArrayOutputStream out, NanoTimer timer) throws Exception {
        timer.runTest();
    }

    private PrintStream getNothingPrintStream() {
        return new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });
    }

    private InputStream getInputStream(int problema) throws FileNotFoundException {
        String location = "src/com/xiodine/tap/di/varianta3/problema" + problema + "/input.in";
        return new FileInputStream(location);
    }

    private Constructor getConstructor(Class<?> selectedClass) throws NoSuchMethodException {
        return selectedClass.getConstructor();
    }

    private Class<?> getClass(int problema) throws ClassNotFoundException {
        return Class.forName("com.xiodine.tap.di.varianta3.problema" + problema + ".Main");
    }
}
