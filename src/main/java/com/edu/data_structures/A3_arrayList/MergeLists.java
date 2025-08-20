package com.edu.data_structures.A3_arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeLists {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 14, 20, 56, 20, 25, 14, 56, 20));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(14, 20, 56, 4));
//        List<Integer> list1 = new ArrayList<>(); // Тестируем пустой список
//        List<Integer> list2 = new ArrayList<>(); // Тестируем пустой список
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1);
        System.out.println(list2);

        List<Integer> result = mergeSortedList(list1, list2);
        System.out.println(result);
    }

    private static List<Integer> mergeSortedList(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }

        return result;
    }
}

/*
Объяснение:
Используем технику слияния из MergeSort
Сравниваем текущие элементы из обоих списков
Добавляем меньший элемент в результат
Сложность: O(n + m) где n и m - размеры списков

💡 Советы для собеседования:
Всегда уточняйте условия: Отсортирован ли список? Можно ли менять исходный список?
Проверяйте edge cases: пустые списки, списки из одного элемента
Объясняйте сложность: временную и пространственную
Пишите чистый код: с правильными отступами и названиями переменных
*/