@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
@file:JsModule("mocha")

package mocha.mocha

import js.errors.JsError
import kotlin.internal.LowPriorityInOverloadResolution

/**
 * Initialize a new `Test` with the given `title` and callback `fn`.
 *
 * See https://mochajs.org/api/Test.html
 */
external class Test : Runnable {
  constructor(title: String, fn: () -> Unit = definedExternally)

  @LowPriorityInOverloadResolution
  constructor(title: String, syncFn: Func = definedExternally)

  @LowPriorityInOverloadResolution
  constructor(title: String, asyncFn: AsyncFunc = definedExternally)

  @JsString("test")
  var type: String
  var speed: TestSpeed? // added by reporters
  var err: JsError? // added by reporters

  fun clone(): Test
}
