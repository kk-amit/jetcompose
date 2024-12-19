package com.tejas.jetcompose.customui

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun CustomSnackBar(
    message: String,
    actionText: String? = null,
    onActionClick: (() -> Unit)? = null,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    duration: Int = Toast.LENGTH_SHORT,
    fontSize: TextUnit = 16.sp,
    onDismiss: () -> Unit = {},
    borderColor: Color = Color.Black,
    actionButtonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary
    )
) {
    val snackBarDuration = when (duration) {
        Toast.LENGTH_SHORT -> 1500L // Adjust short duration as needed
        Toast.LENGTH_LONG -> 3500L // Adjust long duration as needed
        else -> duration.toLong() // Custom duration in milliseconds
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        AnimatedVisibility(visible = true) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(backgroundColor),
                border = BorderStroke(2.dp, borderColor)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Snackbar Message
                    Text(
                        text = message,
                        style = TextStyle(
                            fontSize = fontSize,
                            color = textColor
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    // Action Button
                    actionText?.let {
                        Button(
                            onClick = {
                                onActionClick?.invoke()
                                onDismiss()
                            },
                            colors = actionButtonColors,
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .height(36.dp)
                                .wrapContentWidth()
                        ) {
                            Text(
                                text = it,
                                style = TextStyle(
                                    fontSize = fontSize,
                                    color = actionButtonColors.contentColor
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    // Automatically dismiss the snackbar after the set duration
    LaunchedEffect(key1 = true) {
        delay(snackBarDuration)
        onDismiss()
    }
}