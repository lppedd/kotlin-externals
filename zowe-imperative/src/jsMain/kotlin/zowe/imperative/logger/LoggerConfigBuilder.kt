@file:JsModule("@zowe/imperative")

package zowe.imperative.logger

import zowe.imperative.logger.doc.IConfigLogging

external class LoggerConfigBuilder {
  companion object {
    @JsString("en")
    val DEFAULT_LANG: String

    @JsString("console")
    val DEFAULT_LOG_TYPE_CONSOLE: String

    @JsString("pattern")
    val DEFAULT_LOG_TYPE_PAT: String

    @JsString("[%d{yyyy/MM/dd} %d{hh:mm:ss.SSS}] [%p] %m")
    val DEFAULT_LOG_LAYOUT: String
    val DEFAULT_COLOR_LAYOUT: String

    @JsString("fileSync")
    val DEFAULT_LOG_TYPE_FILE_SYNC: String

    @JsString("NONE")
    val DEFAULT_BACKEND: String

    @JsString("default")
    val DEFAULT: String
    val DEFAULT_LOG_DIR: String
    val DEFAULT_LOG_FILE_DIR: String

    @JsString(".log")
    val DEFAULT_LOG_FILE_EXT: String

    @JsInt(10000000)
    val DEFAULT_LOG_FILE_MAX_SIZE: Int

    @JsInt(5)
    val DEFAULT_LOG_FILE_BACKUPS: Int

    /**
     * Build a fully qualified directory to a log file - defaults to the users home directory -
     * Imperative does NOT use this as the home is set by the CLI configuration document.
     *
     * @param name name of the file to append to fully qualified directory
     */
    fun buildFullLogFile(name: String): String

    /**
     * Returns the constant values defined within the LoggerConfigBuilder for this config object
     *
     * @return default object built
     */
    fun getDefaultIConfigLogging(): IConfigLogging

    /**
     * Returns the constant values defined within the LoggerConfigBuilder for this config object
     *
     * @return default object built
     */
    fun addConsoleAppender(
      config: IConfigLogging,
      key: String,
      categoryName: String = definedExternally,
      logLevel: String = definedExternally,
    ): IConfigLogging

    /**
     * Returns the constant values defined within the LoggerConfigBuilder for this config object
     *
     * @return default object built
     */
    fun addFileAppender(
      config: IConfigLogging,
      key: String,
      categoryName: String = definedExternally,
      filename: String = definedExternally,
      logLevel: String = definedExternally,
    ): IConfigLogging

    /**
     * Returns the log file name that will be used
     *
     * @return the default file name for the log file
     */
    fun getDefaultFileName(name: String): String

    /**
     * Returns the log level that will be used if not overridden
     *
     * @return the default log level
     */
    fun getDefaultLogLevel(): String
  }
}
