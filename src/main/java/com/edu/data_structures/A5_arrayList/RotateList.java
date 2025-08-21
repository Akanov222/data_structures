package com.edu.data_structures.A5_arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>(Arrays.asList(1, 5, 10, 15, 20, 25, 30, 35, 40));
//        List<Integer> originalList = new ArrayList<>(Arrays.asList(1, 5, 10));
//        int k = 4;
        int k = 3;
        List<Integer> rotateList = new ArrayList<>(originalList);
        rotateList = rotateList(rotateList, k);
        System.out.println("Original list: " + originalList);
        System.out.println("Rotate list: " + rotateList);
    }

    private static List<Integer> rotateList(List<Integer> list, int k) {
        if (list.isEmpty() || k == 0) {
            return new ArrayList<>(list);
        }

        List<Integer> resultList = new ArrayList<>(list);
        int n = resultList.size();
        k = k % n;
        if (k < 0) {
            k += n;
        }

        reverse(resultList, 0, n - 1);
        reverse(resultList, 0, k - 1);
        reverse(resultList, k, n - 1);
        return resultList;
    }

    private static void reverse(List<Integer> resultList, int start, int end) {
        while (start < end) {
            int tmp = resultList.get(start);
            resultList.set(start, resultList.get(end));
            resultList.set(end, tmp);
            start++;
            end--;
        }
    }
}

/*
5. Циклический сдвиг на k позиций
Задача: Сдвинуть элементы списка на k позиций вправо.

Объяснение:
Первый способ: Используем трюк с тремя разворотами (O(1) память)
Обрабатываем edge cases: k > размера списка, отрицательный k
Сложность: O(n) по времени

💡 Важные моменты:
Для пересечения: Всегда уточняй - с повторениями или без?
Для сдвига: Уточни направление (вправо/влево) и нужно ли делать in-place
Тестируй крайние случаи: k = 0, k = n, k > n, пустые списки
*/
