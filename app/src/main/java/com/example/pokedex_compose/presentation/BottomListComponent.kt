package com.example.pokedex_compose.presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomListComponent(modifier: Modifier = Modifier, uiState: UiState, errorMessage: String, onPaging: () -> Unit) {
    Box(Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center) {
        when (uiState) {
            UiState.Success -> {
                Spacer(Modifier.height(24.dp))
                LaunchedEffect(Unit) {
                    Log.d(">>>", "paging call")
                    onPaging()
                }
            }
            UiState.Paging -> {
                CircularProgressIndicator(Modifier.size(24.dp))
            }
            UiState.PagingError -> ErrorComponent(message = errorMessage, onClick = onPaging)
            else -> Box {}
        }
    }
}