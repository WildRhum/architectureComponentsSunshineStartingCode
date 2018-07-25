package com.example.android.sunshine.data.database

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;

@Dao
interface WeatherDao  {

    // Checked at compile time and not real time !
    @Query("SELECT * FROM weather WHERE date = :date")
    fun getWeatherByDate(date: Date): WeatherEntry

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg weather: WeatherEntry)

    abstract fun WeatherDao(): WeatherDao
}