package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static day3.Day3Const.day3Input;

public class Day3 {

    public static void main(String[] args) {

        ex2();

    }

    private static void ex1() {
        int[] countTable = new int[12];
        for (var line : day3Input) {
            for (int i = 0; i < line.length(); i++) {
                countTable[i] += Integer.parseInt(String.valueOf(line.charAt(i)));
            }
        }
        var sb = new StringBuilder();
        Arrays.stream(countTable)
                .mapToObj(val -> day3Input.length / 2 > val ? "0" : "1")
                .forEach(sb::append);
        System.out.println(sb.toString());
        var gamma = Integer.parseInt(sb.toString(), 2);
        System.out.println(gamma * (~gamma & 0xFFF));
    }

    private static void ex2() {
        int[] countTable = new int[12];
        for (var line : day3Input) {
            for (int i = 0; i < line.length(); i++) {
                countTable[i] += Integer.parseInt(String.valueOf(line.charAt(i)));
            }
        }
        var lines = new ArrayList<>(List.of(day3Input));

        for (int i = 0; i < countTable.length; i++) {
            lines = exclude(lines, i, false);
            if (lines.size() == 1) {
                break;
            }
        }
        var oxygen = Integer.parseInt(lines.get(0), 2);

        lines = new ArrayList<>(List.of(day3Input));

        for (int i = 0; i < countTable.length; i++) {
            lines = exclude(lines, i, true);
            if (lines.size() == 1) {
                break;
            }
        }
        var co2 = Integer.parseInt(lines.get(0), 2);

        System.out.println(oxygen);
        System.out.println(co2);
        System.out.println(oxygen * co2);

    }

    private static ArrayList<String> exclude(ArrayList<String> lines, int bit, boolean flip) {
        int[] countTable = new int[12];
        for (var line : lines) {
            for (int i = 0; i < line.length(); i++) {
                countTable[i] += Integer.parseInt(String.valueOf(line.charAt(i)));
            }
        }
        char desired;
        if (flip) {
            desired = lines.size() / 2 > countTable[bit] ? '1' : '0';
        } else {
            desired = lines.size() / 2 > countTable[bit] ? '0' : '1';
        }
        var output = new ArrayList<String>();
        for (var line : lines) {
            if (line.charAt(bit) == desired) {
                output.add(line);
            }
        }
        return output;
    }
}
