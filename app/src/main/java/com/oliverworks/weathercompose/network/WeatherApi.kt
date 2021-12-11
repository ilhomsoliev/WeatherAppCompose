package com.oliverworks.weathercompose.network

import com.oliverworks.weathercompose.data.CityWeather
import com.oliverworks.weathercompose.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeatherForCity(
        @Query("q") city:String,
        @Query("appid") appid:String = Constants.API_KEY,
        @Query("units") units:String = "metric"
    ): Response<CityWeather>
}