package com.lateralus31.trackrain;

import org.w3c.dom.Text;

import java.sql.Date;

/**
 * Created by Thomas Foster on 4/04/2016.
 */
public class Precipitation
{
    private int id;
    private Text date;
    private Float volume;

    public Precipitation()
    {

    }

    public Precipitation(int id, Text date, Float volume)
    {
        this.id=id;
        this.date=date;
        this.volume=volume;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setDate(Text date)
    {
        this.date = date;
    }

    public void setVolume(Float volume)
    {
        this.volume = volume;
    }

    public int getId()
    {
        return id;
    }

    public Text getDate()
    {
        return date;
    }

    public Float getVolume()
    {
        return volume;
    }
}