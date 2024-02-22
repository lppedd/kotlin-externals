@file:JsModule("mocha")

package mocha.mocha

/**
 * Execute after each test case.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#afterEach
 */
external var afterEach: HookFunction

/**
 * Execute after running tests.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#after
 */
external var after: HookFunction

/**
 * Execute before each test case.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#beforeEach
 */
external var beforeEach: HookFunction

/**
 * Execute before running tests.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#before
 */
external var before: HookFunction

/**
 * Describe a "suite" containing nested suites and tests.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var describe: SuiteFunction

/**
 * Describe a pending suite.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var xdescribe: PendingSuiteFunction

/**
 * Describes a test case.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var it: TestFunction

/**
 * Describes a pending test case.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var xit: PendingTestFunction

/**
 * Execute before each test case.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#beforeEach
 */
external var setup: HookFunction

/**
 * Execute before running tests.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#before
 */
external var suiteSetup: HookFunction

/**
 * Execute after running tests.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#after
 */
external var suiteTeardown: HookFunction

/**
 * Describe a "suite" containing nested suites and tests.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var suite: SuiteFunction

/**
 * Execute after each test case.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#afterEach
 */
external var teardown: HookFunction

/**
 * Describes a test case.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var test: TestFunction
