package com.example.pokedex_compose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorComponent(modifier: Modifier = Modifier, message: String, onClick: () -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (message.isNotBlank()) {
            Text(message, fontSize = 18.sp)
            Spacer(Modifier.height(16.dp))
        }
        Button(
            onClick = onClick,
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "refresh"
            )
            Spacer(Modifier.width(8.dp))
            Text("tentar novamente")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ErrorComponentPreview() {
    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        ErrorComponent(message = "ocorreu um erro desconhecido", onClick = {})
    }
}