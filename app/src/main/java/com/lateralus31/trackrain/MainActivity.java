package com.lateralus31.trackrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity
{

    Button buttonCalendar;
    Button buttonViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OPEN CALENDAR BUTTON
        buttonCalendar=(Button)findViewById(R.id.btnCalendar);
            buttonCalendar.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(getApplicationContext(),CalendarView.class);
                    startActivity(i);
                }
            });

        //VIEW DATA BUTTON
        buttonViewData=(Button)findViewById(R.id.btnViewTable);
            buttonViewData.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(getApplicationContext(),DisplayTable.class);
                    startActivity(i);
                }
            });

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
    }

}
