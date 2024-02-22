package zowe.sdk.zos.tso.doc

import zowe.imperative.error.ImperativeError
import zowe.sdk.zos.tso.doc.zosmf.IZosmfPingResponse

external interface IPingResponse {
  /**
   * True if the command was issued and the responses were collected.
   */
  var success: Boolean

  /**
   * Response from z/OSMF to ping rest call
   */
  var zosmfPingResponse: IZosmfPingResponse

  /**
   * If an error occurs, returns the ImperativeError, which contains cause error.
   */
  var failureResponse: ImperativeError?

  /**
   * Servlet key from IZosmfPingResponse
   */
  var servletKey: String
}
