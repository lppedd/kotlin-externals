@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.Runner
import mocha.mocha.reporters.progress.MochaOptions

/**
 * Initialize a new `Progress` bar test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.Progress.html
 */
external class Progress : Base {
  constructor(runner: Runner, options: MochaOptions = definedExternally)
}
