package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int startNumber = leftBorder;
        int endNumber = rightBorder;
        int result = 0;
        if (rightBorder < leftBorder) {
            startNumber = rightBorder;
            endNumber = leftBorder;
        }
        for (int i = startNumber; i <= endNumber; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int startNumber = leftBorder;
        int endNumber = rightBorder;
        int result = 0;
        if (rightBorder < leftBorder) {
            startNumber = rightBorder;
            endNumber = leftBorder;
        }
        for (int i = startNumber; i <= endNumber; i++) {
            if (i % 2 != 0) {
                result += i;
            }
        }
        return result;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce(0, (sum, item) -> sum + (item * 3 + 2));
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(item -> {
            if (item % 2 != 0) {
                return item * 3 + 2;
            }
            return item;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 != 0)
                .map(item -> item * 3 + 5)
                .reduce(0, (sum, item) -> sum + item);
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> resultList = new LinkedList<>(); //List不可以被实例化，抽象类
        for (int i = 1; i < arrayList.size(); i++) { //无法用map获取元素index
            resultList.add((arrayList.get(i - 1) + arrayList.get(i)) * 3);
        }
        return resultList;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List list = arrayList.stream()
                .filter(item -> item % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        int count = list.size();
        if (count % 2 == 0) {
            int right = (int) list.get(count / 2);
            int left = (int) list.get(count / 2 - 1);
            return (right + left) / 2;
        }
        return (double) list.get(count / 2);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        long count = arrayList.stream().filter(item -> item % 2 == 0).count();
        return arrayList.stream()
                .filter(item -> item % 2 == 0)
                .reduce(0, (sum, item) -> sum + item) / count;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList())
                .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List evenList = arrayList.stream().filter(item -> item % 2 == 0).sorted().collect(Collectors.toList());
        List oddList = arrayList.stream().filter(item -> item % 2 != 0).sorted().collect(Collectors.toList());
        Collections.reverse(oddList);
        evenList.addAll(oddList);
        return evenList;
    }


}
