package day4;

public class Table {

    private boolean[][] markTable = new boolean[5][5];
    private int[][] table = new int[5][5];
    private boolean winner = false;

    public Table(String tableString) {
        var rows = tableString.split("\n");
        for (int i = 0; i < rows.length; i++) {
            var nums = rows[i].trim().split("  ?");
            for (int j = 0; j < nums.length; j++) {
                table[i][j] = Integer.parseInt(nums[j]);
            }
        }
    }

    public void markNumber(int number) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == number) {
                    markTable[i][j] = true;
                }
            }
        }
    }

    public boolean checkIfWinner() {
        if (winner) {
            return true;
        }

        for (int i = 0; i < table.length; i++) {
            if (markTable[i][0] &&
                    markTable[i][1] &&
                    markTable[i][2] &&
                    markTable[i][3] &&
                    markTable[i][4]) {
                winner = true;
                return true;
            }
            if (markTable[0][i] &&
                    markTable[1][i] &&
                    markTable[2][i] &&
                    markTable[3][i] &&
                    markTable[4][i]) {
                winner = true;
                return true;
            }
        }
        return false;
    }

    public int getUnmarkedSum() {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!markTable[i][j]) {
                    sum += table[i][j];
                }
            }
        }
        return sum;
    }

}
