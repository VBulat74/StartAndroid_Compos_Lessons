package ru.com.bulat.startandroidlessons.ui.lessons

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class EvenOdd() {
    fun check(value: Int): String {
        return if (value % 2 == 0) "even" else "odd"
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun ClickCounter(
    counterValue: Int,
    onCounterClick: () -> Unit
) {
    val evenOdd = remember {
        EvenOdd()
    }

    Text(
        text = "Clicks: $counterValue ${evenOdd.check(counterValue)}",
        modifier = Modifier.clickable ( onClick = onCounterClick ),
        fontSize = 20.sp
    )
    Log.d("AAA", "ClickCounter $counterValue ${evenOdd.hashCode().toHexString()}")
}