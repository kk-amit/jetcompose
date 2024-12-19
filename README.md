# JetCompose
JetCompose - Jetpack Compose UI Library provides an easy-to-use collection of pre-configured and customizable Jetpack Compose widgets that help you quickly create beautiful, responsive, and native Android UIs. 


# Custom Bottom Sheet Component

## Overview
The `CustomBottomSheet` is a composable function designed to create a customizable bottom sheet component in Jetpack Compose. It supports sliding effects, drag gestures, and dismiss actions, making it a versatile UI element for displaying additional content or options to users.

---

## Parameters

| Parameter           | Type           | Description                                                                                     | Default Value                |
|---------------------|----------------|-------------------------------------------------------------------------------------------------|------------------------------|
| `isVisible`         | `Boolean`      | Controls the visibility of the bottom sheet.                                                   | Required                     |
| `content`           | `@Composable`  | A lambda function that defines the content to be displayed inside the bottom sheet.            | Required                     |
| `onDismiss`         | `() -> Unit`   | A lambda function triggered when the bottom sheet is dismissed (e.g., user clicks dismiss).     | Required                     |
| `backgroundColor`   | `Color`        | The background color of the bottom sheet.                                                      | `MaterialTheme.colorScheme.surface` |
| `headerText`        | `String`       | The title text displayed at the top of the bottom sheet.                                       | `"Bottom Sheet Title"`     |
| `onDismissRequest`  | `() -> Unit`   | Optional lambda function for additional dismiss logic.                                         | `{}`                         |


## Usage

### Example Code
```kotlin
@Composable
fun BottomSheetExample() {
    var showSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { showSheet = true }) {
            Text("Show Bottom Sheet")
        }

        CustomBottomSheet(
            isVisible = showSheet,
            onDismiss = { showSheet = false },
            headerText = "Custom Bottom Sheet",
            content = {
                Text("This is the custom content inside the bottom sheet.")
            }
        )
    }
}
```

---

## Implementation Details

### Offset Tracking
The vertical position of the bottom sheet is managed using a `mutableFloatStateOf` variable (`offsetY`).

### Gesture Detection
`detectVerticalDragGestures` is used to enable drag gestures for sliding the bottom sheet.

### UI Structure
- A semi-transparent background covers the screen when the sheet is visible.
- The bottom sheet is placed at the bottom of the screen and styled with rounded corners.

### Dismiss Button
A button is provided inside the bottom sheet to trigger `onDismiss` and `onDismissRequest` actions.

---

## Customization Options
- **Header Text**: Modify the `headerText` parameter to set a custom title.
- **Background Color**: Use the `backgroundColor` parameter to set the desired color.
- **Custom Content**: Pass any composable lambda to the `content` parameter to display your own UI inside the bottom sheet.
- **Dismiss Logic**: Implement additional dismiss logic using the `onDismissRequest` parameter.

---

## Preview
To preview the `CustomBottomSheet`, you can use the following code snippet:
```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewBottomSheet() {
    BottomSheetExample()
}
```

---

## Additional Notes
- The bottom sheet can be further enhanced with additional parameters for more control over animations, sizes, or behaviors.
- Ensure that the `isVisible` state is correctly managed to avoid inconsistencies in UI rendering.

---

# CustomDatePicker

A highly customizable `CustomDatePicker` component for Jetpack Compose, allowing users to select a specific date interactively with options to tweak appearance and behavior.

---

## Features

- **Date Selection**: Allows users to select day, month, and year.
- **Customizable Labels**: Change labels for day, month, and year pickers.
- **Styling Options**: Customize text styles, button designs, and layout.
- **Real-Time Feedback**: Displays the selected date dynamically.
- **Localization Ready**: Supports custom labels for internationalization.

---

## Parameters

| Parameter            | Type                                      | Description                                                                                     | Default Value                      |
|----------------------|-------------------------------------------|-------------------------------------------------------------------------------------------------|------------------------------------|
| `initialDate`        | `LocalDate`                              | The initial date displayed in the picker.                                                      | `LocalDate.now()`                  |
| `onDateSelected`     | `(LocalDate) -> Unit`                    | Callback triggered when the user selects a date.                                               | Required                           |
| `modifier`           | `Modifier`                               | A modifier for the component layout.                                                           | `Modifier`                         |
| `dayLabel`           | `String`                                 | Label for the day picker.                                                                      | `"Day"`                           |
| `monthLabel`         | `String`                                 | Label for the month picker.                                                                    | `"Month"`                         |
| `yearLabel`          | `String`                                 | Label for the year picker.                                                                     | `"Year"`                          |
| `confirmButtonText`  | `String`                                 | Text for the confirm button.                                                                   | `"Confirm"`                       |
| `textStyle`          | `TextStyle`                              | Text style for the date display and labels.                                                    | `MaterialTheme.typography.headlineSmall` |
| `buttonStyle`        | `@Composable (Boolean, () -> Unit, ...)` | Lambda for customizing button design.                                                          | Default Button                     |

---

## Example Usage

```kotlin
@Composable
fun DatePickerExample() {
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        selectedDate?.let {
            Text("Selected Date: $it", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(modifier = Modifier.height(16.dp))

        CustomDatePicker(
            initialDate = LocalDate.of(2023, 8, 15),
            onDateSelected = { date ->
                selectedDate = date
            },
            dayLabel = "Day",
            monthLabel = "Month",
            yearLabel = "Year",
            confirmButtonText = "Set Date"
        )
    }
}
```

---

## Customization Options

### Labels
- Modify the `dayLabel`, `monthLabel`, and `yearLabel` parameters for custom text.

### Button Design
- Override `buttonStyle` with a lambda to provide your own button design.

### Text Style
- Use `textStyle` to customize the text appearance of the labels and date display.

### Date Range
- Restrict the selectable range by controlling `initialDate` and validation logic in `onDecrease` or `onIncrease` of the `PickerRow`.

---

## Implementation Details

1. **State Management**: Uses `remember` to track the selected day, month, and year.
2. **Date Calculation**: Determines valid days based on the selected month and year.
3. **PickerRow**:
   - A reusable composable for day, month, and year pickers.
   - Handles button interactions for incrementing/decrementing values.
4. **Confirm Button**: Triggers the `onDateSelected` callback with the selected date.

---

## Preview

To preview the `CustomDatePicker`, use the following code:

```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewDatePicker() {
    DatePickerExample()
}
```

