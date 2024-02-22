@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `TAP` test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.TAP.html
 */
external class TAP : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
