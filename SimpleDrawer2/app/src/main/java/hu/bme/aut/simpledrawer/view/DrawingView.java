package hu.bme.aut.simpledrawer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.simpledrawer.model.Line;
import hu.bme.aut.simpledrawer.model.Point;

public class DrawingView extends View {

    private Paint paint;

    private Point startPoint;

    private Point endPoint;

    private List<Line> lines;

    private List<Point> points;
    public enum DrawingStyle {
        LINE,
        POINT
    }

    private DrawingStyle currentDrawingStyle = DrawingStyle.LINE;

    public void setDrawingStyle(final DrawingStyle drawingStyle) {
        this.currentDrawingStyle = drawingStyle;
    }
    public DrawingView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        initLists();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    private void initLists() {
        lines = new ArrayList<>();
        points = new ArrayList<>();
    }
    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        endPoint = new Point(event.getX(), event.getY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startPoint = new Point(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                switch (currentDrawingStyle) {
                    case POINT:
                        addPointToTheList(endPoint);
                        break;
                    case LINE:
                    default:
                        addLineToTheList(startPoint, endPoint);
                }
                startPoint = null;
                endPoint = null;
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    private void addPointToTheList(final Point startPoint) {
        points.add(startPoint);
    }

    private void addLineToTheList(final Point startPoint, final Point endPoint) {
        lines.add(new Line(startPoint, endPoint));
    }
    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        for (final Point point : points) {
            drawPoint(canvas, point);
        }
        for (final Line line : lines) {
            drawLine(canvas, line.getStart(), line.getEnd());
        }

        switch (currentDrawingStyle) {
            case POINT:
                drawPoint(canvas, endPoint);
                break;
            case LINE:
            default:
                drawLine(canvas, startPoint, endPoint);
        }
    }

    private void drawPoint(final Canvas canvas, final Point point) {
        if (point == null) {
            return;
        }
        canvas.drawPoint(point.getX(), point.getY(), paint);
    }

    private void drawLine(final Canvas canvas, final Point startPoint, final Point endPoint) {
        if (startPoint == null || endPoint == null) {
            return;
        }
        canvas.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), paint);
    }
    public void restoreObjects(final List<Point> points, final List<Line> lines) {
        this.points = points;
        this.lines = lines;
        invalidate();
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Line> getLines() {
        return lines;
    }
    public void clearCanvas(){
        lines.clear();
        points.clear();
        invalidate();
    }
}