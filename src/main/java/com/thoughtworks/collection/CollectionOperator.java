package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List result = new LinkedList();
        int bigNumber = Math.max(left, right);
        int smallNumber = Math.min(left, right);
        for (int i = smallNumber; i <= bigNumber; i++) {
            result.add(smallNumber++);
        }
        if (left > right) {
            Collections.reverse(result);
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List result = new LinkedList();
        int bigNumber = Math.max(left, right);
        int smallNumber = Math.min(left, right);
        for (int i = smallNumber; i <= bigNumber; i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        if (left > right) {
            Collections.reverse(result);
        }
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(item -> item % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();//直接Arrays.asList(firstArray).retainAll 类型无法转换

        firstList.addAll(Arrays.asList(firstArray));
        secondList.addAll(Arrays.asList(secondArray));

        firstList.retainAll(secondList);
        return firstList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List result = new ArrayList();
        result.addAll(Arrays.asList(firstArray));  //直接Arrays.asList(firstArray)后添加notContain无法转换,由于aslist后的list长度不可变
        List notContain = Arrays.stream(secondArray)
                .filter(item -> !(Arrays.asList(firstArray).contains(item)))
                .collect(Collectors.toList());
        result.addAll(notContain);
        return result;
    }
}
