package com.xiodine.tap.di.varianta3.helpers;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created on 20/11/15.
 */
public class Menu {
    private String name;
    private String[] names;
    private int lastSelect;

    public Menu(String name, String[] strings) {
        this.name = name;
        this.names = strings;
    }

    public static Menu factory(String name, String[] strings) {
        return new Menu(name, strings);
    }


    public boolean queryUser(Scanner scanner) {
        if (!scanner.hasNextInt())
            return false;

        lastSelect = scanner.nextInt();
        return true;
    }

    public void displayQuestion(PrintStream printer) {
        printer.print(name + ":\n");
        printer.flush();
        int vi = 1;
        for (String i : names) {
            printer.print("  " + (vi++) + ". " + i + "\n");
        }
        printer.print("\nSelect: ");
    }

    public int getAnswer() {
        return lastSelect;
    }

    public void run(PrintStream printer, Scanner scanner) {
        do {
            displayQuestion(printer);
        } while (!queryUser(scanner));
        printer.println();
    }
}
