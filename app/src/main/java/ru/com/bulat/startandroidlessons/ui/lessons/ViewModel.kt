package ru.com.bulat.startandroidlessons.ui.lessons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@Composable
fun HomeScreen_ViewModel(
    homeViewModel: HomeViewModel = viewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    Column {
        ClickCounterParam(
            count = uiState.count
        ) {
            homeViewModel.onCounterClick()
        }
        EnableFeature(
            enabled = uiState.enabled,
            onEnabledChange = homeViewModel::setEnabled
        )
    }
}

@Composable
fun HomeScreen_ViewModel(
    uiState: HomeScreenUiState,
    onCounterClick: () -> Unit,
    onEnabledChange: (Boolean) -> Unit
) {
    Column {
        ClickCounter(
            counterValue = uiState.count,
            onCounterClick = onCounterClick
        )
        EnableFeature(
            enabled = uiState.enabled,
            onEnabledChange = onEnabledChange
        )
    }
}

@Composable
fun ClickCounterParam(
    count : Int,
    onCounterClick: () -> Unit
){
    Text(
        text = "Clicks: $count",
        fontSize = 20.sp,
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
}

@Composable
fun EnableFeature(
    enabled: Boolean,
    onEnabledChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = CenterVertically) {
        Checkbox(checked = enabled, onCheckedChange = onEnabledChange)
        Text("enable feature")
    }
}

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState

    fun onCounterClick() {
        _uiState.update {
            it.copy(count = it.count + 1)
        }
    }

    fun setEnabled(enabled: Boolean) {
        _uiState.update {
            it.copy(enabled = enabled)
        }
    }
}
data class HomeScreenUiState(
    val count: Int = 0,
    val enabled: Boolean = false
)
