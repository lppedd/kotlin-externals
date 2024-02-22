package zowe.sdk.console.doc.zosmf

/**
 * z/OSMF synchronous console command response messages. See the z/OSMF REST API publication for complete details.
 */
external interface IZosmfCollectResponse {
  /**
   * Command response text.
   */
  var `cmd-response`: String

  /**
   * True if the solicited keyword requested is present.
   */
  var `sol-key-detected`: Boolean?
}
