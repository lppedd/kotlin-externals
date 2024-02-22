package zowe.sdk.zos.files.doc

/**
 * The ZosFiles API response.
 */
external interface IZosFilesResponse<T : Any?> {
  /**
   * Indicates the success of retrieving specified file information.
   */
  var success: Boolean

  /**
   * Relevant information about the performed file operation.
   */
  var commandResponse: String

  /**
   * The api response object, housing any returned header information.
   */
  var apiResponse: T

  /**
   * The error message text.
   * If not defined, the command response will be used.
   */
  var errorMessage: String?
}
