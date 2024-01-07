package ru.com.bulat.startandroidlessons.ui.lessons

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    checked: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit,
    onTextClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedValue = checked.value
        Checkbox(
            checked = checkedValue,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = "Some checkbox text",
            fontSize = 18.sp,
            modifier = Modifier.clickable(onClick =onTextClick)
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(mutableStateOf(false), {}, {})
}