package day4;

import java.util.ArrayList;

import static day4.Day4Const.numbers;
import static day4.Day4Const.tables;

public class Day4 {

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    private static void ex1() {

        var tableArr = new ArrayList<Table>();
        for (var table : tables) {
            tableArr.add(new Table(table));
        }

        outLoop:
        for (var number : numbers) {
            for (var table : tableArr) {
                table.markNumber(Integer.parseInt(number));
                if (table.checkIfWinner()) {
                    var unmarkedSum = table.getUnmarkedSum();
                    System.out.println(unmarkedSum * Integer.parseInt(number));
                    break outLoop;
                }
            }
        }
    }


    private static void ex2() {

        var tableArr = new ArrayList<Table>();
        for (var table : tables) {
            tableArr.add(new Table(table));
        }

        int winCounter = 0;

        outLoop:
        for (var number : numbers) {
//            System.out.println(number);
            for (var table : tableArr) {
                if (!table.checkIfWinner()) {
                    table.markNumber(Integer.parseInt(number));
                    if (table.checkIfWinner()) {
                        winCounter++;
                        if (winCounter == tableArr.size()) {
                            System.out.println(table.getUnmarkedSum() * Integer.parseInt(number));
                            break outLoop;
                        }
                    }
                }

            }
        }
    }

}
