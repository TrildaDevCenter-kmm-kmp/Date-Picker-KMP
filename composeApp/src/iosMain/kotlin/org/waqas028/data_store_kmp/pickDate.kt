package org.waqas028.data_store_kmp

import platform.Foundation.NSDateFormatter
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication
import platform.UIKit.UIDatePicker
import platform.UIKit.UIDatePickerMode
import platform.UIKit.UIDatePickerStyle

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

actual fun pickTime(context: Any?, onTimePicked: (String) -> Unit) {
    val timePicker = UIDatePicker().apply {
        datePickerMode = UIDatePickerMode.UIDatePickerModeTime
        preferredDatePickerStyle =
            UIDatePickerStyle.UIDatePickerStyleWheels // Direct wheel-style picker
        translatesAutoresizingMaskIntoConstraints = false
    }

    val alertController = UIAlertController.alertControllerWithTitle(
        title = "Pick a Time",
        message = "\n\n\n\n\n\n\n",
        preferredStyle = UIAlertControllerStyleAlert
    )

    alertController.view.addSubview(timePicker)

    // Set constraints for TimePicker within the AlertController
    timePicker.centerXAnchor.constraintEqualToAnchor(alertController.view.centerXAnchor).active =
        true
    timePicker.topAnchor.constraintEqualToAnchor(
        alertController.view.topAnchor,
        constant = 10.0
    ).active = true
    timePicker.widthAnchor.constraintEqualToAnchor(
        alertController.view.widthAnchor,
        constant = 0.0
    ).active = true

    // Add a "Done" button
    alertController.addAction(
        UIAlertAction.actionWithTitle(
            title = "Done",
            style = UIAlertActionStyleDefault
        ) { _ ->
            val formatter = NSDateFormatter().apply {
                dateFormat = "HH:mm"
            }
            val selectedTime = formatter.stringFromDate(timePicker.date)
            onTimePicked(selectedTime)
        }
    )

    // Present the alert
    UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
        alertController,
        animated = true,
        completion = null
    )
}