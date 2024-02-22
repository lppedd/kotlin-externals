@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `JSONStream` test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.JSONStream.html
 */
external class JSONStream : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
