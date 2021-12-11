package com.oliverworks.weathercompose.ui.chooseCity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.oliverworks.weathercompose.ui.components.WeatherTextField
import com.oliverworks.weathercompose.ui.util.Screen


@Composable
fun ChooseCityScreen(navController: NavController) {
    var cityName by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Choose city...", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        WeatherTextField(cityName = cityName, onValueChange = {
            cityName = it
        })

        Spacer(modifier = Modifier.height(16.dp))
        // TODO Make it comp
        Button(
            onClick = {
                if (cityName.isNotBlank()) {
                    navController.navigate(Screen.WeatherScreen.route + cityName)
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(text = "Click to find out")

        }

    }
}