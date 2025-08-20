package com.edu.data_structures.A4_arrayList;

import java.util.*;

public class FindIntersection {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 14, 20, 56, 20, 25, 14, 56, 20));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(14, 20, 56, 4, 14));
//        List<Integer> list1 = new ArrayList<>(); // Тестируем пустой список
//        List<Integer> list2 = new ArrayList<>(); // Тестируем пустой список
        System.out.println(list1);
        System.out.println(list2);

//        List<Integer> resultList = interSectionNoDuplicates(list1, list2);
//        System.out.println(resultList);
        List<Integer>  resultList2 = interSectionWithDuplicates(list1, list2);
        System.out.println(resultList2);
    }

    private static List<Integer> interSectionNoDuplicates(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> resultSet = new HashSet<>();

        for(Integer num : list2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        return new ArrayList<>(resultSet);
    }

    private static List<Integer> interSectionWithDuplicates(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (Integer num : list1){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Integer num : list2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                resultList.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        return resultList;
    }
}

/*
4. Поиск пересечения двух списков

Вариант А: Без повторений (уникальные элементы)
Задача: Найти общие уникальные элементы двух списков.
Объяснение:
Используем HashSet для быстрого поиска (O(1))
Проходим по второму списку и проверяем наличие в множестве
Сложность: O(n + m), память: O(n)

Вариант Б: С повторениями (сохраняем частоту)
Задача: Найти все общие элементы с учетом кратности.
Объяснение:
Используем HashMap для учета частоты элементов
Уменьшаем счетчик при каждом найденном совпадении
Сложность: O(n + m), память: O(n)
*/
