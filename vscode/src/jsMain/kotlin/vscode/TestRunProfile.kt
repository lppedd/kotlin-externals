package vscode

import kotlin.ts.Union

/**
 * A TestRunProfile describes one way to execute tests in a [TestController].
 */
external interface TestRunProfile {
  /**
   * Label shown to the user in the UI.
   *
   * Note that the label has some significance if the user requests that
   * tests be re-run in a certain way. For example, if tests were run
   * normally and the user requests to re-run them in debug mode, the editor
   * will attempt use a configuration with the same label of the `Debug`
   * kind. If there is no such configuration, the default will be used.
   */
  var label: String

  /**
   * Configures what kind of execution this profile controls. If there
   * are no profiles for a kind, it will not be available in the UI.
   */
  val kind: TestRunProfileKind

  /**
   * Controls whether this profile is the default action that will
   * be taken when its kind is actioned. For example, if the user clicks
   * the generic "run all" button, then the default profile for
   * [TestRunProfileKind.Run] will be executed, although the
   * user can configure this.
   *
   * Changes the user makes in their default profiles will be reflected
   * in this property after a [onDidChangeDefault] event.
   */
  var isDefault: Boolean

  /**
   * Fired when a user has changed whether this is a default profile. The
   * event contains the new value of [isDefault]
   */
  var onDidChangeDefault: Event<Boolean>

  /**
   * Whether this profile supports continuous running of requests. If so,
   * then [TestRunRequest.continuous] may be set to `true`. Defaults
   * to false.
   */
  var supportsContinuousRun: Boolean

  /**
   * Associated tag for the profile. If this is set, only [TestItem]
   * instances with the same tag will be eligible to execute in this profile.
   */
  var tag: TestTag?

  /**
   * If this method is present, a configuration gear will be present in the
   * UI, and this method will be invoked when it's clicked. When called,
   * you can take other editor actions, such as showing a quick pick or
   * opening a configuration file.
   */
  var configureHandler: (() -> Unit)?

  /**
   * Handler called to start a test run. When invoked, the function should call
   * [TestController.createTestRun] at least once, and all test runs
   * associated with the request should be created before the function returns
   * or the returned promise is resolved.
   *
   * If [supportsContinuousRun] is set, then [TestRunRequest.continuous]
   * may be `true`. In this case, the profile should observe changes to
   * source code and create new test runs by calling [TestController.createTestRun],
   * until the cancellation is requested on the `token`.
   *
   * @param request Request information for the test run.
   * @param cancellationToken Token that signals the used asked to abort the
   * test run. If cancellation is requested on this token, all [TestRun]
   * instances associated with the request will be
   * automatically cancelled as well.
   */
  var runHandler: (request: TestRunRequest, token: CancellationToken) -> Union<Thenable<Unit>, Unit>

  /**
   * An extension-provided function that provides detailed statement and
   * function-level coverage for a file. The editor will call this when more
   * detail is needed for a file, such as when it's opened in an editor or
   * expanded in the **Test Coverage** view.
   *
   * The [FileCoverage] object passed to this function is the same instance
   * emitted on [TestRun.addCoverage] calls associated with this profile.
   */
  var loadDetailedCoverage: (
    testRun: TestRun,
    fileCoverage: FileCoverage,
    token: CancellationToken,
  ) -> Thenable<Array<FileCoverageDetail>>

  /**
   * Deletes the run profile.
   */
  fun dispose()
}
