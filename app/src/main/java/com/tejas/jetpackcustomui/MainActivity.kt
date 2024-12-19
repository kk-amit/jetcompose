package com.tejas.jetpackcustomui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tejas.jetpackcustomui.ui.theme.JetComposeTheme

// Main Activity class
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge display
        setContent {
            JetComposeTheme {
                Scaffold(
                    topBar = {
                        // Configures a custom TopAppBar
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = { Text(text = "Custom UI Widget") },
                            navigationIcon = {
                                IconButton(onClick = { /* Navigation icon action */ }) {
                                    Icon(Icons.Filled.Menu, contentDescription = "Menu Icon")
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                ) { innerPadding ->
                    // Calls the Home Screen Composable
                    ShowHomeScreen(innerPadding)
                }
            }
        }
    }
}

// Displays the home screen with buttons for different UI components
@Composable
fun ShowHomeScreen(paddingValues: PaddingValues) {
    var isParentVisible by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        // State variables for visibility of different components
        var isVisibleBottomSheet by remember { mutableStateOf(false) }
        var isVisibleCustomToast by remember { mutableStateOf(false) }
        var isVisibleDatePicker by remember { mutableStateOf(false) }
        var isVisibleTimePicker by remember { mutableStateOf(false) }
        var isVisibleDialog by remember { mutableStateOf(false) }
        var isVisibleSnackBar by remember { mutableStateOf(false) }
        var isVisibleProgressDialog by remember { mutableStateOf(false) }

        // Displays the main buttons when parent view is visible
        if (isParentVisible) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Button for Bottom Sheet
                Button(onClick = {
                    isVisibleBottomSheet = true
                    isParentVisible = false
                }, modifier = Modifier.width(250.dp)) {
                    Text(text = "Custom Bottom Sheet")
                }

                Spacer(modifier = Modifier.size(10.dp))

                // Button for Custom Toast
                Button(onClick = {
                    isVisibleCustomToast = true
                    isParentVisible = false
                }, modifier = Modifier.width(250.dp)) {
                    Text(text = "Custom Toast")
                }

                Spacer(modifier = Modifier.size(10.dp))

                // Button for Date Picker
                Button(onClick = {
                    isVisibleDatePicker = true
                    isParentVisible = false
                }, modifier = Modifier.width(250.dp)) {
                    Text(text = "Date Picker")
                }

                Spacer(modifier = Modifier.size(10.dp))

                // Button for Time Picker
                Button(onClick = {
                    isVisibleTimePicker = true
                    isParentVisible = false
                }, modifier = Modifier.width(250.dp)) {
                    Text(text = "Time Picker")
                }

                Spacer(modifier = Modifier.size(10.dp))

                // Button for Dialog
                Button(onClick = {
                    isVisibleDialog = true
                    isParentVisible = false
                }, modifier = Modifier.width(250.dp)) {
                    Text(text = "Dialog")
                }

                Spacer(modifier = Modifier.size(10.dp))

                // Button for Snackbar
                Button(onClick = {
                    isVisibleSnackBar = true
                    isParentVisible = false
                }, modifier = Modifier.width(250.dp)) {
                    Text(text = "Snackbar")
                }

                Spacer(modifier = Modifier.size(10.dp))

                // Button for Progress Dialog
                Button(onClick = {
                    isVisibleProgressDialog = true
                    isParentVisible = false
                }, modifier = Modifier.width(250.dp)) {
                    Text(text = "Progress Dialog")
                }
            }
        }

        // Calls the corresponding screen based on visibility
        ShowBottomSheetScreen(isVisibleBottomSheet) {
            isParentVisible = true
            isVisibleBottomSheet = false
        }

        ShowCustomToastScreen(isVisibleCustomToast) {
            isParentVisible = true
            isVisibleCustomToast = false
        }

        ShowDatePickerScreen(isVisibleDatePicker) {
            isParentVisible = true
            isVisibleDatePicker = false
        }

        ShowTimePickerScreen(isVisibleTimePicker) {
            isParentVisible = true
            isVisibleTimePicker = false
        }

        ShowDialogScreen(isVisible = isVisibleDialog) {
            isParentVisible = true
            isVisibleDialog = false
        }

        ShowSnackBarScreen(isVisible = isVisibleSnackBar) {
            isVisibleSnackBar = false
            isParentVisible = true
        }

        ShowProgressDialogScreen(isVisible = isVisibleProgressDialog) {
            isVisibleProgressDialog = false
            isParentVisible = true
        }
    }
}

// Preview function to test UI in the Android Studio preview
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetComposeTheme {
        ShowHomeScreen(PaddingValues.Absolute(0.dp, 0.dp, 0.dp, 0.dp))
    }
}
