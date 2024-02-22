@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.api

import zowe.imperative.cmd.profiles.CliProfileManager
import zowe.imperative.imperative.api.doc.IImperativeApi
import zowe.imperative.imperative.doc.IImperativeConfig
import zowe.imperative.logger.Logger

external class ImperativeApi {
  constructor(mApis: IImperativeApi, mConfig: IImperativeConfig, mHome: String)

  /**
   * Index signature for accessing Imperative api via dictionary [] notation.
   */
  @seskar.js.JsNative
  operator fun get(key: String): Any?

  /**
   * Index signature for accessing Imperative api via dictionary [] notation.
   */
  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )

  /**
   * Returns the imperative logger API object
   *
   * @return The imperative logger api object.
   */
  val imperativeLogger: Logger

  /**
   * Returns an imperative app's logger API object
   *
   * @return The imperative app's logger api object.
   */
  val appLogger: Logger

  /**
   * Retrieve a named custom logger that has been configured
   *
   * @param name the name of the custom logger
   * @return the configured logger, if it exists
   */
  fun additionalLogger(name: String): Logger

  /**
   * Register a logger with the Imperative API Mostly used internally in Imperative
   *
   * @param name the name of the logger to register
   * @param logger the logger to store
   */
  fun addAdditionalLogger(
    name: String,
    logger: Logger,
  )

  /**
   * Return an instance of a profile manager for a given profile type.
   * See ProfileManager.ts for more details
   */
  fun profileManager(type: String): CliProfileManager
}
