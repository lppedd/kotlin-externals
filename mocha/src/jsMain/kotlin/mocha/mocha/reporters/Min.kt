@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `Min` minimal test reporter (best used with --watch).
 *
 * See https://mochajs.org/api/Mocha.reporters.Min.html
 */
external class Min : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
