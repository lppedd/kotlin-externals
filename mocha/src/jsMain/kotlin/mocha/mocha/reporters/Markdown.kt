@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner

/**
 * Initialize a new `Markdown` test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.Markdown.html
 */
external class Markdown : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)
}
