package hu.bme.aut.simpledrawer.model;
public class Line {
    private Point start;

    private Point end;

    public Line() {
    }

    public Line(final Point start, final Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(final Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(final Point end) {
        this.end = end;
    }
}