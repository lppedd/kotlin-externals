package mocha

import mocha.mocha.*
import kotlin.js.Promise
import kotlin.js.RegExp

/**
 * Mocha API
 *
 * See https://mochajs.org/api/mocha
 */
@JsModule("mocha")
open external class Mocha {
  constructor(options: MochaOptions<Any?> = definedExternally)

  var suite: Suite
  var files: Array<String>
  var options: MochaInstanceOptions

  /**
   * Add test `file`.
   *
   * See https://mochajs.org/api/mocha#addFile
   */
  fun addFile(file: String) // this

  /**
   * Enable or disable bailing on the first failure.
   *
   * See https://mochajs.org/api/mocha#bail
   */
  fun bail(bail: Boolean = definedExternally) // this

  /**
   * Enables or disables whether or not to dispose after each test run.
   * Disable this to ensure you can run the test suite multiple times.
   * If disabled, be sure to dispose mocha when you're done to prevent memory leaks.
   *
   * See https://mochajs.org/api/mocha#cleanReferencesAfterRun
   */
  fun cleanReferencesAfterRun(clean: Boolean = definedExternally) // this

  /**
   * Manually dispose this mocha instance. Mark this instance as `disposed` and unable to run more tests.
   * It also removes function references to tests functions and hooks, so variables trapped in closures can be cleaned by the garbage collector.
   *
   * See https://mochajs.org/api/mocha#dispose
   */
  fun dispose()

  /**
   * Set reporter to one of the built-in reporters.
   *
   * See https://mochajs.org/api/mocha#reporter
   */
  fun reporter(reporter: Reporter, reporterOptions: Any? = definedExternally) // this

  /**
   * Set reporter to the provided constructor, one of the built-in reporters, or loads a reporter
   * from a module path. Defaults to `"spec"`.
   *
   * See https://mochajs.org/api/mocha#reporter
   */
  fun reporter(reporter: String = definedExternally, reporterOptions: Any? = definedExternally) // this

  fun reporter(
    reporter: ReporterConstructor = definedExternally,
    reporterOptions: Any? = definedExternally,
  ) // this

  /**
   * Set test UI to one of the built-in test interfaces.
   *
   * See https://mochajs.org/api/mocha#ui
   */
  fun ui(name: Interface) // this

  /**
   * Set test UI to one of the built-in test interfaces or loads a test interface from a module
   * path. Defaults to `"bdd"`.
   *
   * See https://mochajs.org/api/mocha#ui
   */
  fun ui(name: String = definedExternally) // this

  /**
   * Escape string and add it to grep as a RegExp.
   *
   * See https://mochajs.org/api/mocha#fgrep
   */
  fun fgrep(str: String) // this

  /**
   * Add regexp to grep, if `re` is a string it is escaped.
   *
   * See https://mochajs.org/api/mocha#grep
   */
  fun grep(re: String) // this

  fun grep(re: RegExp) // this

  /**
   * Whether to activate dry-run mode.
   *
   * @param dryRun Whether to activate dry-run mode. Defaults to `true`.
   */
  fun dryRun(dryRun: Boolean = definedExternally) // this

  /**
   * Invert `.grep()` matches.
   *
   * See https://mochajs.org/api/mocha#invert
   */
  fun invert() // this

  /**
   * Enable global leak checking.
   *
   * See https://mochajs.org/api/mocha#checkLeaks
   */
  fun checkLeaks() // this

  /**
   * Display long stack-trace on failing
   *
   * See https://mochajs.org/api/mocha#fullTrace
   */
  fun fullTrace() // this

  /**
   * Enable growl support.
   *
   * See https://mochajs.org/api/mocha#growl
   */
  fun growl() // this

  /**
   * Ignore `globals` array or string.
   *
   * See https://mochajs.org/api/mocha#globals
   */
  fun globals(globals: String) // this

  fun globals(globals: js.array.ReadonlyArray<String>) // this

  /**
   * Set the timeout in milliseconds.
   *
   * See https://mochajs.org/api/mocha#timeout
   */
  fun timeout(timeout: String) // this

  fun timeout(timeout: Int) // this

  /**
   * Set the number of times to retry failed tests.
   *
   * See https://mochajs.org/api/mocha#retries
   */
  fun retries(n: Int) // this

  /**
   * Set slowness threshold in milliseconds.
   *
   * See https://mochajs.org/api/mocha#slow
   */
  fun slow(slow: String) // this

  fun slow(slow: Int) // this

  /**
   * Makes all tests async (accepting a callback)
   *
   * See https://mochajs.org/api/mocha#asyncOnly.
   */
  fun asyncOnly() // this

  /**
   * Disable syntax highlighting (in browser).
   *
   * See https://mochajs.org/api/mocha#noHighlighting
   */
  fun noHighlighting() // this

  /**
   * Enable uncaught errors to propagate (in browser).
   *
   * See https://mochajs.org/api/mocha#allowUncaught
   */
  fun allowUncaught(): Boolean

  /**
   * Delay root suite execution.
   *
   * See https://mochajs.org/api/mocha#delay
   */
  fun delay(): Boolean

  /**
   * Tests marked only fail the suite
   *
   * See https://mochajs.org/api/mocha#forbidOnly
   */
  fun forbidOnly(): Boolean

  /**
   * Pending tests and tests marked skip fail the suite
   *
   * See https://mochajs.org/api/mocha#forbidPending
   */
  fun forbidPending(): Boolean

  /**
   * Run tests and invoke `fn()` when complete.
   *
   * Note that `run` relies on Node's `require` to execute
   * the test interface functions and will be subject to the
   * cache - if the files are already in the `require` cache,
   * they will effectively be skipped. Therefore, to run tests
   * multiple times or to run tests in files that are already
   * in the `require` cache, make sure to clear them from the
   * cache first in whichever manner best suits your needs.
   *
   * See https://mochajs.org/api/mocha#run
   */
  fun run(fn: (failures: Int) -> Unit = definedExternally): Runner

  /**
   * Loads ESM (and CJS) test files asynchronously.
   *
   * See https://mochajs.org/api/mocha#loadFilesAsync
   */
  fun loadFilesAsync(): Promise<Unit>

  /**
   * Load registered files.
   *
   * See https://mochajs.org/api/mocha#loadFiles
   */
  fun loadFiles(fn: () -> Unit = definedExternally)

  /**
   * Unloads `files` from Node's `require` cache.
   *
   * This allows required files to be "freshly" reloaded, providing the ability
   * to reuse a Mocha instance programmatically.
   * Note: does not clear ESM module files from the cache
   */
  fun unloadFiles() // this

  /**
   * Toggles parallel mode.
   *
   * Must be run before calling `run`. Changes the `Runner` class to
   * use; also enables lazy file loading if not already done so.
   *
   * See https://mochajs.org/api/mocha#parallelMode
   */
  fun parallelMode(enabled: Boolean = definedExternally) // this

  /**
   * Assigns hooks to the root suite.
   *
   * See https://mochajs.org/api/mocha#rootHooks
   */
  fun rootHooks(hooks: RootHookObject) // this

  /**
   * Configures one or more global setup fixtures.
   * If given no parameters, unsets any previously-set fixtures.
   *
   * See https://mochajs.org/api/mocha#globalSetup
   */
  var globalSetup: HookFunction

  /**
   * Configures one or more global teardown fixtures.
   * If given no parameters, unsets any previously-set fixtures.
   *
   * See https://mochajs.org/api/mocha#globalTeardown
   */
  var globalTeardown: HookFunction

  /**
   * Returns `true` if one or more global setup fixtures have been supplied
   *
   * See https://mochajs.org/api/mocha#hasGlobalSetupFixtures
   */
  fun hasGlobalSetupFixtures(): Boolean

  /**
   * Returns `true` if one or more global teardown fixtures have been supplied
   *
   * See https://mochajs.org/api/mocha#hasGlobalTeardownFixtures
   */
  fun hasGlobalTeardownFixtures(): Boolean

  /**
   * Toggle execution of any global setup fixture(s)
   *
   * See https://mochajs.org/api/mocha#enableGlobalSetup
   */
  fun enableGlobalSetup(enabled: Boolean) // this

  /**
   * Toggle execution of any global teardown fixture(s)
   *
   * See https://mochajs.org/api/mocha#enableGlobalTeardown
   */
  fun enableGlobalTeardown(enabled: Boolean) // this
}
