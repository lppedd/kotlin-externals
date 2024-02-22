package mocha

import mocha.mocha.Interface
import mocha.mocha.MochaOptions

external class BrowserMocha : Mocha {
  /**
   * Function to allow assertion libraries to throw errors directly into mocha.
   * This is useful when running tests in a browser because window.onerror will
   * only receive the 'message' attribute of the Error.
   *
   * - _Only supported in the browser._
   */
  fun throwError(err: Any?): Nothing

  /**
   * Setup mocha with the given settings options.
   *
   * - _Only supported in the browser._
   */
  fun setup(opts: Interface = definedExternally) // : this

  /**
   * Setup mocha with the given settings options.
   *
   * - _Only supported in the browser._
   */
  fun setup(opts: MochaOptions<Any?> = definedExternally) // : this
}
