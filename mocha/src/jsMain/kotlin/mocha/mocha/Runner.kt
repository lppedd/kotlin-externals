@file:JsModule("mocha")

package mocha.mocha

import nodejs.EventEmitter
import kotlin.js.RegExp

/**
 * Initialize a `Runner` for the given `suite`.
 *
 * See https://mochajs.org/api/Mocha.Runner.html
 */
external class Runner : EventEmitter {
  /**
   * Initialize a `Runner` at the Root Suite, which represents a hierarchy of Suites and Tests.
   *
   * @param suite Root suite
   * @param optionsOrDelay Options. If boolean (deprecated), whether or not to delay execution of root suite until ready.
   */
  constructor(suite: Suite, optionsOrDelay: RunnerOptions = definedExternally)
  constructor(suite: Suite, optionsOrDelay: Boolean = definedExternally)

  var suite: Suite
  var started: Boolean
  var total: Int
  var failures: Int
  var asyncOnly: Boolean?
  var allowUncaught: Boolean?
  var fullStackTrace: Boolean?
  var forbidOnly: Boolean?
  var forbidPending: Boolean?
  var checkLeaks: Boolean?
  var test: Test?
  var currentRunnable: Runnable?
  var stats: Stats? // added by reporters

  /**
   * Removes all event handlers set during a run on this instance.
   * Remark: this does *not* clean/dispose the tests or suites themselves.
   *
   * See https://mochajs.org/api/runner#dispose
   */
  fun dispose()

  /**
   * Run tests with full titles matching `re`. Updates runner.total
   * with number of tests matched.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#.Runner#grep
   */
  fun grep(re: RegExp, invert: Boolean) // this

  /**
   * Returns the number of tests matching the grep search for the
   * given suite.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#.Runner#grepTotal
   */
  fun grepTotal(suite: Suite): Int

  /**
   * Gets the allowed globals.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#.Runner#globals
   */
  fun globals(): Array<String>

  /**
   * Allow the given `arr` of globals.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#.Runner#globals
   */
  fun globals(arr: js.array.ReadonlyArray<String>) // this

  /**
   * Run the root suite and invoke `fn(failures)` on completion.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#.Runner#run
   */
  fun run(fn: (failures: Int) -> Unit = definedExternally) // this

  /**
   * Cleanly abort execution.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#.Runner#abort
   */
  fun abort() // this

  /**
   * Handle uncaught exceptions.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#uncaught
   */
  fun uncaught(err: Any?)

  /**
   * Return a list of global properties.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#globalProps
   */
  fun globalProps(): Array<String>

  /**
   * Check for global variable leaks.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#checkGlobals
   */
  fun checkGlobals(test: Test)

  /**
   * Fail the given `test`.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#fail
   */
  fun fail(
    test: Test,
    err: Any?,
  )

  /**
   * Fail the given `hook` with `err`.
   *
   * Hook failures work in the following pattern:
   * - If bail, then exit
   * - Failed `before` hook skips all tests in a suite and subsuites,
   *   but jumps to corresponding `after` hook
   * - Failed `before each` hook skips remaining tests in a
   *   suite and jumps to corresponding `after each` hook,
   *   which is run only once
   * - Failed `after` hook does not alter
   *   execution order
   * - Failed `after each` hook skips remaining tests in a
   *   suite and subsuites, but executes other `after each`
   *   hooks
   *
   * See https://mochajs.org/api/Mocha.Runner.html#failHook
   */
  fun failHook(
    hook: Hook,
    err: Any?,
  )

  /**
   * Run hook `name` callbacks and then invoke `fn()`.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#hook
   */
  fun hook(
    name: String,
    fn: () -> Unit,
  )

  /**
   * Run hook `name` for the given array of `suites`
   * in order, and callback `fn(err, errSuite)`.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#hooks
   */
  fun hooks(
    name: String,
    suites: Array<Suite>,
    fn: (err: Any? /* use undefined for default */, errSuite: Suite? /* use undefined for default */) -> Unit,
  )

  /**
   * Run hooks from the top level down.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#hookUp
   */
  fun hookUp(
    name: String,
    fn: (err: Any? /* use undefined for default */, errSuite: Suite? /* use undefined for default */) -> Unit,
  )

  /**
   * Run hooks from the bottom up.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#hookDown
   */
  fun hookDown(
    name: String,
    fn: (err: Any? /* use undefined for default */, errSuite: Suite? /* use undefined for default */) -> Unit,
  )

  /**
   * Return an array of parent Suites from closest to furthest.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#parents
   */
  fun parents(): Array<Suite>

  /**
   * Run the current test and callback `fn(err)`.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#runTest
   */
  fun runTest(fn: Done): Any?

  /**
   * Run tests in the given `suite` and invoke the callback `fn()` when complete.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#runTests
   */
  fun runTests(suite: Suite, fn: (errSuite: Suite? /* use undefined for default */) -> Unit)

  /**
   * Run the given `suite` and invoke the callback `fn()` when complete.
   *
   * See https://mochajs.org/api/Mocha.Runner.html#runSuite
   */
  fun runSuite(suite: Suite, fn: (errSuite: Suite? /* use undefined for default */) -> Unit)

  fun on(event: String /* "fail" */, listener: (test: Test, err: Any?) -> Unit) // this

  fun on(event: String /* "pending" */, listener: (test: Test) -> Unit) // this

  fun on(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun once(event: String /* "fail" */, listener: (test: Test, err: Any?) -> Unit) // this

  fun once(event: String /* "pending" */, listener: (test: Test) -> Unit) // this

  fun once(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun addListener(event: String /* "fail" */, listener: (test: Test, err: Any?) -> Unit) // this

  fun addListener(event: String /* "pending" */, listener: (test: Test) -> Unit) // this

  fun addListener(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun removeListener(event: String /* "fail" */, listener: (test: Test, err: Any?) -> Unit) // this

  fun removeListener(event: String /* "pending" */, listener: (test: Test) -> Unit) // this

  fun removeListener(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun prependListener(event: String /* "fail" */, listener: (test: Test, err: Any?) -> Unit) // this

  fun prependListener(event: String /* "pending" */, listener: (test: Test) -> Unit) // this

  fun prependListener(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun prependOnceListener(event: String /* "fail" */, listener: (test: Test, err: Any?) -> Unit) // this

  fun prependOnceListener(event: String /* "pending" */, listener: (test: Test) -> Unit) // this

  fun prependOnceListener(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun emit(name: String /* "fail" */, test: Test, err: Any?): Boolean

  fun emit(name: String /* "pending" */, test: Test): Boolean

  fun emit(
    name: String,
    vararg args: Any?,
  ): Boolean

  companion object {
    val constants: RunnerConstants

    /**
     * Wrapper for setImmediate, process.nextTick, or browser polyfill.
     */
    fun immediately(callback: () -> Unit)
  }
}
