package ru.com.bulat.startandroidlessons.ui.lessons

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
fun HomeScreen(
    text : State<String>,
    onTextChanged : (String)->Unit,
){
    OutlinedTextField(
        value = text.value,
        onValueChange = onTextChanged
    )
}