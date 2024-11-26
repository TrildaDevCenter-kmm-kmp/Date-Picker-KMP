package org.waqas028.data_store_kmp

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.swing.JOptionPane

actual fun pickDate(context: Any?, onDatePicked: (String) -> Unit) {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val selectedDate = JOptionPane.showInputDialog("Enter a date (dd/MM/yyyy):")
    try {
        val date = LocalDate.parse(selectedDate, formatter)
        onDatePicked(date.format(formatter))
    } catch (e: Exception) {
        println("Invalid date format")
    }
}

actual fun pickTime(context: Any?, onTimePicked: (String) -> Unit) {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val selectedTime = JOptionPane.showInputDialog("Enter a time (HH:mm):")
    try {
        val time = LocalTime.parse(selectedTime, formatter)
        onTimePicked(time.format(formatter))
    } catch (e: Exception) {
        println("Invalid time format")
    }
}