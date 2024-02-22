@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

/**
 * Adds padding in case you want a longer string.
 *
 * @param str string to add the padding to
 * @param len final length of the padded string
 * @param padChar Padding character
 * @return Padded string
 */
external fun padLeft(
  str: String,
  len: Int,
  padChar: String = definedExternally,
): String
