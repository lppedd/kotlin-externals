@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities

/**
 * Common function that returns npm command as a string.
 *
 * @return command with npm path
 */
external fun findNpmOnPath(): String
