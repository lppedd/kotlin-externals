@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client

import zowe.imperative.error.ImperativeError
import zowe.imperative.error.doc.IImperativeErrorParms
import zowe.imperative.rest.client.doc.IRestClientError

external class RestClientError : ImperativeError {
  /**
   * Creates an instance of RestClientError.
   *
   * @param mDetails The IRestClientError details provided by the rest client.
   *   Contains "relevant" diagnostic information such as host/port/request details, etc.
   * @param parms Imperative error parameters.
   */
  constructor(mDetails: IRestClientError, parms: IImperativeErrorParms = definedExternally)

  @Suppress("VAR_TYPE_MISMATCH_ON_OVERRIDE")
  override var mDetails: IRestClientError

  /**
   * Accessor for IRestClientError error details.
   */
  override val details: IRestClientError
}
