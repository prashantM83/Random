package com.example.practical8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Contacts.db";
    private static final int    DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "contacts";
    private static final String COL_ID    = "id";
    private static final String COL_NAME  = "name";
    private static final String COL_PHONE = "phone";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
            COL_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME  + " TEXT, " +
            COL_PHONE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertContact(String name, String phone) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_PHONE, phone);
        return getWritableDatabase().insert(TABLE_NAME, null, values) != -1;
    }

    public Cursor getAllContacts() {
        return getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public boolean updateContact(int id, String name, String phone) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_PHONE, phone);
        return getWritableDatabase().update(TABLE_NAME, values, "id=?",
            new String[]{String.valueOf(id)}) > 0;
    }

    public boolean deleteContact(int id) {
        return getWritableDatabase().delete(TABLE_NAME, "id=?",
            new String[]{String.valueOf(id)}) > 0;
    }
}
