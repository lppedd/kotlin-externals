@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `Spec` test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.Spec.html
 */
external class Spec : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
