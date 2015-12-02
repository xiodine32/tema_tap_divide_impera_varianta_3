package com.xiodine.tap.di.varianta3.problema3.strategy;

import com.xiodine.tap.di.varianta3.helpers.OneStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 25/11/15.
 */

/**
 * Strategia implementeaza merge sort, avand grija ca in momentul reconstruirii sa verifice daca adauga din list dreapta.
 * Daca da, cauta binar in lista stanga 2 * numarDreapta si adauga ca inversiuni dim(listaStanga) - indiceGasit + 1
 */
public class DivideImperaStrategy implements OneStrategy<ArrayList<Integer>, Integer> {

    public static final boolean showDebug = false;

    private int inversiuni = 0;

    private List<Integer> merge(List<Integer> left, List<Integer> right) {

        List<Integer> generatedList = new ArrayList<>();

        List<Integer> sortedLeft = smartMergeSort(new ArrayList<>(left));
        List<Integer> sortedRight = smartMergeSort(new ArrayList<>(right));

        while (!sortedLeft.isEmpty() && !sortedRight.isEmpty()) {
            if (showDebug)
                System.out.println(" * left: " + sortedLeft + " right: " + sortedRight);
            boolean selectingRight = false;
            int selectedRightElement = sortedRight.get(0);
            Integer selectedLeftElement = sortedLeft.get(0);
            if (selectedRightElement < selectedLeftElement)
                selectingRight = true;

            if (selectingRight) {
                int startIndex = binarySearchLeft(selectedRightElement * 2, sortedLeft);
                int result = sortedLeft.size() - startIndex;
                inversiuni += result;
            }

            if (selectingRight) {
                generatedList.add(selectedRightElement);
                sortedRight.remove(0);
            } else {
                generatedList.add(selectedLeftElement);
                sortedLeft.remove(0);
            }
        }
        generatedList.addAll(sortedLeft.stream().collect(Collectors.toList()));
        generatedList.addAll(sortedRight.stream().collect(Collectors.toList()));
        return generatedList;
    }

    private int biggestPow2(int size) {
        if (size <= 1)
            return size;
        int max = 1;
        while (max * 2 < size)
            max *= 2;
        return max;
    }

    private int binarySearchLeft(int element, List<Integer> list) {
        int maxN = biggestPow2(list.size());
        int number = 0;
        while (maxN >= 1) {
            if (list.get(number + maxN - 1) < element)
                number += maxN;
            maxN /= 2;
        }
        return number;
    }

    private List<Integer> smartMergeSort(List<Integer> elements) {
        if (elements.size() <= 1)
            return elements;

        int middle = elements.size() / 2;

        List<Integer> left = elements.subList(0, middle);
        List<Integer> right = elements.subList(middle, elements.size());
        if (showDebug)
            System.out.println("smartMergeSort " + left + " " + right + " => ");
        List<Integer> merge = merge(left, right);
        if (showDebug)
            System.out.println("smartMergeSort " + left + " " + right + " => " + merge);
        return merge;
    }

    @Override
    public String toString() {
        return "Divide et Impera Strategy";
    }

    @Override
    public void setElements(ArrayList<Integer> elements) {
        smartMergeSort(elements);
    }

    @Override
    public Integer select() {
        return inversiuni;
    }

    @Override
    public boolean canSelect() {
        return true;
    }
}
