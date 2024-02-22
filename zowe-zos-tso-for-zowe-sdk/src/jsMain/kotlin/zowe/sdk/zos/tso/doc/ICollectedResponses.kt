package zowe.sdk.zos.tso.doc

import zowe.sdk.zos.tso.doc.zosmf.IZosmfTsoResponse

external interface ICollectedResponses {
  /**
   * z/OSMF synchronous most tso command response messages.
   */
  var tsos: Array<IZosmfTsoResponse>

  /**
   * Appended collected messages including READY prompt at the end.
   */
  var messages: String
}
