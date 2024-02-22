@file:JsModule("mocha")

package mocha.mocha

import mocha.Mocha
import nodejs.EventEmitter

/**
 * Initialize a new `Suite` with the given `title` and `ctx`.
 *
 * See https://mochajs.org/api/Mocha.Suite.html
 */
external class Suite : EventEmitter {
  constructor(title: String, parentContext: Context = definedExternally)

  var ctx: Context
  var suites: Array<Suite>
  var tests: Array<Test>
  var pending: Boolean
  var file: String?
  var root: Boolean
  var delayed: Boolean
  var parent: Suite?
  var title: String

  /**
   * Return a clone of this `Suite`.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#clone
   */
  fun clone(): Suite

  /**
   * Get timeout `ms`.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#timeout
   */
  fun timeout(): Int

  /**
   * Set timeout `ms` or short-hand such as "2s".
   *
   * See https://mochajs.org/api/Mocha.Suite.html#timeout
   */
  fun timeout(ms: String) // this

  fun timeout(ms: Int) // this

  /**
   * Get number of times to retry a failed test.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#retries
   */
  fun retries(): Int

  /**
   * Set number of times to retry a failed test.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#retries
   */
  fun retries(n: String) // this

  fun retries(n: Int) // this

  /**
   * Get slow `ms`.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#slow
   */
  fun slow(): Int

  /**
   * Set slow `ms` or short-hand such as "2s".
   *
   * See https://mochajs.org/api/Mocha.Suite.html#slow
   */
  fun slow(ms: String) // this

  fun slow(ms: Int) // this

  /**
   * Get whether to bail after first error.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#bail
   */
  fun bail(): Boolean

  /**
   * Set whether to bail after first error.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#bail
   */
  fun bail(bail: Boolean) // this

  /**
   * Check if this suite or its parent suite is marked as pending.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#isPending
   */
  fun isPending(): Boolean

  /**
   * Run `fn(test[, done])` before running tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#beforeAll
   */
  fun beforeAll(fn: Func = definedExternally) // this

  /**
   * Run `fn(test[, done])` before running tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#beforeAll
   */
  fun beforeAll(fn: AsyncFunc = definedExternally) // this

  /**
   * Run `fn(test[, done])` before running tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#beforeAll
   */
  fun beforeAll(title: String, fn: Func = definedExternally) // this

  /**
   * Run `fn(test[, done])` before running tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#beforeAll
   */
  fun beforeAll(title: String, fn: AsyncFunc = definedExternally) // this

  /**
   * Run `fn(test[, done])` after running tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#afterAll
   */
  fun afterAll(fn: Func = definedExternally) // this

  /**
   * Run `fn(test[, done])` after running tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#afterAll
   */
  fun afterAll(fn: AsyncFunc = definedExternally) // this

  /**
   * Run `fn(test[, done])` after running tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#afterAll
   */
  fun afterAll(title: String, fn: Func = definedExternally) // this

  /**
   * Run `fn(test[, done])` after running tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#afterAll
   */
  fun afterAll(title: String, fn: AsyncFunc = definedExternally) // this

  /**
   * Run `fn(test[, done])` before each test case.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#beforeEach
   */
  fun beforeEach(fn: Func = definedExternally) // this

  /**
   * Run `fn(test[, done])` before each test case.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#beforeEach
   */
  fun beforeEach(fn: AsyncFunc = definedExternally) // this

  /**
   * Run `fn(test[, done])` before each test case.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#beforeEach
   */
  fun beforeEach(title: String, fn: Func = definedExternally) // this

  /**
   * Run `fn(test[, done])` before each test case.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#beforeEach
   */
  fun beforeEach(title: String, fn: AsyncFunc = definedExternally) // this

  /**
   * Run `fn(test[, done])` after each test case.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#afterEach
   */
  fun afterEach(fn: Func = definedExternally) // this

  /**
   * Run `fn(test[, done])` after each test case.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#afterEach
   */
  fun afterEach(fn: AsyncFunc = definedExternally) // this

  /**
   * Run `fn(test[, done])` after each test case.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#afterEach
   */
  fun afterEach(title: String, fn: Func = definedExternally) // this

  /**
   * Run `fn(test[, done])` after each test case.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#afterEach
   */
  fun afterEach(title: String, fn: AsyncFunc = definedExternally) // this

  /**
   * Add a test `suite`.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#addSuite
   */
  fun addSuite(suite: Suite) // this

  /**
   * Add a `test` to this suite.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#addTest
   */
  fun addTest(test: Test) // this

  /**
   * Cleans all references from this suite and all child suites.
   *
   * https://mochajs.org/api/suite#dispose
   */
  fun dispose()

  /**
   * Return the full title generated by recursively concatenating the parent's
   * full title.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#.Suite#fullTitle
   */
  fun fullTitle(): String

  /**
   * Return the title path generated by recursively concatenating the parent's
   * title path.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#.Suite#titlePath
   */
  fun titlePath(): Array<String>

  /**
   * Return the total number of tests.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#.Suite#total
   */
  fun total(): Int

  /**
   * Iterates through each suite recursively to find all tests. Applies a
   * function in the format `fn(test)`.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#eachTest
   */
  fun eachTest(fn: (test: Test) -> Unit) // this

  /**
   * This will run the root suite if we happen to be running in delayed mode.
   *
   * See https://mochajs.org/api/Mocha.Suite.html#run
   */
  fun run()

  /**
   * Generic hook-creator.
   */
  fun _createHook(
    title: String,
    fn: Func = definedExternally,
  ): Hook

  fun _createHook(
    title: String,
    fn: AsyncFunc = definedExternally,
  ): Hook

  fun on(event: String /* "afterEach" */, listener: (hook: Hook) -> Unit) // this

  fun on(event: String /* "suite" */, listener: (suite: Suite) -> Unit) // this

  fun on(event: String /* "test" */, listener: (test: Test) -> Unit) // this

  fun on(event: String /* "run" */, listener: () -> Unit) // this

  fun on(
    event: String, // "pre-require"
    listener: (context: MochaGlobals, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun on(event: String /* "require" */, listener: (module: Any?, file: String, mocha: Mocha) -> Unit) // this

  fun on(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun once(event: String /* "afterEach" */, listener: (hook: Hook) -> Unit) // this

  fun once(event: String /* "suite" */, listener: (suite: Suite) -> Unit) // this

  fun once(event: String /* "test" */, listener: (test: Test) -> Unit) // this

  fun once(event: String /* "run" */, listener: () -> Unit) // this

  fun once(
    event: String, // "pre-require"
    listener: (context: MochaGlobals, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun once(event: String /* "require" */, listener: (module: Any?, file: String, mocha: Mocha) -> Unit) // this

  fun once(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun addListener(event: String /* "afterEach" */, listener: (hook: Hook) -> Unit) // this

  fun addListener(event: String /* "suite" */, listener: (suite: Suite) -> Unit) // this

  fun addListener(event: String /* "test" */, listener: (test: Test) -> Unit) // this

  fun addListener(event: String /* "run" */, listener: () -> Unit) // this

  fun addListener(
    event: String, // "pre-require"
    listener: (context: MochaGlobals, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun addListener(
    event: String, // "require"
    listener: (module: Any?, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun addListener(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun removeListener(event: String /* "afterEach" */, listener: (hook: Hook) -> Unit) // this

  fun removeListener(event: String /* "suite" */, listener: (suite: Suite) -> Unit) // this

  fun removeListener(event: String /* "test" */, listener: (test: Test) -> Unit) // this

  fun removeListener(event: String /* "run" */, listener: () -> Unit) // this

  fun removeListener(
    event: String, // "pre-require"
    listener: (context: MochaGlobals, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun removeListener(
    event: String, // "require"
    listener: (module: Any?, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun removeListener(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun prependListener(event: String /* "afterEach" */, listener: (hook: Hook) -> Unit) // this

  fun prependListener(event: String /* "suite" */, listener: (suite: Suite) -> Unit) // this

  fun prependListener(event: String /* "test" */, listener: (test: Test) -> Unit) // this

  fun prependListener(event: String /* "run" */, listener: () -> Unit) // this

  fun prependListener(
    event: String, // "pre-require"
    listener: (context: MochaGlobals, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun prependListener(
    event: String, // "require"
    listener: (module: Any?, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun prependListener(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun prependOnceListener(event: String /* "afterEach" */, listener: (hook: Hook) -> Unit) // this

  fun prependOnceListener(event: String /* "suite" */, listener: (suite: Suite) -> Unit) // this

  fun prependOnceListener(event: String /* "test" */, listener: (test: Test) -> Unit) // this

  fun prependOnceListener(event: String /* "run" */, listener: () -> Unit) // this

  fun prependOnceListener(
    event: String, // "pre-require"
    listener: (context: MochaGlobals, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun prependOnceListener(
    event: String, // "require"
    listener: (module: Any?, file: String, mocha: Mocha) -> Unit,
  ) // this

  fun prependOnceListener(event: String, listener: Function<Unit> /* (...args: any[]) => void */) // this

  fun emit(name: String /* "afterEach" */, hook: Hook): Boolean

  fun emit(name: String /* "suite" */, suite: Suite): Boolean

  fun emit(name: String /* "test" */, test: Test): Boolean

  fun emit(name: String /* "run" */): Boolean

  fun emit(name: String /* "require" */, module: Any?, file: String, mocha: Mocha): Boolean

  fun emit(name: String /* "post-require" */, context: MochaGlobals, file: String, mocha: Mocha): Boolean

  fun emit(
    name: String,
    vararg args: Any?,
  ): Boolean

  companion object {
    val constants: SuiteConstants

    /**
     * Create a new `Suite` with the given `title` and parent `Suite`. When a suite
     * with the same title is already present, that suite is returned to provide
     * nicer reporter and more flexible meta-testing.
     *
     * See https://mochajs.org/api/mocha#.exports.create
     */
    fun create(
      parent: Suite,
      title: String,
    ): Suite
  }
}
