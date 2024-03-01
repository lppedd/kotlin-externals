@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package mocha.mocha

import kotlin.internal.LowPriorityInOverloadResolution

external interface ExclusiveTestFunction {
  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given callback `fn`
   * acting as a thunk. The name of the function is used as the name of the test. Indicates
   * this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(fn: () -> Unit): Test

  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given callback `fn`
   * acting as a thunk. The name of the function is used as the name of the test. Indicates
   * this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(syncFn: Func): Test

  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given callback `fn`
   * acting as a thunk. The name of the function is used as the name of the test. Indicates
   * this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(asyncFn: AsyncFunc): Test

  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given `title` and
   * callback `fn` acting as a thunk. Indicates this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(
    title: String,
    fn: () -> Unit = definedExternally,
  ): Test

  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given `title` and
   * callback `fn` acting as a thunk. Indicates this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(
    title: String,
    syncFn: Func = definedExternally,
  ): Test

  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given `title` and
   * callback `fn` acting as a thunk. Indicates this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(
    title: String,
    asyncFn: AsyncFunc = definedExternally,
  ): Test
}
