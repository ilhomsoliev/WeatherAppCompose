package com.oliverworks.weathercompose.ui.weatherCity

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oliverworks.weathercompose.data.CityWeather
import com.oliverworks.weathercompose.repository.WeatherRepository
import com.oliverworks.weathercompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository:WeatherRepository): ViewModel() {

    private val _cityWeather = mutableStateOf<Resource<CityWeather>>(Resource.loading(null))
    val cityWeather: State<Resource<CityWeather>> = _cityWeather
    fun getWeatherForCity(city:String) {
        viewModelScope.launch {
            _cityWeather.value = weatherRepository.getWeatherForCity(city)
        }
    }
}