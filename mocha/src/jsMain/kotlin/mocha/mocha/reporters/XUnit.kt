@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.mocha.Runner
import mocha.mocha.Test
import mocha.mocha.reporters.xunit.MochaOptions

/**
 * Initialize a new `XUnit` test reporter.
 *
 * See https://mochajs.org/api/Mocha.reporters.XUnit.html
 */
external class XUnit : Base {
  constructor(runner: Runner, options: MochaOptions = definedExternally)

  /**
   * Override done to close the stream (if it's a file).
   *
   * See https://mochajs.org/api/Mocha.reporters.XUnit.html#done
   */
  override fun done(
    failures: Int,
    fn: (failures: Int) -> Unit,
  )

  /**
   * Write out the given line.
   *
   * See https://mochajs.org/api/Mocha.reporters.XUnit.html#write
   */
  fun write(line: String)

  /**
   * Output tag for the given `test.`
   *
   * See https://mochajs.org/api/Mocha.reporters.XUnit.html#test
   */
  fun test(test: Test)
}
