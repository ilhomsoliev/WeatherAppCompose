package com.oliverworks.weathercompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oliverworks.weathercompose.ui.util.Screen

@Composable
fun WeatherButton(cityName:String, navController:NavController) {
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