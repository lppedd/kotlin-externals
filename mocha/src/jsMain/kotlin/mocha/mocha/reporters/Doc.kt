@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `Doc` reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.Doc.html
 */
external class Doc : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
