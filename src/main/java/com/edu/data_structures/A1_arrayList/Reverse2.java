package com.edu.data_structures.A1_arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse2 {
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>(Arrays.asList(1, 2, 4, 10, 8));
        System.out.println(newList);
        reversOneList(newList);
        System.out.println(newList);
    }

    private static void reversOneList(List<Integer> oneList) {
        int left = 0;
        int wright = oneList.size() - 1;

        while (left < wright) {
            int tmp = oneList.get(left);
            oneList.set(left, oneList.get(wright));
            oneList.set(wright, tmp);
            left++;
            wright--;
        }
    }
}
