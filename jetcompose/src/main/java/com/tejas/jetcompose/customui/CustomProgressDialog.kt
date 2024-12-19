package com.tejas.jetcompose.customui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun CustomProgressDialog(
    isVisible: Boolean,
    text: String = "Loading...",
    backgroundColor: Color = Color.Black.copy(alpha = 0.5f),
    onDismiss: () -> Unit = {},
) {
    if (isVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .wrapContentSize(Alignment.Center)
        ) {
            // Use Surface instead of Card to support elevation in Material3
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 8.dp, // Correct elevation for Material3 Surface
                modifier = Modifier
                    .wrapContentSize()
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Progress Indicator (Circular)
                    CircularProgressIndicator(
                        modifier = Modifier.size(50.dp),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = text,
                        style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurface)
                    )
                }
            }
        }
    }
}
