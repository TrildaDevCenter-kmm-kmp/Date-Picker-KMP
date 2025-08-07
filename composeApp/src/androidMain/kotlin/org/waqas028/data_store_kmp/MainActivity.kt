package org.waqas028.data_store_kmp

import LocalPlatformContext
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import java.util.Calendar
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val activityContext = LocalContext.current // This IS an Activity Context!


            CompositionLocalProvider(LocalPlatformContext provides activityContext) {
                App()
            }

        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}

// Android-specific implementation
actual fun pickDate(context: Any?, onDatePicked: (String) -> Unit) {
    // Ensure context is of type Context
    if (context !is Context) return

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // Android-specific DatePickerDialog
    DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            onDatePicked(date)
        },
        year,
        month,
        day
    ).show()
}

actual fun pickTime(context: Any?, onTimePicked: (String) -> Unit) {
    // Ensure context is of type Context
    if (context !is Context) return

    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    // Android-specific TimePickerDialog
    TimePickerDialog(
        context,
        { _, selectedHour, selectedMinute ->
            val time = String.format(Locale.getDefault(),"%02d:%02d", selectedHour, selectedMinute)
            onTimePicked(time)
        },
        hour,
        minute,
        true // is24HourView
    ).show()
}