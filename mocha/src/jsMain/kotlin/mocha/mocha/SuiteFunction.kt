package mocha.mocha

external interface SuiteFunction {
  /**
   * [qunit] Describe a "suite" with the given `title`.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(title: String): Suite

  /**
   * [bdd, tdd] Describe a "suite" with the given `title` and callback `fn` containing
   * nested suites.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  @seskar.js.JsNative
  operator fun invoke(title: String, fn: (/* this: Suite, */) -> Unit): Suite

  /**
   * [bdd, tdd, qunit] Indicates this suite should be executed exclusively.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var only: ExclusiveSuiteFunction

  /**
   * [bdd, tdd] Indicates this suite should not be executed.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var skip: PendingSuiteFunction
}
