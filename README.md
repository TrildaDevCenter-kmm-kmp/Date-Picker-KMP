# Multi-Platform Date Picker for Compose Multiplatform (CMP/KMM)

## Overview
This repository contains a multi-platform date and time picker implementation built using Jetpack Compose Multiplatform (CMP). This project aims to provide a simple and reusable date-picker solution across Android, iOS, and Desktop applications.
This allows you to quickly implement a platform-consistent date-picker that works seamlessly across all platforms!

## Demo
## Android
https://github.com/user-attachments/assets/f20d3b61-55b5-4443-b7f9-6d32d49d5d27

## IOS
https://github.com/user-attachments/assets/e253a787-c113-497c-959c-d74f6faaa8ac


## Features
- **Cross-Platform**: Works on Android, iOS, and Desktop.
- **Platform-Specific Design**: Uses the appropriate native date-picker component for each platform:
- **Android**: Material3 Date Picker Dialog 🗓️
- **iOS**: Swift Date Picker Wheel 🕰️
- **Desktop**: Text Field for date and time entry 💻
- **Easy-to-Use**: Simple API to integrate into your app.
- **Customizable**: Supports different date/time formats and more.

 ## Android Date Picker
 ```kotlin
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
```

## IOS Date Picker
```kotlin
actual fun pickDate(context: Any?, onDatePicked: (String) -> Unit) {
    val datePicker = UIDatePicker().apply {
        datePickerMode = UIDatePickerMode.UIDatePickerModeDate
        preferredDatePickerStyle =
            UIDatePickerStyle.UIDatePickerStyleWheels // Use the wheel-style picker
        translatesAutoresizingMaskIntoConstraints = false
    }

    val alertController = UIAlertController.alertControllerWithTitle(
        title = "Pick a Date",
        message = "\n\n\n\n\n\n\n",
        preferredStyle = UIAlertControllerStyleAlert
    )

    alertController.view.addSubview(datePicker)

    // Set constraints for the DatePicker
    datePicker.centerXAnchor.constraintEqualToAnchor(alertController.view.centerXAnchor).active =
        true
    datePicker.topAnchor.constraintEqualToAnchor(
        alertController.view.topAnchor,
        constant = 10.0
    ).active = true
    datePicker.widthAnchor.constraintEqualToAnchor(
        alertController.view.widthAnchor,
        constant = -20.0
    ).active = true

    alertController.addAction(
        UIAlertAction.actionWithTitle(
            title = "Done",
            style = UIAlertActionStyleDefault
        ) { _ ->
            val formatter = NSDateFormatter().apply {
                dateFormat = "dd-MM-yyyy"
            }
            val selectedDate = formatter.stringFromDate(datePicker.date)
            onDatePicked(selectedDate)
        }
    )

    // Present the alert
    UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
        alertController,
        animated = true,
        completion = null
    )
}
```

## Desktop Date Picker
```kotlin
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
```

## Contributing

Contributions are welcome! Please follow these steps:

- Fork the repository.
- Create a new branch (git checkout -b feature-branch).
- Commit your changes (git commit -m 'Add some feature').
- Push to the branch (git push origin feature-branch).
- Open a pull request.

## Contact

For any inquiries, please contact waqaswaseem679@gmail.com.
