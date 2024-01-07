package ru.com.bulat.startandroidlessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import ru.com.bulat.startandroidlessons.ui.theme.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counter = mutableStateOf(0)

        setContent {
            HomeScreen(
                count = counter,
                {counter.value++}
            )
        }
    }
}