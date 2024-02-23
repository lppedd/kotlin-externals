@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package mocha.mocha

import kotlin.internal.LowPriorityInOverloadResolution

external interface TestFunction {
  /**
   * Describe a specification or test-case with the given callback `fn` acting as a thunk.
   * The name of the function is used as the name of the test.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(fn: Func): Test

  /**
   * Describe a specification or test-case with the given callback `fn` acting as a thunk.
   * The name of the function is used as the name of the test.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(fn: AsyncFunc): Test

  /**
   * Describe a specification or test-case with the given `title` and callback `fn` acting
   * as a thunk.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(
    title: String,
    fn: Func = definedExternally,
  ): Test

  /**
   * Describe a specification or test-case with the given `title` and callback `fn` acting
   * as a thunk.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(
    title: String,
    fn: AsyncFunc = definedExternally,
  ): Test

  /**
   * Indicates this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var only: ExclusiveTestFunction

  /**
   * Indicates this test should not be executed.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var skip: PendingTestFunction

  /**
   * Number of attempts to retry.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  fun retries(n: Int)
}
