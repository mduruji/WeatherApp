package com.chatterbox.weatherapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chatterbox.weatherapp.ui.theme.WeatherAppTheme

/**
 * phase 1: create weather display
 * todo: create square card with curved edges
 *       should display location at the top
 *       should display temperature in the middle
 *       should display conditiion at the bottom
 *       should have a refresh button bellow the card
 *       make a variable to hold the icon
 *
 * phase 2: implement logic
 * todo: implement structure for icons
 *       implement refresh logic
 *       refresh logic should be able to change the location
 *       it should be able to map the condition to the correct icon
 *       (hash map would be best)
 *       add card bg color change
 *
 * **/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        WeatherDisplay()
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherCard(
    location: String,
    temperature: String,
    condition: String,
//    icon: Icon
) {
    ElevatedCard(
        modifier = Modifier
            .width(400.dp)
            .height(400.dp),
        shape = RoundedCornerShape(16.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = location)
            Text(text = temperature)
            Text(text = condition)
//            Icon(
//                imageVector = icon,
//                contentDescription = null
//            )
        }
    }
}

@Composable
fun WeatherDisplay() {
    var location by remember { mutableStateOf("New York") }
    var temperature by remember { mutableStateOf("72°F") }
    var condition by remember { mutableStateOf("Sunny") }

    WeatherCard(
        location = "New York",
        temperature = "72°F",
        condition = "Sunny",
    )

    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = { /*TODO*/ }) {
        Text(text = "Refresh")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
        WeatherDisplay()
    }
}