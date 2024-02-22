@file:JsModule("mocha")

package mocha.mocha.reporters

import mocha.HTMLLIElement
import mocha.mocha.MochaOptions
import mocha.mocha.Runner
import mocha.mocha.Suite
import mocha.mocha.Test

/**
 * Initialize a new `HTML` reporter.
 *
 * - _This reporter cannot be used on the console._
 *
 * See https://mochajs.org/api/Mocha.reporters.HTML.html
 */
external class HTML : Base {
  constructor(runner: Runner, options: MochaOptions<Any?> = definedExternally)

  /**
   * Provide suite URL.
   *
   * See https://mochajs.org/api/Mocha.reporters.HTML.html#suiteURL
   */
  fun suiteURL(suite: Suite): String

  /**
   * Provide test URL.
   *
   * See https://mochajs.org/api/Mocha.reporters.HTML.html#testURL
   */
  fun testURL(test: Test): String

  /**
   * Adds code toggle functionality for the provided test's list element.
   *
   * See https://mochajs.org/api/Mocha.reporters.HTML.html#addCodeToggle
   */
  fun addCodeToggle(
    el: HTMLLIElement,
    contents: String,
  )
}
