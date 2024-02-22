@file:JsModule("@zowe/imperative")

package zowe.imperative.console

import zowe.imperative.console.doc.IConsole

/**
 * Generic logging-use class for writing info to the console if we have log4js failures or are
 * unable to initialize otherwise.
 *
 * This class supports most of the methods / accessors log4js uses.
 */
external class Console : IConsole<String> {
  constructor(mLevel: String = definedExternally)

  fun addContext(
    key: String,
    value: Any?,
  )

  fun removeContext(key: String)

  fun clearContext()

  fun isLevelEnabled(): Boolean

  fun isTraceEnabled(): Boolean

  fun isDebugEnabled(): Boolean

  fun isInfoEnabled(): Boolean

  fun isWarnEnabled(): Boolean

  fun isErrorEnabled(): Boolean

  fun isFatalEnabled(): Boolean

  fun isFormatEnabled(): Boolean

  override fun info(
    message: String,
    vararg args: Any?,
  ): String

  override fun trace(
    message: String,
    vararg args: Any?,
  ): String

  override fun debug(
    message: String,
    vararg args: Any?,
  ): String

  override fun warn(
    message: String,
    vararg args: Any?,
  ): String

  override fun error(
    message: String,
    vararg args: Any?,
  ): String

  override fun fatal(
    message: String,
    vararg args: Any?,
  ): String

  override var level: String
  var prefix: Boolean
  var color: Boolean
  var on: Boolean

  companion object {
    val LEVELS: Array<String>

    @JsString("warn")
    val LEVEL_DEFAULT: String

    fun getConsole(category: String): Console

    fun isValidLevel(level: String): Boolean

    fun validateLevel(level: String)
  }
}
