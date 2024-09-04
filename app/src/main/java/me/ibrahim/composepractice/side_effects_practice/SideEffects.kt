package me.ibrahim.composepractice.side_effects_practice

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun SideEffects(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//        LaunchedEffectPractice()
//        RememberCoroutineScopeExample()
//        RememberUpdatedStateExample()
        //ProduceStateExampleWeatherInfo("swabi")
        val rating = 3.5
        val c = kotlin.math.ceil(rating)
        val f = kotlin.math.floor(rating)

        val result = rating.rem(1)
        val mr = 3.5 % 1

        Text(text = "$result - $mr  - $c - $f")
    }
}

@Composable
fun LaunchedEffectPractice() {

    var text by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = text) {
        Log.d("SideEffect_", "LaunchedEffect: $text")
    }

    Button(onClick = { text += "#" }) {
        Text(text = "Click Me")
    }
}

@Composable
fun RememberCoroutineScopeExample(modifier: Modifier = Modifier) {
// State to hold the message displayed in the UI
    var message by remember { mutableStateOf("Hello, World!") }

    // Getting a CoroutineScope tied to the composition
    val coroutineScope = rememberCoroutineScope()

    // UI Components
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Launching a coroutine when the button is clicked
            coroutineScope.launch(Dispatchers.IO) {
                // Simulate a long-running task
                delay(8000)
                // Update the message after the delay
                message = "Coroutine Completed!"
                Log.d("SideEffect_", "RememberCoroutineScopeExample: ${Thread.currentThread().name}")
            }
        }) {
            Text("Start Coroutine")
        }
    }
}

@Composable
fun RememberUpdatedStateExample(modifier: Modifier = Modifier) {

    SelfCountDownTimer(5) {

    }
}

@Composable
fun SelfCountDownTimer(totalTimeInSeconds: Int, onFinish: () -> Unit) {
    val updatedOnFinish by rememberUpdatedState(newValue = onFinish)

    var timeLeft by remember { mutableIntStateOf(totalTimeInSeconds) }

    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft -= 1
        } else {
            updatedOnFinish.invoke()
        }
    }

    if (timeLeft > 0)
        Text(text = "Time Left: $timeLeft seconds")
    else
        Text(text = "Counter Finished")
}

/**
 * Another example of rememberUpdatedState
 */
@Composable
fun ParentComponent() {

    Box(modifier = Modifier.fillMaxSize()) {
        var dynamicData by remember {
            mutableStateOf("")
        }
        LaunchedEffect(Unit) {
            delay(3000L)
            dynamicData = "New Text"
        }
        MyComponent(title = dynamicData)
    }

}

@Composable
fun MyComponent(title: String) {
    var data by remember { mutableStateOf("") }

    val updatedData by rememberUpdatedState(title)

    LaunchedEffect(Unit) {
        delay(5000L)
        data = updatedData
    }

    Text(text = data)
}

/**********************************************************/

@Composable
fun DisposableEffectExample(modifier: Modifier = Modifier) {
    NetworkStatusListener(context = LocalContext.current) {

    }
}

@Composable
fun NetworkStatusListener(context: Context, onNetworkStatusChange: (Boolean) -> Unit) {

    val connectivityManager = remember { context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    val networkCallback = remember {
        object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                onNetworkStatusChange.invoke(true)
            }

            override fun onUnavailable() {
                onNetworkStatusChange.invoke(false)
            }
        }
    }

    DisposableEffect(key1 = Unit) {
        connectivityManager.registerDefaultNetworkCallback(networkCallback)

        onDispose {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }
}

/************************************************************/

/**
 * Example of produceState
 */
@Composable
fun ProduceStateExampleWeatherInfo(city: String) {
    // Create a state that will hold the weather information
    val weatherState by produceState<String>(
        initialValue = "Loading...",
        city
    ) {
        // Simulate a network call
        val weatherInfo = fetchWeather(city)
        // Update the state with the fetched weather information
        value = weatherInfo
    }

    // Display the weather information
    Text(text = weatherState)
}

// A function that simulates fetching weather data from a network
suspend fun fetchWeather(city: String): String {
    delay(2000) // Simulate network delay

    // Simulated weather info
    return when (city) {
        "islamabad" -> "Islamabad: Cloudy 28°C"
        "swabi" -> "Swabi: Sunny 34°C"
        else -> ""
    }
}

/*************************************************/
