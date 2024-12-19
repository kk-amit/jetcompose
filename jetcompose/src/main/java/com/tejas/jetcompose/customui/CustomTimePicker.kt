package com.tejas.jetcompose.customui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@SuppressLint("DefaultLocale")
@Composable
fun CustomTimePicker(
    initialHour: Int = 12,
    initialMinute: Int = 0,
    is24HourFormat: Boolean = false,
    onTimeSelected: (Int, Int, String?) -> Unit
) {
    var selectedHour by remember { mutableStateOf(initialHour) }
    var selectedMinute by remember { mutableStateOf(initialMinute) }
    var isAm by remember { mutableStateOf(true) }

    val maxHour = if (is24HourFormat) 23 else 12
    val minHour = if (is24HourFormat) 0 else 1

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Selected Time
        val amPmText = if (!is24HourFormat) if (isAm) "AM" else "PM" else null
        Text(
            text = String.format(
                "%02d:%02d %s",
                selectedHour,
                selectedMinute,
                amPmText ?: ""
            ).trim(),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        // Hour Picker
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                selectedHour = if (selectedHour > minHour) selectedHour - 1 else maxHour
            }) {
                Text(text = "-")
            }
            Text(
                text = String.format("%02d", selectedHour),
                style = MaterialTheme.typography.headlineSmall
            )
            Button(onClick = {
                selectedHour = if (selectedHour < maxHour) selectedHour + 1 else minHour
            }) {
                Text(text = "+")
            }
        }

        // Minute Picker
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                selectedMinute = if (selectedMinute > 0) selectedMinute - 1 else 59
            }) {
                Text(text = "-")
            }
            Text(
                text = String.format("%02d", selectedMinute),
                style = MaterialTheme.typography.headlineSmall
            )
            Button(onClick = {
                selectedMinute = if (selectedMinute < 59) selectedMinute + 1 else 0
            }) {
                Text(text = "+")
            }
        }

        // AM/PM Toggle (if not 24-hour format)
        if (!is24HourFormat) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { isAm = true }) {
                    Text(text = "AM", color = if (isAm) Color.Blue else Color.Gray)
                }
                Button(onClick = { isAm = false }) {
                    Text(text = "PM", color = if (!isAm) Color.Blue else Color.Gray)
                }
            }
        }

        // Confirm Button
        Button(
            onClick = {
                val finalHour = if (is24HourFormat) selectedHour else {
                    if (isAm) {
                        if (selectedHour == 12) 0 else selectedHour
                    } else {
                        if (selectedHour == 12) 12 else selectedHour + 12
                    }
                }
                onTimeSelected(finalHour, selectedMinute, amPmText)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Confirm")
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun TimePickerScreen() {
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
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedTime?.let {
            Text(text = "Selected Time: $it", style = MaterialTheme.typography.bodyLarge)
        }
    }
}