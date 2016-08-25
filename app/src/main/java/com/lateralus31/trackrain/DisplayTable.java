package com.lateralus31.trackrain;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
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
    }

    ListAdapter adapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2, allEntries, from, to);

}
