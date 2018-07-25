/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.sunshine.data.database

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Room;

import java.util.Date;

@Entity(tableName = "weather", indices = [(Index(value = [("date")], unique = true))])
class WeatherEntry
/**
 * This constructor is used by OpenWeatherJsonParser. When the network fetch has JSON data, it
 * converts this data to WeatherEntry objects using this constructor.
 * @param weatherIconId Image id for weather
 * @param date Date of weather
 * @param min Min temperature
 * @param max Max temperature
 * @param humidity Humidity for the day
 * @param pressure Barometric pressure
 * @param wind Wind speed
 * @param degrees Wind direction
 */

(@PrimaryKey (autoGenerate = true) val id: Int = 0, var weatherIconId: Int, var date: Date, var min: Double, var max: Double, var humidity: Double, var pressure: Double, var wind: Double, var degrees: Double) {
    constructor(weatherIconId: Int, date1: Date, max1: Double, min1: Double, humidity1: Int, pressure1: Double, windSpeed: Double, windDirection: Double) : this() {

    }
}
