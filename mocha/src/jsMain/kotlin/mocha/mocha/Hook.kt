@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
@file:JsModule("mocha")

package mocha.mocha

import kotlin.internal.LowPriorityInOverloadResolution

/**
 * Initialize a new `Hook` with the given `title` and callback `fn`
 *
 * See https://mochajs.org/api/Hook.html
 */
external class Hook : Runnable {
  constructor(title: String, fn: () -> Unit = definedExternally)

  @LowPriorityInOverloadResolution
  constructor(title: String, syncFn: Func = definedExternally)

  @LowPriorityInOverloadResolution
  constructor(title: String, asyncFn: AsyncFunc = definedExternally)

  @JsString("hook")
  var type: String
  var originalTitle: String? // added by Runner

  /**
   * Get the test `err`.
   *
   * See https://mochajs.org/api/Hook.html#error
   */
  fun error(): Any?

  /**
   * Set the test `err`.
   *
   * See https://mochajs.org/api/Hook.html#error
   */
  fun error(err: Any?)
}
