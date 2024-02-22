@file:JsModule("vscode")

package vscode

/**
 * A TestRunRequest is a precursor to a [TestRun], which in turn is
 * created by passing a request to [TestController.createTestRun]. The
 * TestRunRequest contains information about which tests should be run, which
 * should not be run, and how they are run (via the [TestRunRequest.profile profile]).
 *
 * In general, TestRunRequests are created by the editor and pass to
 * [TestRunProfile.runHandler], however you can also create test
 * requests and runs outside of the `runHandler`.
 */

external class TestRunRequest {
  /**
   * @param include Array of specific tests to run, or undefined to run all tests
   * @param exclude An array of tests to exclude from the run.
   * @param profile The run profile used for this request.
   * @param continuous Whether to run tests continuously as source changes.
   */
  constructor (
    include: Array<out TestItem> = definedExternally,
    exclude: Array<out TestItem> = definedExternally,
    profile: TestRunProfile = definedExternally,
    continuous: Boolean = definedExternally,
  )

  /**
   * A filter for specific tests to run. If given, the extension should run
   * all of the included tests and all their children, excluding any tests
   * that appear in [TestRunRequest.exclude]. If this property is
   * undefined, then the extension should simply run all tests.
   *
   * The process of running tests should resolve the children of any test
   * items who have not yet been resolved.
   */
  val include: (Array<out TestItem>)?

  /**
   * An array of tests the user has marked as excluded from the test included
   * in this run; exclusions should apply after inclusions.
   *
   * May be omitted if no exclusions were requested. Test controllers should
   * not run excluded tests or any children of excluded tests.
   */
  val exclude: (Array<out TestItem>)?

  /**
   * The profile used for this request. This will always be defined
   * for requests issued from the editor UI, though extensions may
   * programmatically create requests not associated with any profile.
   */
  val profile: TestRunProfile?

  /**
   * Whether the profile should run continuously as source code changes. Only
   * relevant for profiles that set [TestRunProfile.supportsContinuousRun].
   */
  val continuous: Boolean?
}
