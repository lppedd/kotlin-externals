@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `JSON` reporter
 *
 * See https://mochajs.org/api/Mocha.reporters.JSON.html
 */
external class JSON : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
