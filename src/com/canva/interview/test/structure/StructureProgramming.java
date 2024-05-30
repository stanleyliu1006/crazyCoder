package com.canva.interview.test.structure;

import java.util.*;
import java.util.stream.Collectors;

public class StructureProgramming {

    public static void main(String[] args) {
        testListStream();
        testMapStream();
        testSetStream();
    }

    private static void testListStream() {
        List<String> testList = new LinkedList<>();
        testList.add("123");
        testList.add("456");
        List testNewList = testList.stream().map(test->test+" new").collect(Collectors.toList());
        System.out.println("newList"+testNewList.toString());
    }

    private static void testMapStream() {
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(1, "abc");
        testMap.put(2, "cdf");
        Map newMap = testMap.entrySet().stream().filter(entry->entry.getKey() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("newMap"+newMap.toString());
    }

    private static void testSetStream() {
        Set<People> testSet = new LinkedHashSet<>();
        testSet.add(new People("test1", 7));
        testSet.add(new People("test2", 9));
        testSet.add(new People("test3", 3));
        Set<People> newSet = testSet.stream()
                .sorted(Comparator.comparingInt(People::getAge).reversed())
                .collect(Collectors.toCollection(LinkedHashSet :: new));
        for(People test : newSet){
            System.out.println("newSet"+test.getAge());
        }
    }
}
