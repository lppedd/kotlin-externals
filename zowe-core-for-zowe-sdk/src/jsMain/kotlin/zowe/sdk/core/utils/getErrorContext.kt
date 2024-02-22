@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

/**
 * Produces formatted context of a given error in the specified location of the contents
 *
 * NOTE:
 *      The lineIndex is zero-based indexed
 *
 * @param content Indicates the contents or the file path to the file containing the contents to get the error from
 * @param lineIndex Zero-based indexed location of the error to be printed
 * @return Few lines (separated by \n) containing error context
 */
external fun getErrorContext(
  content: String,
  lineIndex: Int,
): String

external fun getErrorContext(
  content: Array<String>,
  lineIndex: Int,
): String
