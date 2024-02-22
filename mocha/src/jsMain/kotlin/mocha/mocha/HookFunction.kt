package mocha.mocha

external interface HookFunction {
  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given callback `fn`. The name of the
   * function is used as the name of the hook.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(fn: Func)

  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given callback `fn`. The name of the
   * function is used as the name of the hook.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(fn: AsyncFunc)

  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given `title` and callback `fn`.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(
    name: String,
    fn: Func = definedExternally,
  )

  /**
   * [bdd, qunit, tdd] Describe a "hook" to execute the given `title` and callback `fn`.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(
    name: String,
    fn: AsyncFunc = definedExternally,
  )
}
