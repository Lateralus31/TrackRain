package com.lateralus31.trackrain;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TEST CODE
        DBHandler db = new DBHandler(this);

        //INSERTING ENTRIES
        Log.d("Insert: ", "Inserting ..");
        db.addEntry(new Precipitation(1, 1200l, 50f));
        db.addEntry(new Precipitation(2, 1300l, 61f));

        //READING SHOPS
        Log.d("Reading: ", "Reading all shops..");
        List<Precipitation> entries = db.getAllEntries();

        for (Precipitation precipitation : entries)
        {
            String log = "Id: " + precipitation.getId() + " ,Date: " + precipitation.getDate() + " ,Volume: " + precipitation.getVolume();
            //WRITING SHOPS TO LOG
            Log.d("Precipitation: : ", log);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
