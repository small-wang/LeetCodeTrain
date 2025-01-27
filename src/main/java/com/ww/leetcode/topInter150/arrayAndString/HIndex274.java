package com.ww.leetcode.topInter150.arrayAndString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @since 2024/12/13 14:02
 */
public class HIndex274 {

    public int hIndex(int[] citations) {
        int result = 0;

        Stream<Integer> citationStream = Arrays.stream(citations).boxed();
        List<Integer> citationsSorted = citationStream.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < citationsSorted.size(); i++) {
            if (citationsSorted.get(i) > i) {
                result = citationsSorted.get(i);
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] citations = {1, 3, 2, 6};
//        Arrays.stream(citations).forEach(x -> System.out.println(x));
//        System.out.println("**************");
////        Arrays.stream(citations).sorted(Comparator.reverseOrder()).forEach(x -> System.out.println(x));
//        Arrays.stream(citations).sorted().forEach(x -> System.out.println(x));
//        System.out.println("**************");
//        Arrays.stream(citations).forEach(x -> System.out.println(x));

//        int[] citationsSorted = IntStream.of(citations).sorted().toArray();
//        IntStream.of(citationsSorted).forEach(x -> System.out.println(x));

        Stream<Integer> citationStream = Arrays.stream(citations).boxed();
        List<Integer> citationsSorted = citationStream.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
