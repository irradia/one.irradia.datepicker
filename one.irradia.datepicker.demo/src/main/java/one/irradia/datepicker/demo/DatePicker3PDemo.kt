package one.irradia.datepicker.demo

import android.app.Activity
import android.os.Bundle
import one.irradia.datepicker.views.DatePicker3P
import org.joda.time.LocalDate

class DatePicker3PDemo : Activity() {

  private lateinit var picker: DatePicker3P
  private lateinit var pickerLimited: DatePicker3P

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    this.setTheme(R.style.Theme_AppCompat_Light_DarkActionBar)
    this.setContentView(R.layout.date_picker_demo)

    this.picker =
      this.findViewById(R.id.datePicker0)
    this.pickerLimited =
      this.findViewById(R.id.datePickerLimited)

    this.pickerLimited.setRangeLimits(
      LocalDate.parse("2001-02-03"),
      LocalDate.parse("2003-04-05")
    )
  }
}
