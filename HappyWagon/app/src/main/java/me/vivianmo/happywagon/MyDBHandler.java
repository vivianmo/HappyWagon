package me.vivianmo.happywagon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "stones.db";
    public static final String TABLE_STONES = "stones";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_SPOT = "spotname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_STONES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMN_SPOT + " TEXT " +
                " );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STONES);
        onCreate(db);
    }

    public void addStone(String spot) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SPOT, spot);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STONES, null, values);
        db.close();
    }

    public String getSpot(int i) {
        String[] columns = new String[]{COLUMN_ID, COLUMN_SPOT};
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query(TABLE_STONES, columns, COLUMN_ID + "=" + i, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
            String spot = c.getString(1);
            return spot;
        }
        return null;
    }

    public void update(int id, int spot) {
        ContentValues c = new ContentValues();
        c.put(COLUMN_SPOT, spot);
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLE_STONES, c, COLUMN_ID + "=" + id, null);
    }

    public boolean isEmpty() {
        SQLiteDatabase db = getWritableDatabase();
        String count = "SELECT count(*) FROM " + TABLE_STONES;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) return false;
        else return true;

    }

    /*public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STONES + " WHERE 1";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COLUMN_SPOT)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_SPOT));
                dbString += "\n";
                Log.d("V", "printing");
            }
        }
        db.close();
        return dbString;
    };*/

    public String databaseToString() {
        SQLiteDatabase db = getWritableDatabase();
        Log.d("V", "getTableAsString called");
        String tableString = String.format("Table %s:\n", TABLE_STONES);
        Cursor allRows  = db.rawQuery("SELECT * FROM " + TABLE_STONES, null);
        if (allRows.moveToFirst() ){
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name: columnNames) {
                    tableString += String.format("%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n";

            } while (allRows.moveToNext());
        }

        return tableString;
    }

}






