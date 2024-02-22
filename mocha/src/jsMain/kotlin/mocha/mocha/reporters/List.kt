@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `List` test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.List.html
 */
external class List : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
