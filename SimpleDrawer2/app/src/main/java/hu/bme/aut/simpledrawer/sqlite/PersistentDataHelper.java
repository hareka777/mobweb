package hu.bme.aut.simpledrawer.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.simpledrawer.model.Line;
import hu.bme.aut.simpledrawer.model.Point;

public class PersistentDataHelper {
    private SQLiteDatabase database;

    private DBHelper dbHelper;

    private String[] pointColumns = {
            PointsTable.Columns._id.name(),
            PointsTable.Columns.coord_x.name(),
            PointsTable.Columns.coord_y.name()
    };

    private String[] lineColumns = {
            LinesTable.Columns._id.name(),
            LinesTable.Columns.start_x.name(),
            LinesTable.Columns.start_y.name(),
            LinesTable.Columns.end_x.name(),
            LinesTable.Columns.end_y.name()
    };

    public PersistentDataHelper(final Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLiteException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void persistPoints(final List<Point> points) {
        clearPoints();
        for (final Point point : points) {
            final ContentValues values = new ContentValues();
            values.put(PointsTable.Columns.coord_x.name(), point.getX());
            values.put(PointsTable.Columns.coord_y.name(), point.getY());
            database.insert(PointsTable.TABLE_POINTS, null, values);
        }
    }

    public List<Point> restorePoints() {
        final List<Point> points = new ArrayList<>();
        final Cursor cursor = database.query(PointsTable.TABLE_POINTS, pointColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            final Point point = cursorToPoint(cursor);
            points.add(point);
            cursor.moveToNext();
        }
        cursor.close();
        return points;
    }

    public void clearPoints() {
        database.delete(PointsTable.TABLE_POINTS, null, null);
    }

    private Point cursorToPoint(final Cursor cursor) {
        final Point point = new Point();
        point.setX(cursor.getFloat(PointsTable.Columns.coord_x.ordinal()));
        point.setY(cursor.getFloat(PointsTable.Columns.coord_y.ordinal()));
        return point;
    }

    public void persistLines(final List<Line> lines) {
        clearLines();
        for (final Line line : lines) {
            final ContentValues values = new ContentValues();
            values.put(LinesTable.Columns.start_x.name(), line.getStart().getX());
            values.put(LinesTable.Columns.start_y.name(), line.getStart().getY());
            values.put(LinesTable.Columns.end_x.name(), line.getEnd().getX());
            values.put(LinesTable.Columns.end_y.name(), line.getEnd().getY());
            database.insert(LinesTable.TABLE_LINES, null, values);
        }
    }

    public List<Line> restoreLines() {
        final List<Line> points = new ArrayList<>();
        final Cursor cursor = database.query(LinesTable.TABLE_LINES, lineColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            final Line line = cursorToLine(cursor);
            points.add(line);
            cursor.moveToNext();
        }
        cursor.close();
        return points;
    }

    public void clearLines() {
        database.delete(LinesTable.TABLE_LINES, null, null);
    }

    private Line cursorToLine(final Cursor cursor) {
        final Line line = new Line();
        final Point startPoint = new Point();
        startPoint.setX(cursor.getFloat(LinesTable.Columns.start_x.ordinal()));
        startPoint.setY(cursor.getFloat(LinesTable.Columns.start_y.ordinal()));
        line.setStart(startPoint);
        final Point endPoint = new Point();
        endPoint.setX(cursor.getFloat(LinesTable.Columns.end_x.ordinal()));
        endPoint.setY(cursor.getFloat(LinesTable.Columns.end_y.ordinal()));
        line.setEnd(endPoint);
        return line;
    }
}
