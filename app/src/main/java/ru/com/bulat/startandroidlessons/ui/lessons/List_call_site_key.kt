package ru.com.bulat.startandroidlessons.ui.lessons

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SomeItem(text: String) {
    Log.d("AAA", "Some item: $text")
    Text(
        text = text,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .padding(16.dp)
    )
}

@Composable
fun HomeScreen() {
    Log.d("AAA", "Home screen")
    val list = remember() {
        List(20) { "Item ${it + 1}" }.toMutableStateList()
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(list) { item ->
            SomeItem(text = item)
        }
    }
}