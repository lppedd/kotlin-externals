@file:JsModule("mocha")

package mocha.mocha

import js.errors.JsError

/**
 * Initialize a new `Test` with the given `title` and callback `fn`.
 *
 * See https://mochajs.org/api/Test.html
 */
external class Test : Runnable {
  constructor(title: String, fn: Func = definedExternally)
  constructor(title: String, fn: AsyncFunc = definedExternally)

  @JsString("test")
  var type: String
  var speed: TestSpeed? // added by reporters
  var err: JsError? // added by reporters

  fun clone(): Test
}
