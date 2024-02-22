@file:JsModule("@zowe/imperative")

package zowe.imperative.logger

import zowe.imperative.logger.doc.IQueuedMessage

/**
 * LoggerManager is a singleton class used to contain logger information.
 */
external class LoggerManager {
  constructor()

  /**
   * The following flag is used to monitor if the Logger.initLogger function have been called to set
   * the configuration of log4js.
   */
  var isLoggerInit: Boolean

  /**
   * The following flag is used to control if the log message should be store in memory while log4js
   * have yet to be configured.
   */
  var logInMemory: Boolean

  /**
   * The following value is used to control the max number of messages allowed to be stored in
   * memory at all time.
   */
  var maxQueueSize: Int

  /**
   * This function returned an array that contain all of the messages.
   */
  val QueuedMessages: Array<IQueuedMessage>

  /**
   * This function is responsible for gathering all of the input parameters and store them in the
   * message queue array.
   *
   * New messages are to be stored at the top of the array instead of the bottom. This allow easy
   * removing message from array while looping the array.
   *
   * @param category logger category
   * @param method log method
   * @param message log message
   */
  fun queueMessage(
    category: String,
    method: String,
    message: String,
  )

  /**
   * Dump all of the log messages in memory to the specified file
   *
   * @param file log file
   */
  fun dumpQueuedMessages(file: String)

  companion object {
    val instance: LoggerManager
  }
}
