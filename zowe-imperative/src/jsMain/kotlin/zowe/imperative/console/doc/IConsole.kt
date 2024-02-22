package zowe.imperative.console.doc

external interface IConsole<T> {
  var level: String

  fun trace(
    message: String,
    vararg args: Any?,
  ): T

  fun debug(
    message: String,
    vararg args: Any?,
  ): T

  fun info(
    message: String,
    vararg args: Any?,
  ): T

  fun warn(
    message: String,
    vararg args: Any?,
  ): T

  fun error(
    message: String,
    vararg args: Any?,
  ): T

  fun fatal(
    message: String,
    vararg args: Any?,
  ): T
}
