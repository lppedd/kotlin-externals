@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package mocha.mocha

import kotlin.internal.LowPriorityInOverloadResolution

external interface HookFunction {
  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given callback `fn`. The name of the
   * function is used as the name of the hook.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(fn: () -> Unit)

  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given callback `fn`. The name of the
   * function is used as the name of the hook.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(syncFn: Func)

  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given callback `fn`. The name of the
   * function is used as the name of the hook.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(asyncFn: AsyncFunc)

  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given `title` and callback `fn`.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(
    name: String,
    fn: () -> Unit = definedExternally,
  )

  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given `title` and callback `fn`.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(
    name: String,
    syncFn: Func = definedExternally,
  )

  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given `title` and callback `fn`.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  @LowPriorityInOverloadResolution
  operator fun invoke(
    name: String,
    asyncFn: AsyncFunc = definedExternally,
  )
}
