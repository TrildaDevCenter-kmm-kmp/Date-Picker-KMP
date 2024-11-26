package org.waqas028.data_store_kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Date-Picker-KMP",
    ) {
        App(null)
    }
}