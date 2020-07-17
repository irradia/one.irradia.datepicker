package one.irradia.datepicker.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.RelativeLayout
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat

/**
 * A trivial three-part date picker.
 */

class DatePicker3P : RelativeLayout {

  private val root: View
  private val year: NumberPicker
  private val month: NumberPicker
  private val day: NumberPicker

  /**
   * Construct a date picker.
   */

  constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    viewInflation: (Context, Int, ViewGroup) -> View
  ) : super(context, attrs, defStyleAttr) {
    this.root = viewInflation.invoke(context, R.layout.date_picker, this)
    this.year = this.root.findViewById(R.id.date_picker_year)
    this.month = this.root.findViewById(R.id.date_picker_month)
    this.day = this.root.findViewById(R.id.date_picker_day)
    this.init()
  }

  /**
   * Construct a date picker.
   */

  constructor(
    context: Context,
    attrs: AttributeSet?
  ) : this(context, attrs, 0, { c, i, v -> View.inflate(c, i, v) })

  /**
   * Construct a date picker.
   */

  constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
  ) : this(context, attrs, defStyleAttr, { c, i, v -> View.inflate(c, i, v) })

  /**
   * The date value.
   *
   * @param date The new date value
   */

  var date: LocalDate
    get() =
      LocalDate(this.year.value, this.month.value, this.day.value)
    set(date) {
      this.year.value = date.year
      this.month.value = date.monthOfYear
      this.day.value = date.dayOfMonth
    }

  /**
   * Set the lower and upper bound for the date picker.
   *
   * @param lower The lower bound
   * @param upper The upper bound
   */

  fun setRangeLimits(
    lower: LocalDate,
    upper: LocalDate
  ) {
    require(lower <= upper) {
      String.format("Date %s must be before %s", lower, upper)
    }

    this.year.minValue = lower.year
    this.year.maxValue = upper.year
    val yearNow = this.year.value
    if (yearNow < lower.year) {
      this.year.value = lower.year
    }
    if (yearNow > upper.year) {
      this.year.value = upper.year
    }
    this.month.minValue = lower.monthOfYear
    this.month.maxValue = upper.monthOfYear
    val monthNow = this.month.value
    if (monthNow < lower.year) {
      this.month.value = lower.monthOfYear
    }
    if (monthNow > upper.year) {
      this.month.value = upper.monthOfYear
    }
    this.setMaximumDayValue()
  }

  private fun init() {
    val date = LocalDate.now()
    this.year.minValue = 1800
    this.year.maxValue = 9999
    this.year.value = date.year - 18
    this.month.minValue = 1
    this.month.maxValue = 12
    this.month.value = date.monthOfYear
    this.month.displayedValues = this.calculateMonthNames()
    this.day.minValue = 1
    this.setMaximumDayValue()
    this.day.value = date.dayOfMonth
    this.month.setOnValueChangedListener { _: NumberPicker?, _: Int, _: Int ->
      this.setMaximumDayValue()
    }
  }

  private fun calculateMonthNames(): Array<String?> {
    val values = arrayOfNulls<String>(12)
    val formatter = DateTimeFormat.forPattern("MMM")
    for (month in 0..11) {
      val date = LocalDate(2000, month + 1, 1)
      values[month] = formatter.print(date)
    }
    return values
  }

  private fun setMaximumDayValue() {
    val date = LocalDate(this.year.value, this.month.value, 1)
    val max = date.dayOfMonth().maximumValue
    this.day.maxValue = max
    this.day.value = Math.min(this.day.value, max)
  }
}
