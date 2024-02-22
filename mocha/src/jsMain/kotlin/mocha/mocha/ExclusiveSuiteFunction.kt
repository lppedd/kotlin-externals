package mocha.mocha

external interface ExclusiveSuiteFunction {
  /**
   * [qunit] Describe a "suite" with the given `title`. Indicates this suite should be executed
   * exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(title: String): Suite

  /**
   * [bdd, tdd] Describe a "suite" with the given `title` and callback `fn` containing
   * nested suites. Indicates this suite should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(title: String, fn: (/* this: Suite, */) -> Unit): Suite
}
