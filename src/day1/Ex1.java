package day1;

import static day1.Ex1Constants.input;

public class Ex1 {

    public static void main(String[] args) {
        int counter = 0;
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) > input.get(i-1)) {
                counter++;
            }
        }
        System.out.println(counter);

        secondMain();

    }

    public static void secondMain() {
        int counter = 0;
        long prevSum = -1;
        for (int i = 0; i < input.size() - 2; i++) {
            var sum = input.get(i) + input.get(i + 1) + input.get(i + 2);
            if (prevSum == -1) {
                prevSum = sum;
            } else {
                if (prevSum < sum) {
                    counter++;
                }
                prevSum = sum;
            }
        }
        System.out.println(counter);

    }

}