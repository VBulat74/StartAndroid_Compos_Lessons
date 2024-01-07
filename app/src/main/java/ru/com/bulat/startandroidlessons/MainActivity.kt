package ru.com.bulat.startandroidlessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import ru.com.bulat.startandroidlessons.ui.lessons.ClickCounter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val counter = mutableStateOf(0)

        setContent {
            ClickCounter(counterValue = counter.value) {
                val newValue = counter.value + 1
                counter.value = newValue
            }
        }
    }
}