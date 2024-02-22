@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `Landing` reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.Landing.html
 */
external class Landing : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
