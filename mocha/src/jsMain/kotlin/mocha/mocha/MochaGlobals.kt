package mocha.mocha

/**
 * Variables added to the global scope by Mocha when run in the CLI.
 */
external interface MochaGlobals {
  /**
   * Execute before running tests.
   *
   * - _Only available when invoked via the mocha CLI._
   *
   * See https://mochajs.org/api/global.html#before
   */
  var before: HookFunction

  /**
   * Execute after running tests.
   *
   * - _Only available when invoked via the mocha CLI._
   *
   * See https://mochajs.org/api/global.html#after
   */
  var after: HookFunction

  /**
   * Execute before each test case.
   *
   * - _Only available when invoked via the mocha CLI._
   *
   * See https://mochajs.org/api/global.html#beforeEach
   */
  var beforeEach: HookFunction

  /**
   * Execute after each test case.
   *
   * - _Only available when invoked via the mocha CLI._
   *
   * See https://mochajs.org/api/global.html#afterEach
   */
  var afterEach: HookFunction

  /**
   * Describe a "suite" containing nested suites and tests.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var describe: SuiteFunction

  /**
   * Describe a "suite" containing nested suites and tests.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var context: SuiteFunction

  /**
   * Pending suite.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var xdescribe: PendingSuiteFunction

  /**
   * Pending suite.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var xcontext: PendingSuiteFunction

  /**
   * Describes a test case.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var it: TestFunction

  /**
   * Describes a test case.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var specify: TestFunction

  /**
   * Describes a pending test case.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var xit: PendingTestFunction

  /**
   * Describes a pending test case.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var xspecify: PendingTestFunction

  /**
   * Execute before running tests.
   *
   * - _Only available when invoked via the mocha CLI._
   *
   * See https://mochajs.org/api/global.html#before
   */
  var suiteSetup: HookFunction

  /**
   * Execute after running tests.
   *
   * - _Only available when invoked via the mocha CLI._
   *
   * See https://mochajs.org/api/global.html#after
   */
  var suiteTeardown: HookFunction

  /**
   * Execute before each test case.
   *
   * - _Only available when invoked via the mocha CLI._
   *
   * See https://mochajs.org/api/global.html#beforeEach
   */
  var setup: HookFunction

  /**
   * Execute after each test case.
   *
   * - _Only available when invoked via the mocha CLI._
   *
   * See https://mochajs.org/api/global.html#afterEach
   */
  var teardown: HookFunction

  /**
   * Describe a "suite" containing nested suites and tests.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var suite: SuiteFunction

  /**
   * Describes a test case.
   *
   * - _Only available when invoked via the mocha CLI._
   */
  var test: TestFunction
  var run: () -> Unit
}
