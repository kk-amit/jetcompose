package com.tejas.jetcompose.customui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CustomDatePicker(
    initialDate: LocalDate = LocalDate.now(),
    onDateSelected: (LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    dayLabel: String = "Day",
    monthLabel: String = "Month",
    yearLabel: String = "Year",
    confirmButtonText: String = "Confirm",
    textStyle: TextStyle = MaterialTheme.typography.headlineSmall,
    buttonStyle: @Composable (enabled: Boolean, onClick: () -> Unit, content: @Composable RowScope.() -> Unit) -> Unit = { enabled, onClick, content ->
        Button(onClick = onClick, enabled = enabled, content = content)
    }
) {
    var selectedDay by remember { mutableStateOf(initialDate.dayOfMonth) }
    var selectedMonth by remember { mutableStateOf(initialDate.monthValue) }
    var selectedYear by remember { mutableStateOf(initialDate.year) }

    val daysInMonth = YearMonth.of(selectedYear, selectedMonth).lengthOfMonth()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Selected Date
        Text(
            text = "$selectedDay-${selectedMonth}-${selectedYear}",
            style = textStyle,
            modifier = Modifier.padding(16.dp)
        )

        // Day Picker
        PickerRow(
            label = dayLabel,
            value = selectedDay.toString(),
            onDecrease = { if (selectedDay > 1) selectedDay-- },
            onIncrease = { if (selectedDay < daysInMonth) selectedDay++ },
            buttonStyle = buttonStyle,
            textStyle = textStyle
        )

        // Month Picker
        PickerRow(
            label = monthLabel,
            value = java.time.Month.of(selectedMonth).name,
            onDecrease = { if (selectedMonth > 1) selectedMonth-- else selectedMonth = 12 },
            onIncrease = { if (selectedMonth < 12) selectedMonth++ else selectedMonth = 1 },
            buttonStyle = buttonStyle,
            textStyle = textStyle
        )

        // Year Picker
        PickerRow(
            label = yearLabel,
            value = selectedYear.toString(),
            onDecrease = { selectedYear-- },
            onIncrease = { selectedYear++ },
            buttonStyle = buttonStyle,
            textStyle = textStyle
        )

        // Confirm Button
        Button(
            onClick = {
                val selectedDate = LocalDate.of(selectedYear, selectedMonth, selectedDay)
                onDateSelected(selectedDate)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = confirmButtonText)
        }
    }
}

@Composable
fun PickerRow(
    label: String,
    value: String,
    onDecrease: () -> Unit,
    onIncrease: () -> Unit,
    buttonStyle: @Composable (enabled: Boolean, onClick: () -> Unit, content: @Composable RowScope.() -> Unit) -> Unit = { enabled, onClick, content ->
        Button(onClick = onClick, enabled = enabled, content = content)
    },
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Decrease Button
        buttonStyle(enabled = true, onClick = onDecrease) {
            Text(text = "-")
        }

        // Label and Value
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = label, style = MaterialTheme.typography.bodySmall)
            Text(text = value, style = textStyle)
        }

        // Increase Button
        buttonStyle(enabled = true, onClick = onIncrease) {
            Text(text = "+")
        }
    }
}

