package com.lateralus31.trackrain;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.List;

public class DisplayTable extends AppCompatActivity
{
    //CREATE DB HANDLER
    DBHandler db = new DBHandler(this);
    List allEntries = db.getAllEntries();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_table);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_display_table, allEntries);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }



}
