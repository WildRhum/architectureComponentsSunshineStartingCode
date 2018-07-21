package com.example.android.sunshine.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.util.Log

@Database(entities = arrayOf(WeatherEntry::class), version = 1)
@TypeConverters(DateConverter::class)
abstract class SunshineDatabase : RoomDatabase() {
    // The associated DAOs for the database
    abstract fun weatherDao(): WeatherDao

    companion object {

        private val LOG_TAG = SunshineDatabase::class.java.simpleName
        private val DATABASE_NAME = "weather"

        // For Singleton instantiation
        private val LOCK = Any()
        private var sInstance: SunshineDatabase? = null

        fun getInstance(context: Context): SunshineDatabase? {
            Log.d(LOG_TAG, "Getting the database")
            if (sInstance == null) {
                synchronized(LOCK) {
                    sInstance = Room.databaseBuilder(context.applicationContext,
                            SunshineDatabase::class.java, SunshineDatabase.DATABASE_NAME).build()
                    Log.d(LOG_TAG, "Made new database")
                }
            }
            return sInstance
        }
    }
}