@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

/**
 * Trims a given line based on the terminal's width. It also replaces tabs with spaces.
 *
 * @param str string to be trimmed
 * @return Trimmed string
 */
external fun trimLineToTerminalWidth(str: String): String
