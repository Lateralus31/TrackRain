package com.lateralus31.trackrain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

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
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        values.put(COL_DATE, precipitation.getDate());
        values.put(COL_VOLUME, precipitation.getVolume());
        //INSERTING ROW
        db.insert(TABLE_PRECIPITATION, null, values);
        db.close(); //CLOSING CONNECTION
    }

    //SHOW ONE ENTRY
    public Precipitation getPrecipitation(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRECIPITATION, new String[] {COL_ID, COL_DATE, COL_VOLUME}, COL_ID + "=?",
                new  String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Precipitation entry = new Precipitation(Integer.parseInt(cursor.getString(0)), cursor.getLong(1), cursor.getFloat(2));
        return entry;
    }

    //SHOW ALL ENTRIES
    public List<Precipitation> getAllEntries()
    {
        List<Precipitation> precipitationList = new ArrayList<Precipitation>();
        //SELECT ALL QUERY
        String selectQuery = "SELECT * FROM " + TABLE_PRECIPITATION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //LOOPING THROUGH ALL ROWS AND ADDING TO LIST
        if (cursor.moveToFirst())
        {
            do {
                Precipitation precipitation = new Precipitation();
                precipitation.setId(Integer.parseInt(cursor.getString(0)));
                precipitation.setDate(cursor.getLong(1));
                precipitation.setVolume(cursor.getFloat(2));
                precipitationList.add(precipitation);
            } while (cursor.moveToNext());
        }
        return precipitationList;
    }

    //GET TOTAL ENTRY COUNT
    public int getPrecipitationCount()
    {
        String countQuery = "SELECT * FROM " + TABLE_PRECIPITATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        //RETURN COUNT
        return cursor.getCount();
    }

    //UPDATING A RECORD
    public int updatePrecipitaton(Precipitation precipitation)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_DATE, precipitation.getDate())
    }

}

