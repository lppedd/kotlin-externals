@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.report.env

/**
 * The tests to check for problems that we run for environmental items. One ItemId can have multiple
 * entries in the array, to check for different problems. When the probExpr is true, we have a
 * problem, and we print the probMsg.
 */
external val probTests: Array<IProbTest>
