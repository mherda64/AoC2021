package day5;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static day5.Day5Const.lines;

public class Day5 {

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    private static void ex1() {
        var pattern = Pattern.compile("(\\d*),(\\d*) -> (\\d*),(\\d*)");
        var pointPairs = new ArrayList<PointPair>();
        int max = 0;

        for (var line : lines) {
            var matcher = pattern.matcher(line);
            if (matcher.find()) {
                for (int i = 1; i < 5; i++) {
                    if (Integer.parseInt(matcher.group(i)) > max) {
                        max = Integer.parseInt(matcher.group(i));
                    }
                }

                pointPairs.add(new PointPair(
                        Integer.parseInt(matcher.group(1)),
                        Integer.parseInt(matcher.group(2)),
                        Integer.parseInt(matcher.group(3)),
                        Integer.parseInt(matcher.group(4))
                ));
            }
        }

        var map = new Map(max, max);


        for (var pair : pointPairs) {
            map.markHorizontalVertical(pair);
        }

        System.out.println(map.countOverlapping());
    }

    private static void ex2() {
        var pattern = Pattern.compile("(\\d*),(\\d*) -> (\\d*),(\\d*)");
        var pointPairs = new ArrayList<PointPair>();
        int max = 0;

        for (var line : lines) {
            var matcher = pattern.matcher(line);
            if (matcher.find()) {
                for (int i = 1; i < 5; i++) {
                    if (Integer.parseInt(matcher.group(i)) > max) {
                        max = Integer.parseInt(matcher.group(i));
                    }
                }

                pointPairs.add(new PointPair(
                        Integer.parseInt(matcher.group(1)),
                        Integer.parseInt(matcher.group(2)),
                        Integer.parseInt(matcher.group(3)),
                        Integer.parseInt(matcher.group(4))
                ));
            }
        }

        var map = new Map(max + 1, max + 1);


        for (var pair : pointPairs) {
            map.markAll(pair);
        }

        System.out.println(map.countOverlapping());
    }

}
