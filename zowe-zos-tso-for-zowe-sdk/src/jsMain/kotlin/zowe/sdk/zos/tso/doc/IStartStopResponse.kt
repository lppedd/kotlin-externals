package zowe.sdk.zos.tso.doc

import zowe.imperative.error.ImperativeError
import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

external interface IStartStopResponse {
  /**
   * True if the command was issued and the responses were collected.
   */
  var success: Boolean

  /**
   * Response from z/OSMF to start rest call
   */
  var zosmfTsoResponse: IZosmfTsoResponse

  /**
   * If an error occurs, returns the ImperativeError, which contains cause error.
   */
  var failureResponse: ImperativeError?

  /**
   * Servlet key from IZosmfTsoResponse
   */
  var servletKey: String
}
