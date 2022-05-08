package sream_api;

import java.util.List;

/**
 * <B>Call terminal method reduce with BinaryOperator
 * This method return Optional Class</B>
* */

public class StreamReduce {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 5, 10, 18);

        /*
        * return sum of all elements
        * */
        int sum1 = list.stream().reduce((a, b ) -> a + b).orElseThrow();
        System.out.println(sum1);


        /*
        * the same result of sum but we use lambda Integer::sum
        * */
        int sum2 = list.stream().reduce(Integer::sum).orElseThrow();
        System.out.println(sum2);

        /*
         * return max number in a list
         * */
        int max = list.stream().reduce((a, b ) -> a > b ? a : b).orElseThrow();
        System.out.println(max);
    }
}
