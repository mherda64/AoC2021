package day2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static day2.Day2Const.input;

public class Day2 {

    public static void main(String[] args) {
        ex1();
    }

    private static void ex1() {
        AtomicInteger aim = new AtomicInteger();
        AtomicInteger depth = new AtomicInteger();
        AtomicInteger horizontal = new AtomicInteger();

        Arrays.stream(input).forEach(pair -> {
            String[] s = pair.split(" ");
            int val = Integer.parseInt(s[1]);
            switch (s[0]) {
                case "forward":
                    horizontal.addAndGet(val);
                    depth.addAndGet(aim.get() * val);
                    break;
                case "down":
                    aim.addAndGet(val);
                    break;
                case "up":
                    aim.addAndGet(-val);
                    break;
            }
        });

        System.out.println(depth.get() * horizontal.get());
    }

}
