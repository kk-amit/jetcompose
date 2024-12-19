package com.tejas.jetcompose.customui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A customizable bottom sheet component with a sliding effect, drag gestures, a dismiss button,
 * and custom content.
 *
 * @param isVisible Boolean flag to control the visibility of the bottom sheet.
 * @param content A Composable lambda function to display custom content inside the bottom sheet.
 * @param onDismiss Lambda function to handle actions when the bottom sheet is dismissed (e.g., closing the bottom sheet).
 * @param backgroundColor Background color of the bottom sheet. Defaults to the surface color from MaterialTheme.
 * @param headerText The title text shown at the top of the bottom sheet. Defaults to "Bottom Sheet Title".
 * @param onDismissRequest Optional lambda to handle additional dismiss logic (default is empty).
 */
@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun CustomBottomSheet(
    isVisible: Boolean,
    content: @Composable () -> Unit,
    onDismiss: () -> Unit,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    headerText: String = "Bottom Sheet Title",
    onDismissRequest: () -> Unit = {}
) {
    // State to track the vertical offset of the bottom sheet (for drag gestures)
    var offsetY by remember { mutableFloatStateOf(0f) }

    // Maximum and minimum slide distances for the bottom sheet (for drag gestures)
    val maxOffset = 500f // Max offset (fully closed)
    val minOffset = 0f // Min offset (fully expanded)

    // AnimatedVisibility allows us to control visibility with animations
    AnimatedVisibility(visible = isVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize() // Takes up the whole screen
                .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent black background
                .pointerInput(Unit) {
                    // Detect vertical drag gestures to slide the bottom sheet up/down
                    detectVerticalDragGestures { _, dragAmount ->
                        offsetY = (offsetY + dragAmount).coerceIn(minOffset, maxOffset)
                    }
                }
        ) {
            // The bottom sheet itself
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter) // Position it at the bottom of the screen
                    .fillMaxWidth() // Take up full width
                    .offset(y = -offsetY.dp) // Apply the offset to simulate sliding
                    .background(
                        backgroundColor,
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp
                        ) // Rounded corners for a smooth look
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth() // Make the column take full width
                        .padding(24.dp), // Padding inside the bottom sheet
                    horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                ) {
                    // Header Text (Title of the Bottom Sheet)
                    Text(
                        text = headerText,
                        style = TextStyle(
                            fontSize = 22.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp)) // Spacer between header and content

                    // Custom content passed by the caller of the Composable
                    content()

                    Spacer(modifier = Modifier.height(24.dp)) // Spacer before dismiss button

                    // Dismiss Button that triggers the onDismiss and onDismissRequest actions
                    Button(
                        onClick = {
                            onDismiss() // Trigger dismiss callback
                            onDismissRequest() // Trigger additional dismiss request logic
                        }
                    ) {
                        Text("Dismiss") // Dismiss text on the button
                    }
                }
            }
        }
    }
}