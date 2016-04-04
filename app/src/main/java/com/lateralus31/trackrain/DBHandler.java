package com.lateralus31.trackrain;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Thomas Foster on 4/04/2016.
 */
public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "trackRainDatabase";
    // Contacts table name
    private static final String TABLE_PRECIPITATION = "precipitation";
    // Shops Table Columns names
    private static final String COL_ID = "id";
    private static final String COL_DATE = "date";
    private static final String COL_VOLUME = "volume";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRECIPITATION_TABLE = "CREATE TABLE " + TABLE_PRECIPITATION + "("
                + COL_ID + " INTEGER PRIMARY KEY,"
                + COL_DATE + " DATE,"
                + COL_VOLUME + " FLOAT" + ")";
        db.execSQL(CREATE_PRECIPITATION_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRECIPITATION);
    // Creating tables again
        onCreate(db);
    }

    //ADDING A NEW ENTRY
    public void addEntry(Precipitation precipitation)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        values.put(COL_DATE, precipitation.getDate());
        values.put(COL_VOLUME, precipitation.getVolume());
    }
}
