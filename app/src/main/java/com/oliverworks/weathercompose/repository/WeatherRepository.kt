package com.oliverworks.weathercompose.repository

import com.oliverworks.weathercompose.data.CityWeather
import com.oliverworks.weathercompose.network.WeatherApi
import com.oliverworks.weathercompose.util.Resource
import retrofit2.Response
import javax.inject.Inject
class WeatherRepository @Inject constructor(private val weatherApi:WeatherApi) {

    suspend fun getWeatherForCity(city:String): Resource<CityWeather> {
        return try{
            val response: Response<CityWeather> = weatherApi.getWeatherForCity(city)
            if(response.isSuccessful){
                Resource.success(response.body())
            }else {
                Resource.error(response.message(),null)
            }
        }catch (e:Exception){
            Resource.error("Could not be connected. Problems ${e.message}",null)
        }
    }
}

