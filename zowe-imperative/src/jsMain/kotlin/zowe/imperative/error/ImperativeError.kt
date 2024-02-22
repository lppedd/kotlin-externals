@file:JsModule("@zowe/imperative")

package zowe.imperative.error

import js.errors.JsError
import zowe.imperative.error.doc.IImperativeError
import zowe.imperative.error.doc.IImperativeErrorParms

open external class ImperativeError : JsError {
  /**
   * Construct the Imperative error object. Contains the defaults of the error and optionally
   * captures diagnostics and other information.
   *
   * @param mDetails the error details and text (stack, messages, etc.)
   * @param parms control parameters to indicate logging of node-report and more
   */
  constructor(mDetails: IImperativeError, parms: IImperativeErrorParms = definedExternally)

  open var mDetails: IImperativeError

  /**
   * Return causeErrors
   */
  val causeErrors: Any?

  /**
   * Return additionalDetails
   */
  val additionalDetails: String

  /**
   * Return IImperativeError object
   */
  open val details: IImperativeError

  /**
   * Return errorCode
   */
  val errorCode: String

  /**
   * Return whether the error dump should be suppressed
   */
  val suppressDump: Boolean

  /**
   * Return stack info
   */
  val stack: String

  /**
   * Accessor for the error message.
   */
  override val message: String
}
