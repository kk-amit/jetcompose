package com.tejas.jetcompose.customui

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun CustomToast(
    message: String, // The message to display inside the toast.
    duration: Int = Toast.LENGTH_SHORT, // Duration for which the toast will be visible.
    textColor: Color = MaterialTheme.colorScheme.onBackground, // The color of the text.
    backgroundColor: Color = Color.White, // Background color of the toast.
    fontSize: TextUnit = 18.sp, // Font size of the text inside the toast.
    onDismiss: () -> Unit = {} // Callback function that is called after the toast dismisses.
) {
    // Calculate the duration of the toast in milliseconds based on the provided duration.
    val toastDuration = when (duration) {
        Toast.LENGTH_SHORT -> 1500L // Default short duration is 1.5 seconds.
        Toast.LENGTH_LONG -> 3500L // Default long duration is 3.5 seconds.
        else -> duration.toLong() // Custom duration.
    }

    // State to control the visibility of the toast
    var isToastVisible by remember { mutableStateOf(true) }

    // Box will overlay the toast on top of the current UI without affecting the layout below.
    Box(
        modifier = Modifier.fillMaxSize(), // Ensures that we are filling the entire screen.
        contentAlignment = Alignment.BottomCenter // Align the toast to the bottom-center of the screen.
    ) {
        // LaunchedEffect will delay the dismiss callback after the toast duration.
        LaunchedEffect(Unit) {
            delay(toastDuration) // Wait for the specified duration before dismissing the toast.
            isToastVisible = false // Hide the toast after the duration.
            onDismiss() // Call the onDismiss callback when the toast disappears.
        }

        // AnimatedVisibility allows us to fade the toast in and out.
        AnimatedVisibility(
            visible = isToastVisible, // Toast is visible based on the state.
            enter = fadeIn(), // Fade in animation when the toast appears.
            exit = fadeOut(), // Fade out animation when the toast disappears.
            modifier = Modifier.padding(16.dp) // Padding around the toast to prevent it from touching screen edges.
        ) {
            // Box that holds the content of the toast, including the background color, shadow, and padding.
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(16.dp)
                    ) // Shadow effect with rounded corners.
                    .background(
                        color = backgroundColor,
                        shape = RoundedCornerShape(16.dp)
                    ) // Background color with rounded corners.
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(40.dp), // Padding inside the toast around the message.
                contentAlignment = Alignment.Center // Align the text to the center of the toast box.
            ) {
                // Text element representing the message inside the toast.
                Text(
                    text = message, // The message to display inside the toast.
                    fontSize = fontSize, // Font size for the message text.
                    color = textColor // Color of the text.
                )
            }
        }
    }
}

// Preview function to show how the CustomToast looks with sample data.
@Composable
fun CustomToastPreview() {
    CustomToast(
        message = "This is a custom toast message!", // Sample message to be shown.
        duration = Toast.LENGTH_SHORT, // Show the toast for the short duration (1.5 seconds).
        textColor = Color.White, // Text color of the toast (white).
        backgroundColor = Color.Black, // Background color of the toast (black).
        fontSize = 18.sp, // Font size of 18.sp to make the message slightly larger.
        onDismiss = { println("Toast dismissed!") } // Print a log when the toast is dismissed.
    )
}





