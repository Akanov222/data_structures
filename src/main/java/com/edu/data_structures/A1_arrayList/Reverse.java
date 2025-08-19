package com.edu.data_structures.A1_arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 4, 8, 17, 2, 8, 14));
        System.out.println(integerList);
        reversList(integerList);
        System.out.println(integerList);
    }

    public static void reversList(List<Integer> list) {
        int left = 0;
        int wright = list.size() - 1;

        while (left < wright) {
            int temp = list.get(left);
            list.set(left, list.get(wright));
            list.set(wright, temp);

            left++;
            wright--;
        }
    }
}

/*
1. Разворот списка на месте (reverse)
Задача: Развернуть список без создания нового списка.

Объяснение:
Используем два указателя: один с начала, другой с конца
На каждой итерации меняем местами элементы
Сложность: O(n) по времени, O(1) по памяти
Работаем "на месте" - не создаем новый список
*/
