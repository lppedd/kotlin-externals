@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `NyanCat` test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.Nyan.html
 */
external class Nyan : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
