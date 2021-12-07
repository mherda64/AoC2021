package day5;

public class PointPair {

    public Point first, second;

    public PointPair(int x1, int y1, int x2, int y2) {
        first = new Point(x1, y1);
        second = new Point(x2, y2);
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }
}
