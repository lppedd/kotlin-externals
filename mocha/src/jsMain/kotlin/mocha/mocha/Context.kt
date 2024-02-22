@file:JsModule("mocha")

package mocha.mocha

/**
 * Test context
 *
 * See https://mochajs.org/api/module-Context.html#~Context
 */
external class Context {
  var test: Runnable?
  var currentTest: Test?

  /**
   * Get the context `Runnable`.
   */
  fun runnable(): Runnable

  /**
   * Set the context `Runnable`.
   */
  fun runnable(runnable: Runnable) // this

  /**
   * Get test timeout.
   */
  fun timeout(): Int

  /**
   * Set test timeout.
   */
  fun timeout(ms: String) // this

  fun timeout(ms: Int) // this

  /**
   * Get test slowness threshold.
   */
  fun slow(): Int

  /**
   * Set test slowness threshold.
   */
  fun slow(ms: String) // this

  fun slow(ms: Int) // this

  /**
   * Mark a test as skipped.
   */
  fun skip(): Nothing

  /**
   * Get the number of allowed retries on failed tests.
   */
  fun retries(): Int

  /**
   * Set the number of allowed retries on failed tests.
   */
  fun retries(n: Int) // this

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
