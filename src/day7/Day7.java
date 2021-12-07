package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static day7.Day7Const.input;

public class Day7 {

    public static void main(String[] args) {
//        ex1();
        ex2();
    }

    private static void ex1() {
        var numbers = Stream.of(input).map(Integer::parseInt).toArray(Integer[]::new);
        var max = Stream.of(numbers).max(Integer::compare).get();

        var sums = new HashMap<Integer, Integer>();
        for (int i = 0; i <= max; i++) {
            int finalI = i;
            var sum = Arrays.stream(numbers).map(num -> Math.abs(num - finalI)).reduce(0, Integer::sum);
            sums.put(i, sum);
        }

        System.out.println(sums);

        var min = sums.keySet().stream().map(val -> sums.get(val)).min(Integer::compare).get();

        System.out.println(min);
    }

    private static void ex2() {
        var numbers = Stream.of(input).map(Integer::parseInt).toArray(Integer[]::new);
        var max = Stream.of(numbers).max(Integer::compare).get();

        var sums = new HashMap<Integer, Integer>();
        for (int i = 0; i <= max; i++) {
            int finalI = i;
            var sum = Arrays.stream(numbers).map(num -> getFuelConsumption(Math.abs(num - finalI))).reduce(0, Integer::sum);
            sums.put(i, sum);
        }

        System.out.println(sums);

        var min = sums.keySet().stream().map(val -> sums.get(val)).min(Integer::compare).get();

        System.out.println(min);
    }

    private static int getFuelConsumption(int distance) {
        return IntStream.range(0, distance + 1).reduce(Integer::sum).getAsInt();
    }

}
