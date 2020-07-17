package one.irradia.datepicker.tests

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import one.irradia.datepicker.views.DatePicker3P
import one.irradia.datepicker.views.R
import org.joda.time.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito
import org.slf4j.LoggerFactory

class DatePicker3PTest {

  private val logger = LoggerFactory.getLogger(DatePicker3PTest::class.java)

  @JvmField
  @Rule
  val expectedException = ExpectedException.none()

  private lateinit var context: Context
  private lateinit var inflated: View
  private lateinit var viewDay: NumberPicker
  private lateinit var viewMonth: NumberPicker
  private lateinit var viewYear: NumberPicker
  private var maxDay: Int = Integer.MIN_VALUE
  private var maxMonth: Int = Integer.MIN_VALUE
  private var maxYear: Int = Integer.MIN_VALUE
  private var minDay: Int = Integer.MAX_VALUE
  private var minMonth: Int = Integer.MAX_VALUE
  private var minYear: Int = Integer.MAX_VALUE
  private val valDefault = LocalDate.parse("2000-01-01")
  private var valDay: Int = this.valDefault.dayOfMonth
  private var valMonth: Int = this.valDefault.monthOfYear
  private var valYear: Int = this.valDefault.year

  @Before
  fun setup() {
    this.context =
      Mockito.mock(Context::class.java)
    this.inflated =
      Mockito.mock(View::class.java)
    this.viewYear =
      Mockito.mock(NumberPicker::class.java)
    this.viewMonth =
      Mockito.mock(NumberPicker::class.java)
    this.viewDay =
      Mockito.mock(NumberPicker::class.java)

    Mockito.`when`(this.inflated.findViewById<NumberPicker>(R.id.date_picker_year))
      .thenReturn(this.viewYear)
    Mockito.`when`(this.inflated.findViewById<NumberPicker>(R.id.date_picker_month))
      .thenReturn(this.viewMonth)
    Mockito.`when`(this.inflated.findViewById<NumberPicker>(R.id.date_picker_day))
      .thenReturn(this.viewDay)

    Mockito.`when`(this.viewYear.value)
      .thenReturn(this.valYear)
    Mockito.`when`(this.viewMonth.value)
      .thenReturn(this.valMonth)
    Mockito.`when`(this.viewDay.value)
      .thenReturn(this.valDay)

    Mockito.doAnswer { invocation ->
      this.logger.debug("valYear ${this.valYear} <- ${invocation.getArgument(0) as Int}")
      this.valYear = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewYear).value = Mockito.anyInt()
    Mockito.doAnswer { invocation ->
      this.logger.debug("valMonth ${this.valMonth} <- ${invocation.getArgument(0) as Int}")
      this.valMonth = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewMonth).value = Mockito.anyInt()
    Mockito.doAnswer { invocation ->
      this.logger.debug("valDay ${this.valDay} <- ${invocation.getArgument(0) as Int}")
      this.valDay = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewDay).value = Mockito.anyInt()

    Mockito.`when`(this.viewYear.minValue)
      .thenReturn(this.minYear)
    Mockito.`when`(this.viewMonth.minValue)
      .thenReturn(this.minMonth)
    Mockito.`when`(this.viewDay.minValue)
      .thenReturn(this.minDay)

    Mockito.doAnswer { invocation ->
      this.logger.debug("minYear ${this.minYear} <- ${invocation.getArgument(0) as Int}")
      this.minYear = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewYear).minValue = Mockito.anyInt()
    Mockito.doAnswer { invocation ->
      this.logger.debug("minMonth ${this.minMonth} <- ${invocation.getArgument(0) as Int}")
      this.minMonth = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewMonth).minValue = Mockito.anyInt()
    Mockito.doAnswer { invocation ->
      this.logger.debug("minDay ${this.minDay} <- ${invocation.getArgument(0) as Int}")
      this.minDay = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewDay).minValue = Mockito.anyInt()

    Mockito.`when`(this.viewYear.maxValue)
      .thenReturn(this.maxYear)
    Mockito.`when`(this.viewMonth.maxValue)
      .thenReturn(this.maxMonth)
    Mockito.`when`(this.viewDay.maxValue)
      .thenReturn(this.maxDay)

    Mockito.doAnswer { invocation ->
      this.logger.debug("maxYear ${this.maxYear} <- ${invocation.getArgument(0) as Int}")
      this.maxYear = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewYear).maxValue = Mockito.anyInt()
    Mockito.doAnswer { invocation ->
      this.logger.debug("maxMonth ${this.maxMonth} <- ${invocation.getArgument(0) as Int}")
      this.maxMonth = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewMonth).maxValue = Mockito.anyInt()
    Mockito.doAnswer { invocation ->
      this.logger.debug("maxDay ${this.maxDay} <- ${invocation.getArgument(0) as Int}")
      this.maxDay = invocation.getArgument(0) as Int
      null
    }.`when`(this.viewDay).maxValue = Mockito.anyInt()
  }

  private fun inflate(
    context: Context,
    layout: Int,
    group: ViewGroup
  ): View {
    return this.inflated
  }

  @Test
  fun testCreate() {
    val picker = DatePicker3P(this.context, null, 0, this::inflate)

    val dateExpected = this.valDefault
    val dateReceived = picker.date
    assertEquals(dateExpected, dateReceived)
  }

  @Test
  fun testSetLimitInvalid0() {
    val picker = DatePicker3P(this.context, null, 0, this::inflate)

    this.expectedException.expect(IllegalArgumentException::class.java)
    picker.setRangeLimits(
      LocalDate.parse("2008-01-01"),
      LocalDate.parse("2007-01-01")
    )
  }

  @Test
  fun testSetLimitValid0() {
    val picker = DatePicker3P(this.context, null, 0, this::inflate)

    picker.setRangeLimits(
      LocalDate.parse("1999-02-03"),
      LocalDate.parse("2001-04-05")
    )

    assertEquals(1999, this.minYear)
    assertEquals(2, this.minMonth)
    assertEquals(1, this.minDay)
    assertEquals(2001, this.maxYear)
    assertEquals(4, this.maxMonth)
    assertEquals(31, this.maxDay)
  }

  @Test
  fun testSetValid0() {
    val picker = DatePicker3P(this.context, null, 0, this::inflate)

    picker.date = LocalDate.parse("2010-03-14")

    assertEquals(2010, this.valYear)
    assertEquals(3, this.valMonth)
    assertEquals(14, this.valDay)
  }
}
