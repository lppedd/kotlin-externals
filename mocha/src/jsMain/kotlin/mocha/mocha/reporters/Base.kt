@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.MochaOptions
import mocha.mocha.Runner
import mocha.mocha.Stats
import mocha.mocha.Test

/**
 * Initialize a new `Base` reporter.
 *
 * All other reporters generally inherit from this reporter, providing stats such as test duration,
 * number of tests passed / failed, etc.
 *
 * See https://mochajs.org/api/Mocha.reporters.Base.html
 */
open external class Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)

  /**
   * Test run statistics
   */
  var stats: Stats

  /**
   * Test failures
   */
  var failures: Array<Test>

  /**
   * The configured runner
   */
  var runner: Runner

  /**
   * Output common epilogue used by many of the bundled reporters.
   *
   * See https://mochajs.org/api/Mocha.reporters.Base.html#.Base#epilogue
   */
  fun epilogue()

  open fun done(
    failures: Int,
    fn: (failures: Int) -> Unit = definedExternally,
  )
}
