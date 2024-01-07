package ru.com.bulat.startandroidlessons.ui.lessons

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    count: State<Int>,
    onCounterClick: () -> Unit
) {
    val counterValue = count.value
    Text(
        text = "Click: ${counterValue}",
        modifier = Modifier.clickable { onCounterClick() }
    )
}