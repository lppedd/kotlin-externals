@file:JsModule("@zowe/imperative")

package zowe.imperative.logger

import zowe.imperative.console.Console
import zowe.imperative.error.ImperativeError
import zowe.imperative.logger.doc.IConfigLogging

/**
 * Note(Kelosky): it seems from the log4js doc that you only get a single instance of log4js per
 * category. To reconfigure, you should "shutdown" logger.
 */
external class Logger {
  // TODO(Edoardo): types for log4js
  constructor(mJsLogger: Any /* log4js.Logger */, category: String = definedExternally)

  constructor(mJsLogger: Console, category: String = definedExternally)

  /**
   * Log a message at the "trace" level Example: 'Entering cheese testing'
   *
   * @param message printf style template string, or a plain string message
   * @param args printf style args
   */
  fun trace(
    message: String,
    vararg args: Any?,
  ): String

  /**
   * Log a message at the "debug" level Example: 'Got cheese'
   *
   * @param message printf or mustache style template string, or a plain string message
   * @param args printf or mustache style args
   */
  fun debug(
    message: String,
    vararg args: Any?,
  ): String

  /**
   * Log a message at the "info" level Example: 'Cheese is Gouda'
   *
   * @param message printf or mustache style template string, or a plain string message
   * @param args printf or mustache style args
   */
  fun info(
    message: String,
    vararg args: Any?,
  ): String

  /**
   * Log a message at the "warn" level Example: 'Cheese is quite smelly.'
   *
   * @param message printf or mustache style template string, or a plain string message
   * @param args printf or mustache style args
   */
  fun warn(
    message: String,
    vararg args: Any?,
  ): String

  /**
   * Log a message at the "error" level Example: 'Cheese is too ripe!'
   *
   * @param message printf or mustache style template string, or a plain string message
   * @param args printf or mustache style args
   */
  fun error(
    message: String,
    vararg args: Any?,
  ): String

  /**
   * Log a message at the "fatal" level Example: 'Cheese was breeding ground for listeria.'
   *
   * @param message printf or mustache style template string, or a plain string message
   * @param args printf or mustache style args
   */
  fun fatal(
    message: String,
    vararg args: Any?,
  ): String

  /**
   * Log a message without CallerFileAndLineTag Example: 'Cheese that is plain'
   *
   * @param message printf or mustache style template string, or a plain string message
   * @param args printf or mustache style args
   */
  fun simple(
    message: String,
    vararg args: Any?,
  ): String

  /**
   * Log an Imperative error, including any optional fields if present
   *
   * @param err the error to log
   */
  fun logError(err: ImperativeError)

  /**
   * Allow for programmatic adjustments to the logger
   */
  var level: String

  companion object {
    @JsString("imperative")
    val DEFAULT_IMPERATIVE_NAME: String

    @JsString("app")
    val DEFAULT_APP_NAME: String

    @JsString("console")
    val DEFAULT_CONSOLE_NAME: String
    val DEFAULT_VALID_LOG_LEVELS: Array<String>

    /**
     * Get accessibility to logging service to invoke log calls, e.g
     * Logger.getLogger.info("important log info goes here");
     *
     * @param category category of logger to obtain
     * @return instance of logger set to our app's category
     */
    fun getLoggerCategory(category: String): Logger

    /**
     * Get accessibility to logging service to invoke log calls, e.g
     * Logger.getLogger.info("important log info goes here");
     *
     * @return instance of logger set to our app's category
     */
    fun getImperativeLogger(): Logger

    /**
     * Get log4js instance directed at our app's category.
     *
     * @return instance of logger set to our app's category
     */
    fun getAppLogger(): Logger

    fun setLogInMemory(
      status: Boolean,
      maxQueueSize: Int = definedExternally,
    )

    /**
     * Write all messages that was stored in memory to the input file.
     *
     * @param file destination file name
     */
    fun writeInMemoryMessages(file: String)

    /**
     * Test if the input level is a valid value for Log4js.
     *
     * @param testLevel input level to be tested
     * @return status if the input level is valid
     */
    fun isValidLevel(testLevel: String): Boolean

    /**
     * Return an instance to the console logger which applies TextUtils invoked through this Logger
     * class.
     *
     * Note(Kelosky): this is not the same as obtaining a new Console() directly, since we can make
     * use of the internationalization and other routines within this Logger class via this
     * implementation.
     *
     * @return instance of logger set to our app's category
     */
    fun getConsoleLogger(): Logger

    /**
     * Get an instance of logging and adjust for config if config is present; otherwise, use
     * defaults.
     */
    fun initLogger(loggingConfig: IConfigLogging): Logger
  }
}
