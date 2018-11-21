package hu.bme.aut.androidwallet.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SaladTable {
    public static final String TABLE_SALADS = "salads";
    private static final String DATABASE_CREATE = "create table " + TABLE_SALADS + "("
            + SaladTable.Columns._id.name() + " integer primary key autoincrement, "
            + SaladTable.Columns.saladname.name() + " real not null, "
            + Columns.saladbought.name() + " real not null, "
            + Columns.saladprice.name() + " real not null, "
            + SaladTable.Columns.saladpic.name() + " real not null" + ");";
    public static void onCreate(final SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(final SQLiteDatabase database, final int oldVersion, final int newVersion) {
        Log.w(SaladTable.class.getName(), "Upgrading from version " + oldVersion + " to " + newVersion);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_SALADS);
        onCreate(database);
    }
    public enum Columns {
        _id,
        saladname,
        saladbought,
        saladprice,
        saladpic



    }
}
