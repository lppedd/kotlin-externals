@file:JsModule("mocha")

package mocha

/**
 * Triggers root suite execution.
 *
 * - _Only available if flag --delay is passed into Mocha._
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#runWithSuite
 */
external fun run()
