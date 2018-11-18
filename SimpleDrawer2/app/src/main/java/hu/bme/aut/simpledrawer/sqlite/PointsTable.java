package hu.bme.aut.simpledrawer.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PointsTable {
    public static final String TABLE_POINTS = "points";

    private static final String DATABASE_CREATE = "create table " + TABLE_POINTS + "("
            + Columns._id.name() + " integer primary key autoincrement, "
            + Columns.coord_x.name() + " real not null, "
            + Columns.coord_y.name() + " real not null" + ");";

    public static void onCreate(final SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(final SQLiteDatabase database, final int oldVersion, final int newVersion) {
        Log.w(PointsTable.class.getName(), "Upgrading from version " + oldVersion + " to " + newVersion);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_POINTS);
        onCreate(database);
    }

    public enum Columns {
        _id,
        coord_x,
        coord_y
    }
}