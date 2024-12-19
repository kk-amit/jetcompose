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
6. [Details Description](#details-description)

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

Feel free to explore and customize JetCompose to fit your application's needs. Happy Coding!



# Details Description

## Custom Bottom Sheet Component

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

## CustomDatePicker

## Overview
A highly customizable `CustomDatePicker` component for Jetpack Compose, allowing users to select a specific date interactively with options to tweak appearance and behavior.

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

## CustomDialog

## Overview
A reusable and customizable `CustomDialog` component for Jetpack Compose that provides a simple and elegant way to display dialogs with confirm and cancel actions.

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

## CustomProgressDialog

## Overview
A customizable `CustomProgressDialog` component for Jetpack Compose, designed to display a progress indicator with a message during loading states. The dialog is fully customizable in terms of background color, text, and visibility.

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

## CustomSnackBar

## Overview
A customizable `CustomSnackBar` component for Jetpack Compose, allowing users to display transient messages with optional action buttons. Use this component to display lightweight feedback or messages with action buttons in your Compose app!

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

## CustomTimePicker

## Overview
A highly flexible `CustomTimePicker` composable for Jetpack Compose, enabling users to select a specific time interactively with customizable options for 24-hour or 12-hour formats.

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

## CustomToast

## Overview
`CustomToast` is a composable for displaying a customizable toast message in Jetpack Compose. It offers control over the appearance, duration, and dismissal behavior, making it versatile for different use cases.

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