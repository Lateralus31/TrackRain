package com.lateralus31.trackrain;

import java.sql.Date;

/**
 * Created by Thomas Foster on 4/04/2016.
 */
public class Precipitation
{
    private int id;
    private Long date;
    private Float volume;

    public Precipitation()
    {

    }

    public Precipitation(int id, Long date, Float volume)
    {
        this.id=id;
        this.date=date;
        this.volume=volume;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setDate(Long date)
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

    public Long getDate() {
        Date c = new Date(System.currentTimeMillis());
        long milliseconds = c.getTime();
        return milliseconds;
    //To get current time
    }

    public Float getVolume()
    {
        return volume;
    }
}