package hu.bme.aut.simpledrawer.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "simpledrawer.db";

    private static final int DATABASE_VERSION = 1;

    public DBHelper(final Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        LinesTable.onCreate(sqLiteDatabase);
        PointsTable.onCreate(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int oldVersion, final int newVersion) {
        LinesTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
        PointsTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }
}
