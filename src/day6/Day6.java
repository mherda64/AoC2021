package day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import static day6.Day6Const.numbers;

public class Day6 {

    public static void main(String[] args) {
//        ex1();
        var start = System.nanoTime();
        ex2();
        var stop = System.nanoTime();

        System.out.println(stop - start);
    }

    private static void ex1() {
        var fishArray = numbers;
        System.out.println(fishArray.size());
        var days = 80;

        for (int i = 0; i < days; i++) {
            //decrease fish counter, update counter and add new fish
            var size = fishArray.size();
            for (int j = 0; j < size; j++) {
                var fishVal = fishArray.get(j);
                if (fishVal - 1 < 0) {
                    fishArray.set(j, 6);
                    fishArray.add(8);
                } else {
                    fishArray.set(j, fishVal - 1);
                }
            }
            System.out.println("After day " + (i + 1) + " count:" + fishArray.size());
        }

        System.out.println(fishArray.size());
    }

    private static void ex2() {
        var fishArray = numbers;
        var fishMap = new HashMap<Integer, Long>();
        var fishList = new LinkedList<Long>();
        var days = 256;

        for (int i = 0; i < 9; i++) {
            fishMap.put(i, 0L);
        }

        for (var fish : fishArray) {
            fishMap.put(fish, fishMap.get(fish) + 1);
        }

        for (int i = 0; i < 9; i++) {
            fishList.add(fishMap.get(i));
        }

        System.out.println(fishList);

        for (int i = 0; i < days; i++) {
            var toMultiply = fishList.removeFirst();
            fishList.addLast(toMultiply);
            fishList.set(6, fishList.get(6) + toMultiply);

//            System.out.println("day " + (i + 1) + " " + fishList);
        }

        long output = 0;
        for (int i = 0; i < 9; i++) {
            output += fishList.get(i);
        }

        System.out.println(output);
    }

}
