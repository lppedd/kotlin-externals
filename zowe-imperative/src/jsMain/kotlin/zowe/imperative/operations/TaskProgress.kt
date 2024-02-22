@file:JsModule("@zowe/imperative")

package zowe.imperative.operations

/**
 * Constants and utilities used in tracking status of a running task
 */
external class TaskProgress {
  companion object {
    @JsInt(0)
    val ZERO_PERCENT: Int

    @JsInt(10)
    val TEN_PERCENT: Int

    @JsInt(20)
    val TWENTY_PERCENT: Int

    @JsInt(30)
    val THIRTY_PERCENT: Int

    @JsInt(40)
    val FOURTY_PERCENT: Int

    @JsInt(50)
    val FIFTY_PERCENT: Int

    @JsInt(60)
    val SIXTY_PERCENT: Int

    @JsInt(70)
    val SEVENTY_PERCENT: Int

    @JsInt(80)
    val EIGHTY_PERCENT: Int

    @JsInt(90)
    val NINETY_PERCENT: Int

    @JsInt(100)
    val ONE_HUNDRED_PERCENT: Int
  }
}
