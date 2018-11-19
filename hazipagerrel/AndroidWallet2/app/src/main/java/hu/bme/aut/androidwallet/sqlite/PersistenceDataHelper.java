package hu.bme.aut.androidwallet.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

public class PersistenceDataHelper {
    private SQLiteDatabase database;

    private DBHelper dbHelper;

    private String[] saladColumns = {
            SaladTable.Columns._id.name(),
            SaladTable.Columns.saladname.name(),
            SaladTable.Columns.saladbought.name(),
            SaladTable.Columns.saladprice.name(),
            SaladTable.Columns.saladpic.name()

    };



    public PersistenceDataHelper(final Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLiteException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }


    public void persistPoints(final List<SaladItem> salads) {
        clearSalads();
        for (final SaladItem salad : salads) {
            final ContentValues values = new ContentValues();
            values.put(SaladTable.Columns.saladname.name(),salad.getName());
            values.put(SaladTable.Columns.saladbought.name(),salad.getBought());
            values.put(SaladTable.Columns.saladprice.name(),salad.getPrice());
            values.put(SaladTable.Columns.saladpic.name(),salad.getPic());

            database.insert(SaladTable.TABLE_SALADS, null, values);
        }
    }

    public List<SaladItem> restorePoints() {
        final List<SaladItem> salads = new ArrayList<>();
        final Cursor cursor = database.query(SaladTable.TABLE_SALADS, saladColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            final SaladItem point = cursorToPoint(cursor);
            salads.add(point);
            cursor.moveToNext();
        }
        cursor.close();
        return salads;
    }

    public void clearSalads() {
        database.delete(SaladTable.TABLE_SALADS, null, null);
    }

    private SaladItem cursorToPoint(final Cursor cursor) {
        final SaladItem salad = new SaladItem();
        salad.setName(cursor.getString(SaladTable.Columns.saladname.ordinal()));
        salad.setBought(cursor.getInt(SaladTable.Columns.saladbought.ordinal()));
        salad.setPic(cursor.getInt(SaladTable.Columns.saladpic.ordinal()));
        salad.setPrice(cursor.getInt(SaladTable.Columns.saladprice.ordinal()));

        return salad;
    }








}