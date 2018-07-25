package com.example.android.sunshine.data.database


import android.arch.persistence.room.TypeConverter
import java.util.*

internal object DateConverter {
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return (if (date == null) null else date.time.toLong())
    }
}