package com.edu.data_structures.A2_arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> integerList =
                new ArrayList<>(Arrays.asList(12, 18, 7, 4, 12, 18, 7, 19, 3, 4, 5, 19, 7, 402, 3, 402, 5));
        Collections.sort(integerList); // По условию задачи список должен быть отсортирован
        System.out.println(integerList);
        removeDuplicates(integerList);
        System.out.println(integerList);
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {

        int wrightIndex = 1;
        for (int readIndex = 1; readIndex < list.size() - 1; readIndex++) {
            if (!list.get(readIndex).equals(list.get(wrightIndex - 1))) {
                list.set(wrightIndex, list.get(readIndex));
                wrightIndex++;
            }
        }

        while (list.size() > wrightIndex) {
            list.remove(list.size() - 1);
        }

        return list;
    }
}

/*
2. Удаление дубликатов из отсортированного списка (in-place)
Задача: Удалить дубликаты из отсортированного списка, оставив только уникальные элементы.

Объяснение:
- Используем технику "двух указателей"
- readIndex читает элементы, writeIndex записывает уникальные
- Так как список отсортирован, дубликаты идут подряд
- Сложность: O(n) по времени, O(1) по памяти
*/
