package com.tejas.jetpackcustomui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tejas.jetcompose.customui.CustomBottomSheet
import com.tejas.jetcompose.customui.CustomDatePicker
import com.tejas.jetcompose.customui.CustomDialog
import com.tejas.jetcompose.customui.CustomProgressDialog
import com.tejas.jetcompose.customui.CustomSnackBar
import com.tejas.jetcompose.customui.CustomTimePicker
import com.tejas.jetcompose.customui.CustomToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate

/**
 * This class is used as a library reference for various custom UI components.
 * Each method demonstrates the usage of a specific reusable UI element such as Bottom Sheet, Dialog, Toast, etc.
 */

@Composable
fun ShowBottomSheetScreen(isVisible: Boolean, onDismiss: () -> Unit) {
    var isVisibleBottomSheet by remember { mutableStateOf(isVisible) }

    // Displays a custom bottom sheet with content and dismiss handling.
    CustomBottomSheet(
        isVisible = isVisibleBottomSheet,
        onDismiss = {
            isVisibleBottomSheet = false
            onDismiss()
        },
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("This is some customizable content")
                Text("You can add any UI components here.")
            }
        }
    )

    // Syncs visibility state with the parent component.
    LaunchedEffect(isVisible) {
        isVisibleBottomSheet = isVisible
    }
}

@Composable
fun ShowCustomToastScreen(isVisible: Boolean, onDismiss: () -> Unit) {
    var isVisibleToast by remember { mutableStateOf(isVisible) }

    // Displays a custom toast message with a dismiss callback.
    if (isVisibleToast) {
        CustomToast(
            backgroundColor = Color.Green,
            message = "This is a custom toast message!",
            duration = 1000,
            onDismiss = {
                isVisibleToast = false
                onDismiss()
            }
        )
    }

    // Syncs visibility state with the parent component.
    LaunchedEffect(isVisible) {
        isVisibleToast = isVisible
    }
}

@Composable
fun ShowDatePickerScreen(isVisible: Boolean, onDismiss: () -> Unit) {
    var isVisibleDatePicker by remember { mutableStateOf(isVisible) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    val scope = rememberCoroutineScope()

    // Displays a custom date picker with a confirmation button.
    if (isVisibleDatePicker) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Reusable Date Picker",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomDatePicker(
                onDateSelected = { date ->
                    selectedDate = date
                    scope.launch {
                        delay(5000)
                        onDismiss()
                    }
                },
                confirmButtonText = "Set Date"
            )

            Spacer(modifier = Modifier.height(16.dp))

            selectedDate?.let {
                Text(
                    text = "Selected Date: $it",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

    // Syncs visibility state with the parent component.
    LaunchedEffect(isVisible) {
        isVisibleDatePicker = isVisible
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun ShowTimePickerScreen(isVisible: Boolean, onDismiss: () -> Unit) {
    var isVisibleTimePicker by remember { mutableStateOf(isVisible) }
    val scope = rememberCoroutineScope()

    // Displays a custom time picker with AM/PM format.
    if (isVisibleTimePicker) {
        var selectedTime by remember { mutableStateOf<String?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Custom Time Picker", style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(16.dp))

            CustomTimePicker(is24HourFormat = false) { hour, minute, amPm ->
                selectedTime = String.format(
                    "%02d:%02d %s",
                    hour,
                    minute,
                    amPm ?: ""
                ).trim()
                scope.launch {
                    delay(5000)
                    onDismiss()
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            selectedTime?.let {
                Text(text = "Selected Time: $it", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }

    // Syncs visibility state with the parent component.
    LaunchedEffect(isVisible) {
        isVisibleTimePicker = isVisible
    }
}

@Composable
fun ShowDialogScreen(isVisible: Boolean, onDismiss: () -> Unit) {
    var isVisibleDialog by remember { mutableStateOf(isVisible) }

    // Displays a custom dialog with confirm and cancel actions.
    if (isVisibleDialog) {
        var isDialogVisible by remember { mutableStateOf(true) }

        CustomDialog(
            isVisible = isDialogVisible,
            title = "Confirm Action",
            message = "Are you sure you want to delete this item?",
            onConfirm = {
                isDialogVisible = false
                onDismiss()
            },
            onCancel = {
                isDialogVisible = false
                onDismiss()
            },
            backgroundColor = Color.White,
            titleStyle = TextStyle(fontSize = 22.sp, color = Color.Red),
            borderColor = Color.Black
        )
    }

    // Syncs visibility state with the parent component.
    LaunchedEffect(isVisible) {
        isVisibleDialog = isVisible
    }
}

@Composable
fun ShowSnackBarScreen(isVisible: Boolean, onDismiss: () -> Unit) {
    var isVisibleSnackBar by remember { mutableStateOf(isVisible) }

    // Displays a custom snackbar with an action button.
    if (isVisibleSnackBar) {
        CustomSnackBar(
            message = "Are you sure you want to delete this item?",
            actionText = "Confirm Action",
            onActionClick = {
                isVisibleSnackBar = false
                onDismiss()
            },
            onDismiss = {
                isVisibleSnackBar = false
                onDismiss()
            },
            duration = 5000
        )
    }

    // Syncs visibility state with the parent component.
    LaunchedEffect(isVisible) {
        isVisibleSnackBar = isVisible
    }
}

@Composable
fun ShowProgressDialogScreen(isVisible: Boolean, onDismiss: () -> Unit) {
    var isVisibleDialog by remember { mutableStateOf(isVisible) }

    // Displays a custom progress dialog.
    if (isVisibleDialog) {
        CustomProgressDialog(
            isVisible = isVisibleDialog,
            text = "Please wait...",
            onDismiss = {
                isVisibleDialog = false
                onDismiss()
            }
        )
    }

    // Syncs visibility state with the parent component and dismisses automatically after a delay.
    LaunchedEffect(isVisible) {
        isVisibleDialog = isVisible
        delay(5000)
        isVisibleDialog = false
        onDismiss()
    }
}
