package day5;

public class Map {

    private int[][] map;
    private int xSize, ySize;

    public Map(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        map = new int[xSize][ySize];
    }

    public void markHorizontalVertical(PointPair pair) {
        var first = pair.first;
        var second = pair.second;
        if (first.x == second.x || first.y == second.y) {
            if (first.x == second.x) {
                int min = Math.min(first.y, second.y);
                int max = Math.max(first.y, second.y);
                for (int i = min; i <= max; i++) {
                    map[first.x][i] += 1;
                }
            } else {
                int min = Math.min(first.x, second.x);
                int max = Math.max(first.x, second.x);
                for (int i = min; i <= max; i++) {
                    map[i][first.y] += 1;
                }
            }
        }
    }

    public void markAll(PointPair pair) {
        markHorizontalVertical(pair);
        var first = pair.first;
        var second = pair.second;
        if (first.x != second.x && first.y != second.y) {
            while (first.x != second.x && first.y != second.y) {
                map[first.x][first.y] += 1;
                first.x += first.x < second.x ? 1 : -1;
                first.y += first.y < second.y ? 1 : -1;
            }
            map[first.x][first.y] += 1;
        }
    }

    public int countOverlapping() {
        var counter = 0;
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                counter += map[i][j] > 1 ? 1 : 0;
            }
        }
        return counter;
    }


}
