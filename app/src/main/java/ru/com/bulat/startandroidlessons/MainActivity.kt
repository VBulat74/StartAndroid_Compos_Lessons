package ru.com.bulat.startandroidlessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.com.bulat.startandroidlessons.ui.lessons.HomeScreen
import ru.com.bulat.startandroidlessons.ui.lessons.HomeScreen_ViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen_ViewModel()
        }
    }
}