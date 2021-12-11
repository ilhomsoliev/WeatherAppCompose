package com.oliverworks.weathercompose.ui.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oliverworks.weathercompose.ui.chooseCity.ChooseCityScreen
import com.oliverworks.weathercompose.ui.weatherCity.WeatherScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ChooseCityScreen.route){
        composable(Screen.ChooseCityScreen.route) {
            ChooseCityScreen(navController = navController)
        }
        composable(Screen.WeatherScreen.route + "{city}"){navBackStackEntry ->
            val city = navBackStackEntry.arguments?.getString("city")?:"New York"
            WeatherScreen(city = city)
        }
    }
}