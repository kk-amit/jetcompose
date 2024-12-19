package com.tejas.jetcompose.customui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomDialog(
    isVisible: Boolean,
    title: String,
    message: String,
    confirmText: String = "Confirm",
    cancelText: String = "Cancel",
    onConfirm: () -> Unit = {},
    onCancel: () -> Unit = {},
    borderColor: Color = Color.Black,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    titleStyle: TextStyle = MaterialTheme.typography.titleLarge,
    messageStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    onDismissRequest: () -> Unit = {}
) {
    AnimatedVisibility(visible = isVisible) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            color = Color.Transparent,
            onClick = { onDismissRequest() }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    border = BorderStroke(2.dp, borderColor),
                    colors = CardDefaults.cardColors(backgroundColor),

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = title,
                            style = titleStyle.copy(fontSize = 20.sp),
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = message,
                            style = messageStyle.copy(fontSize = 16.sp),
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Cancel Button
                            OutlinedButton(
                                onClick = {
                                    onCancel()
                                    onDismissRequest() // dismiss dialog
                                }
                            ) {
                                Text(cancelText)
                            }

                            // Confirm Button
                            Button(
                                onClick = {
                                    onConfirm()
                                    onDismissRequest() // dismiss dialog
                                }
                            ) {
                                Text(confirmText)
                            }
                        }
                    }
                }
            }
        }
    }
}