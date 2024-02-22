@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `Dot` matrix test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.Dot.html
 */
external class Dot : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
