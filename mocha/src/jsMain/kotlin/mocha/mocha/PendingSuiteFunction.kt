package mocha.mocha

import kotlin.ts.Union

/**
 * [bdd, tdd] Describe a "suite" with the given `title` and callback `fn` containing
 * nested suites. Indicates this suite should not be executed.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external interface PendingSuiteFunction {
  @seskar.js.JsNative
  operator fun invoke(title: String, fn: (/* this: Suite, */) -> Unit): Union<Suite, Unit> // Suite | void
}
