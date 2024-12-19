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
