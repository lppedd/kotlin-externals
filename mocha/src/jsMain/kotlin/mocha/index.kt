@file:JsModule("mocha")

package mocha

import mocha.mocha.*

/**
 * Execute before running tests.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#before
 */
external var before: HookFunction

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
external var after: HookFunction

/**
 * Execute after running tests.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#after
 */
external var suiteTeardown: HookFunction

/**
 * Execute before each test case.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#beforeEach
 */
external var beforeEach: HookFunction

/**
 * Execute before each test case.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#beforeEach
 */
external var setup: HookFunction

/**
 * Execute after each test case.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#afterEach
 */
external var afterEach: HookFunction

/**
 * Execute after each test case.
 *
 * - _Only available when invoked via the mocha CLI._
 *
 * See https://mochajs.org/api/global.html#afterEach
 */
external var teardown: HookFunction

/**
 * Describe a "suite" containing nested suites and tests.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var describe: SuiteFunction

/**
 * Describe a "suite" containing nested suites and tests.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var context: SuiteFunction

/**
 * Describe a "suite" containing nested suites and tests.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var suite: SuiteFunction

/**
 * Pending suite.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var xdescribe: PendingSuiteFunction

/**
 * Pending suite.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var xcontext: PendingSuiteFunction

/**
 * Describes a test case.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var it: TestFunction

/**
 * Describes a test case.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var specify: TestFunction

/**
 * Describes a test case.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var test: TestFunction

/**
 * Describes a pending test case.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var xit: PendingTestFunction

/**
 * Describes a pending test case.
 *
 * - _Only available when invoked via the mocha CLI._
 */
external var xspecify: PendingTestFunction

/**
 * Mocha global.
 *
 * - _Only supported in the browser._
 */
external val mocha: BrowserMocha
