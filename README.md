
# JetCompose Library

**JetCompose** is a library providing a suite of custom UI components designed for Jetpack Compose applications. These components aim to simplify and accelerate the development of rich, interactive, and customizable user interfaces.

---

## Table of Contents

1. [Custom UI Components](#custom-ui-components)
   - [CustomToast](#1-customtoast)
   - [CustomBottomSheet](#2-custombottomsheet)
   - [CustomDatePicker](#3-customdatepicker)
   - [CustomDialog](#4-customdialog)
   - [CustomProgressDialog](#5-customprogressdialog)
   - [CustomSnackBar](#6-customsnackbar)
   - [CustomTimePicker](#7-customtimepicker)
2. [Installation](#installation)
3. [Usage](#usage)
4. [License](#license)
5. [Contributions](#contributions)
6. [Previews](#previews)

---

## Custom UI Components

### 1. **CustomToast**
Displays transient messages in a visually appealing toast format. It supports customizable text, background color, font size, duration, and dismiss behavior.

**Features:**
- Configurable message and duration.
- Adjustable text color, background color, and font size.
- Smooth fade-in and fade-out animations.

---

### 2. **CustomBottomSheet**
A reusable bottom sheet component with rich styling options and customizable behavior.

**Features:**
- Fully customizable content.
- Supports draggable behavior.
- Configurable colors, shapes, and animations.

---

### 3. **CustomDatePicker**
An interactive date picker that allows users to select a specific date with customizable labels and styles.

**Features:**
- Day, month, and year selection.
- Customizable labels, styles, and button designs.
- Supports localization and styling options.

---

### 4. **CustomDialog**
A versatile dialog box for displaying messages, confirmations, or custom content.

**Features:**
- Fully customizable title, message, and buttons.
- Configurable styles for text and background.
- Dismiss behavior integrated with actions.

---

### 5. **CustomProgressDialog**
Displays a progress dialog to indicate loading or ongoing operations.

**Features:**
- Configurable message and background color.
- Smooth animations and elevation support.
- Easy to integrate into any screen.

---

### 6. **CustomSnackBar**
A flexible snackbar component for showing brief messages with optional actions.

**Features:**
- Configurable message, action button, and duration.
- Customizable text and button colors.
- Automatically dismisses after the specified duration.

---

### 7. **CustomTimePicker**
An intuitive time picker for selecting hours and minutes with support for 12-hour or 24-hour formats.

**Features:**
- Hour and minute selection with increment and decrement buttons.
- AM/PM toggle for 12-hour format.
- Callback to retrieve the selected time.

---

## Installation
Add the dependency to your project's `build.gradle`:

```groovy
dependencies {
    implementation 'com.tejas.jetcompose:library:1.0.0'
}
```

### Compatibility
- **Android Version**: Minimum SDK 21 (Lollipop)
- **Jetpack Compose Version**: Compatible with Compose 1.2.0 and above.

---

## Usage
Refer to the documentation for each component for detailed usage instructions and examples.

### Quick Start Example
Below is a simple example demonstrating the usage of the `CustomBottomSheet` component:

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

## License
This library is licensed under the MIT License. See [LICENSE](LICENSE) for details.

---

## Contributions
Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m "Add feature"`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a Pull Request.

For detailed setup and contribution guidelines, refer to [CONTRIBUTING.md](CONTRIBUTING.md).

---

## Previews
Here are some visual examples of the components:

### CustomToast Preview

```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewCustomToast() {
    ToastExample()
}
```

### CustomDatePicker Preview

```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewDatePicker() {
    DatePickerExample()
}
```

---

Feel free to explore and customize JetCompose to fit your application's needs. Happy Coding!



Details Description : 
---

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

# CustomDialog

A reusable and customizable `CustomDialog` component for Jetpack Compose that provides a simple and elegant way to display dialogs with confirm and cancel actions.

---

## Features

- **Visibility Control**: Show or hide the dialog based on a boolean flag.
- **Customizable Content**: Modify the title, message, and button text.
- **Action Handling**: Define callbacks for confirm and cancel actions.
- **Styling Options**: Adjust border color, background color, and text styles.
- **Dismiss Logic**: Option to handle additional logic on dialog dismissal.

---

## Parameters

| Parameter            | Type              | Description                                                                                     | Default Value                           |
|----------------------|-------------------|-------------------------------------------------------------------------------------------------|-----------------------------------------|
| `isVisible`          | `Boolean`         | Controls the visibility of the dialog.                                                         | Required                                |
| `title`              | `String`          | The title displayed at the top of the dialog.                                                  | Required                                |
| `message`            | `String`          | The message content displayed in the dialog.                                                   | Required                                |
| `confirmText`        | `String`          | Text displayed on the confirm button.                                                          | `"Confirm"`                           |
| `cancelText`         | `String`          | Text displayed on the cancel button.                                                           | `"Cancel"`                            |
| `onConfirm`          | `() -> Unit`      | Callback triggered when the confirm button is clicked.                                         | `{}`                                    |
| `onCancel`           | `() -> Unit`      | Callback triggered when the cancel button is clicked.                                          | `{}`                                    |
| `borderColor`        | `Color`           | Color of the dialog's border.                                                                  | `Color.Black`                           |
| `backgroundColor`    | `Color`           | Background color of the dialog.                                                                | `MaterialTheme.colorScheme.surface`    |
| `titleStyle`         | `TextStyle`       | Text style for the title.                                                                      | `MaterialTheme.typography.titleLarge`  |
| `messageStyle`       | `TextStyle`       | Text style for the message.                                                                    | `MaterialTheme.typography.bodyMedium`  |
| `onDismissRequest`   | `() -> Unit`      | Optional callback for additional dismiss logic when the dialog is dismissed.                   | `{}`                                    |

---

## Example Usage

```kotlin
@Composable
fun DialogExample() {
    var isDialogVisible by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { isDialogVisible = true }) {
            Text("Show Dialog")
        }

        CustomDialog(
            isVisible = isDialogVisible,
            title = "Confirmation Required",
            message = "Are you sure you want to proceed?",
            confirmText = "Yes",
            cancelText = "No",
            onConfirm = {
                // Handle confirm action
                isDialogVisible = false
            },
            onCancel = {
                // Handle cancel action
                isDialogVisible = false
            },
            onDismissRequest = {
                // Handle additional dismiss logic
                isDialogVisible = false
            }
        )
    }
}
```

---

## Customization Options

### Title and Message
- Modify the `title` and `message` parameters to change the dialog's content.

### Button Text
- Customize `confirmText` and `cancelText` for localized or contextual button labels.

### Styling
- Use `borderColor`, `backgroundColor`, `titleStyle`, and `messageStyle` to match the dialog's appearance with your app's theme.

### Dismiss Logic
- Implement `onDismissRequest` to handle additional logic when the dialog is dismissed.

---

## Implementation Details

1. **Visibility Control**: Utilizes `AnimatedVisibility` for smooth appearance and disappearance animations.
2. **Surface and Card**:
   - The `Surface` component wraps the dialog with a transparent background to cover the entire screen.
   - The `Card` component provides the styled container for the dialog content.
3. **Callbacks**:
   - `onConfirm` and `onCancel` handle button actions.
   - `onDismissRequest` ensures proper dismissal logic.
4. **Responsive Layout**:
   - The dialog is centered using a `Box` with `wrapContentSize`.
   - Padding and spacing ensure proper alignment and readability.

---

## Preview

To preview the `CustomDialog`, use the following code:

```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewDialog() {
    DialogExample()
}
```

# CustomProgressDialog

A customizable `CustomProgressDialog` component for Jetpack Compose, designed to display a progress indicator with a message during loading states. The dialog is fully customizable in terms of background color, text, and visibility.

---

## Features

- **Progress Indicator**: Displays a circular progress indicator.
- **Customizable Message**: Set a custom loading message.
- **Customizable Appearance**: Adjust background color and dialog styling.
- **Visibility Control**: Show or hide the dialog using the `isVisible` flag.

---

## Parameters

| Parameter        | Type              | Description                                                                 | Default Value                        |
|------------------|-------------------|-----------------------------------------------------------------------------|--------------------------------------|
| `isVisible`      | `Boolean`         | Controls the visibility of the progress dialog.                            | Required                             |
| `text`           | `String`          | The text message displayed below the progress indicator.                   | `"Loading..."`                     |
| `backgroundColor`| `Color`           | The background color of the dialog overlay.                                | `Color.Black.copy(alpha = 0.5f)`     |
| `onDismiss`      | `() -> Unit`      | Callback triggered when the dialog is dismissed.                           | `{}`                                 |

---

## Example Usage

```kotlin
@Composable
fun ProgressDialogExample() {
    var showDialog by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { showDialog = !showDialog },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = if (showDialog) "Hide Dialog" else "Show Dialog")
        }

        CustomProgressDialog(
            isVisible = showDialog,
            text = "Please wait...",
            backgroundColor = Color.Black.copy(alpha = 0.7f),
            onDismiss = { showDialog = false }
        )
    }
}
```

---

## Customization Options

### Loading Text
- Use the `text` parameter to specify a custom loading message.

### Background Overlay
- Adjust the `backgroundColor` parameter to customize the overlay color and opacity.

### Visibility
- Control the dialog visibility dynamically by toggling the `isVisible` parameter.

### Dismiss Action
- Provide an `onDismiss` callback to define actions when the dialog is dismissed.

---

## Implementation Details

1. **Visibility Control**:
   - The composable is conditionally rendered based on the `isVisible` parameter.
2. **Circular Progress Indicator**:
   - Displays a primary-colored progress indicator using `CircularProgressIndicator`.
3. **Surface Styling**:
   - Uses Material3's `Surface` with elevation for better dialog appearance.
4. **Overlay**:
   - Semi-transparent overlay background for focus on the dialog.

---

## Preview

To preview the `CustomProgressDialog`, use the following code:

```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewProgressDialog() {
    ProgressDialogExample()
}
```

# CustomSnackBar

A customizable `CustomSnackBar` component for Jetpack Compose, allowing users to display transient messages with optional action buttons.

---

## Features

- **Message Display**: Displays a message at the bottom of the screen.
- **Action Button**: Includes an optional action button with customizable text and behavior.
- **Customizable Design**: Modify text, colors, font size, and layout.
- **Automatic Dismissal**: Dismisses itself after a specified duration.
- **Theme Integration**: Leverages Material3 themes for seamless integration.

---

## Parameters

| Parameter        | Type                     | Description                                                                                 | Default Value                                   |
|------------------|--------------------------|---------------------------------------------------------------------------------------------|-----------------------------------------------|
| `message`        | `String`                 | The main message text displayed in the snackbar.                                            | Required                                      |
| `actionText`     | `String?`                | Text for the optional action button.                                                       | `null`                                       |
| `onActionClick`  | `(() -> Unit)?`          | Callback triggered when the action button is clicked.                                       | `null`                                       |
| `textColor`      | `Color`                  | Color of the snackbar message text.                                                        | `MaterialTheme.colorScheme.onBackground`     |
| `backgroundColor`| `Color`                  | Background color of the snackbar.                                                          | `MaterialTheme.colorScheme.primary`          |
| `duration`       | `Int`                    | Duration for which the snackbar is visible. Supports `Toast.LENGTH_SHORT`, `Toast.LENGTH_LONG`, or custom milliseconds. | `Toast.LENGTH_SHORT`              |
| `fontSize`       | `TextUnit`               | Font size for the snackbar message and action text.                                         | `16.sp`                                      |
| `onDismiss`      | `() -> Unit`             | Callback triggered when the snackbar is dismissed.                                          | Empty lambda                                 |
| `borderColor`    | `Color`                  | Border color for the snackbar.                                                             | `Color.Black`                                |
| `actionButtonColors`| `ButtonColors`        | Colors for the action button.                                                              | MaterialTheme secondary button colors        |

---

## Example Usage

### Basic Snackbar
```kotlin
@Composable
fun SnackBarExample() {
    var showSnackBar by remember { mutableStateOf(true) }

    if (showSnackBar) {
        CustomSnackBar(
            message = "This is a snackbar",
            onDismiss = { showSnackBar = false }
        )
    }
}
```

### Snackbar with Action Button
```kotlin
@Composable
fun SnackBarWithActionExample() {
    var showSnackBar by remember { mutableStateOf(true) }

    if (showSnackBar) {
        CustomSnackBar(
            message = "Data saved successfully",
            actionText = "Undo",
            onActionClick = { /* Undo action logic */ },
            onDismiss = { showSnackBar = false }
        )
    }
}
```

---

## Customization Options

### Text Appearance
- Adjust `textColor` and `fontSize` for the message and action button text.

### Colors
- Change `backgroundColor`, `borderColor`, and `actionButtonColors` to match your app's theme.

### Duration
- Use predefined `Toast.LENGTH_SHORT`, `Toast.LENGTH_LONG`, or custom durations in milliseconds for the `duration` parameter.

### Action Button
- Include an action button with the `actionText` and `onActionClick` parameters.

---

## Implementation Details

1. **Animated Visibility**: Snackbar appears with animation for a smoother user experience.
2. **Custom Timing**: Snackbar auto-dismisses after the specified duration using `LaunchedEffect` and `delay`.
3. **Action Button**: Optional button allows users to perform an action before dismissal.
4. **Material3 Styling**: Utilizes Material3's theming for buttons and colors.

---

## Preview

```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewSnackBar() {
    SnackBarWithActionExample()
}
```

Use this component to display lightweight feedback or messages with action buttons in your Compose app!


# CustomTimePicker

A highly flexible `CustomTimePicker` composable for Jetpack Compose, enabling users to select a specific time interactively with customizable options for 24-hour or 12-hour formats.

---

## Features

- **Time Selection**: Users can select hours and minutes with interactive buttons.
- **AM/PM Toggle**: Supports 12-hour format with AM/PM switching.
- **24-Hour Format**: Easily switch to 24-hour time format.
- **Real-Time Display**: Shows the selected time dynamically.
- **Customizable Appearance**: Modify text, colors, and layout to match your theme.

---

## Parameters

| Parameter           | Type                       | Description                                                                 | Default Value       |
|---------------------|----------------------------|-----------------------------------------------------------------------------|---------------------|
| `initialHour`       | `Int`                      | The initial hour displayed in the picker.                                   | `12`               |
| `initialMinute`     | `Int`                      | The initial minute displayed in the picker.                                 | `0`                |
| `is24HourFormat`    | `Boolean`                  | Determines whether the picker uses a 24-hour format.                        | `false`            |
| `onTimeSelected`    | `(Int, Int, String?) -> Unit` | Callback triggered when the user confirms the selected time.               | Required           |

---

## Example Usage

```kotlin
@Composable
fun TimePickerExample() {
    var selectedTime by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select Time", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        CustomTimePicker(
            initialHour = 10,
            initialMinute = 30,
            is24HourFormat = false
        ) { hour, minute, amPm ->
            selectedTime = String.format("%02d:%02d %s", hour, minute, amPm ?: "").trim()
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedTime?.let {
            Text(text = "Selected Time: $it", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
```

---

## Customization Options

### Time Format
- Use the `is24HourFormat` parameter to switch between 24-hour and 12-hour time formats.

### Initial Time
- Set the `initialHour` and `initialMinute` parameters to define the default time.

### Callback
- The `onTimeSelected` callback provides the final hour, minute, and AM/PM status (if applicable) when the confirm button is pressed.

---

## Implementation Details

1. **State Management**: Utilizes `remember` to maintain selected hour, minute, and AM/PM state.
2. **Time Format Handling**:
   - Adjusts hour range based on the selected format.
   - Converts 12-hour time to 24-hour format when confirming the selection.
3. **Dynamic UI**:
   - Provides real-time updates to the displayed time.
   - Includes buttons for incrementing and decrementing hours and minutes.
4. **AM/PM Toggle**: Active in 12-hour format for toggling between AM and PM.

---

## Preview

To preview the `CustomTimePicker`, use the following code:

```kotlin
@Preview
@Composable
fun PreviewTimePicker() {
    TimePickerExample()
}
```

# CustomToast

`CustomToast` is a composable for displaying a customizable toast message in Jetpack Compose. It offers control over the appearance, duration, and dismissal behavior, making it versatile for different use cases.

---

## Features

- **Customizable Appearance**: Change text color, background color, and font size.
- **Animated Visibility**: Smooth fade-in and fade-out transitions for the toast.
- **Flexible Duration**: Predefined short and long durations or custom time.
- **Dismiss Callback**: Trigger actions after the toast disappears.

---

## Parameters

| Parameter        | Type                   | Description                                                                | Default Value             |
|------------------|------------------------|----------------------------------------------------------------------------|---------------------------|
| `message`        | `String`               | The message to display inside the toast.                                  | Required                  |
| `duration`       | `Int`                  | Duration for which the toast will be visible. Use `Toast.LENGTH_SHORT` or `Toast.LENGTH_LONG`, or specify custom duration in milliseconds. | `Toast.LENGTH_SHORT`      |
| `textColor`      | `Color`                | The color of the text.                                                    | `MaterialTheme.colorScheme.onBackground` |
| `backgroundColor`| `Color`                | Background color of the toast.                                            | `Color.White`             |
| `fontSize`       | `TextUnit`             | Font size of the text inside the toast.                                   | `18.sp`                   |
| `onDismiss`      | `() -> Unit`           | Callback function that is called after the toast dismisses.               | `{}`                      |

---

## Example Usage

```kotlin
@Composable
fun ToastExample() {
    var showToast by remember { mutableStateOf(true) }

    if (showToast) {
        CustomToast(
            message = "This is a custom toast!",
            duration = Toast.LENGTH_SHORT,
            textColor = Color.White,
            backgroundColor = Color.Black,
            fontSize = 16.sp,
            onDismiss = {
                showToast = false
            }
        )
    }

    Button(onClick = { showToast = true }) {
        Text("Show Toast")
    }
}
```

---

## Customization Options

### Duration
- Use `Toast.LENGTH_SHORT` (default: 1.5 seconds) or `Toast.LENGTH_LONG` (default: 3.5 seconds).
- Specify a custom duration in milliseconds.

### Text Appearance
- Modify `textColor` to change the color of the text.
- Adjust `fontSize` for the desired text size.

### Background
- Change `backgroundColor` to fit the app's theme.

### Dismiss Callback
- Implement logic in `onDismiss` to handle actions after the toast disappears.

---

## Implementation Details

1. **State Management**:
   - Uses `remember` and `mutableStateOf` to manage the visibility of the toast.

2. **Animated Visibility**:
   - Fades the toast in and out using `fadeIn()` and `fadeOut()` animations.

3. **Auto Dismissal**:
   - Automatically hides the toast after the specified duration using `LaunchedEffect` and `delay`.

4. **Toast Layout**:
   - Styled using a `Box` with padding, rounded corners, and shadow for a polished appearance.

---

## Preview

To preview the `CustomToast`, use the following code:

```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewCustomToast() {
    ToastExample()
}
```

