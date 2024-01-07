package ru.com.bulat.startandroidlessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import ru.com.bulat.startandroidlessons.ui.lessons.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = mutableStateOf("")

        setContent {
            HomeScreen(
                text,
                onTextChanged = { newText ->
                    text.value = newText
                }
            )
        }
    }
}