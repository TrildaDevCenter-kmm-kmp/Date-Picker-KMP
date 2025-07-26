package org.waqas028.data_store_kmp

import LocalPlatformContext
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppContent()
    }
}

// commonMain
@Composable
fun AppContent() {


    val platformContext = LocalPlatformContext.current


    var selectedDate by remember { mutableStateOf("Select a date") }
    var selectedTime by remember { mutableStateOf("Select a time") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unified Date & Time Picker",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )

        // Date Picker
        Text(text = "Date: $selectedDate")
        Button(onClick = { pickDate(platformContext) { date -> selectedDate = date } }) {
            Text("Pick a Date")
        }

        // Time Picker
        Text(text = "Time: $selectedTime")
        Button(onClick = { pickTime(platformContext) { time -> selectedTime = time } }) {
            Text("Pick a Time")
        }
    }
}