package hu.bme.aut.simpledrawer.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class LinesTable {
    public static final String TABLE_LINES = "lines";

    private static final String DATABASE_CREATE = "create table " + TABLE_LINES + "("
            + Columns._id.name() + " integer primary key autoincrement, "
            + Columns.start_x.name() + " real not null, "
            + Columns.start_y.name() + " real not null, "
            + Columns.end_x.name() + " real not null, "
            + Columns.end_y.name() + " real not null" + ");";

    public static void onCreate(final SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(final SQLiteDatabase database, final int oldVersion, final int newVersion) {
        Log.w(LinesTable.class.getName(), "Upgrading from version " + oldVersion + " to " + newVersion);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_LINES);
        onCreate(database);
    }

    public enum Columns {
        _id,
        start_x,
        start_y,
        end_x,
        end_y
    }
}
