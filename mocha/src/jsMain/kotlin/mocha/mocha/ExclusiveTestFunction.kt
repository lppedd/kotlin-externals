package mocha.mocha

external interface ExclusiveTestFunction {
  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given callback `fn`
   * acting as a thunk. The name of the function is used as the name of the test. Indicates
   * this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(fn: Func): Test

  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given callback `fn`
   * acting as a thunk. The name of the function is used as the name of the test. Indicates
   * this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(fn: AsyncFunc): Test

  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given `title` and
   * callback `fn` acting as a thunk. Indicates this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(
    title: String,
    fn: Func = definedExternally,
  ): Test

  /**
   * [bdd, tdd, qunit] Describe a specification or test-case with the given `title` and
   * callback `fn` acting as a thunk. Indicates this test should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(
    title: String,
    fn: AsyncFunc = definedExternally,
  ): Test
}
