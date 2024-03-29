package vscode

import js.array.ReadonlyArray
import kotlin.ts.Union

/**
 * Entry point to discover and execute tests. It contains [TestController.items] which
 * are used to populate the editor UI, and is associated with
 * [TestController.createRunProfile run profiles] to allow
 * for tests to be executed.
 */
external interface TestController {
  /**
   * The id of the controller passed in [vscode.tests.createTestController].
   * This must be globally unique.
   */
  val id: String

  /**
   * Human-readable label for the test controller.
   */
  var label: String

  /**
   * A collection of "top-level" [TestItem] instances, which can in
   * turn have their own [TestItem.children] to form the
   * "test tree."
   *
   * The extension controls when to add tests. For example, extensions should
   * add tests for a file when [vscode.workspace.onDidOpenTextDocument]
   * fires in order for decorations for tests within a file to be visible.
   *
   * However, the editor may sometimes explicitly request children using the
   * [resolveHandler] See the documentation on that method for more details.
   */
  val items: TestItemCollection

  /**
   * Creates a profile used for running tests. Extensions must create
   * at least one profile in order for tests to be run.
   * @param label A human-readable label for this profile.
   * @param kind Configures what kind of execution this profile manages.
   * @param runHandler Function called to start a test run.
   * @param isDefault Whether this is the default action for its kind.
   * @param tag Profile test tag.
   * @param supportsContinuousRun Whether the profile supports continuous running.
   * @return An instance of a [TestRunProfile], which is automatically
   *   associated with this controller.
   */
  fun createRunProfile(
    label: String,
    kind: TestRunProfileKind,
    runHandler: (
      request: TestRunRequest,
      token: CancellationToken,
    ) -> Union<Thenable<Unit>, Unit>, // Thenable<void> | void
    isDefault: Boolean = definedExternally,
    tag: TestTag = definedExternally,
    supportsContinuousRun: Boolean = definedExternally,
  ): TestRunProfile

  /**
   * A function provided by the extension that the editor may call to request
   * children of a test item, if the [TestItem.canResolveChildren] is
   * `true`. When called, the item should discover children and call
   * [TestController.createTestItem] as children are discovered.
   *
   * Generally the extension manages the lifecycle of test items, but under
   * certain conditions the editor may request the children of a specific
   * item to be loaded. For example, if the user requests to re-run tests
   * after reloading the editor, the editor may need to call this method
   * to resolve the previously-run tests.
   *
   * The item in the explorer will automatically be marked as "busy" until
   * the function returns or the returned thenable resolves.
   *
   * @param item An unresolved test item for which children are being
   *   requested, or `undefined` to resolve the controller's initial [TestController.items items].
   */
  var resolveHandler: ((item: TestItem?) -> Union<Thenable<Unit>, Unit> /* Thenable<void> | void */)?

  /**
   * If this method is present, a refresh button will be present in the
   * UI, and this method will be invoked when it's clicked. When called,
   * the extension should scan the workspace for any new, changed, or
   * removed tests.
   *
   * It's recommended that extensions try to update tests in realtime, using
   * a [FileSystemWatcher] for example, and use this method as a fallback.
   *
   * @return A thenable that resolves when tests have been refreshed.
   */
  var refreshHandler: ((token: CancellationToken) -> Union<Thenable<Unit>, Unit> /* Thenable<void> | void */)?

  /**
   * Creates a [TestRun]. This should be called by the
   * [TestRunProfile] when a request is made to execute tests, and may
   * also be called if a test run is detected externally. Once created, tests
   * that are included in the request will be moved into the queued state.
   *
   * All runs created using the same `request` instance will be grouped
   * together. This is useful if, for example, a single suite of tests is
   * run on multiple platforms.
   *
   * @param request Test run request. Only tests inside the `include` may be
   *   modified, and tests in its `exclude` are ignored.
   * @param name The human-readable name of the run. This can be used to
   *   disambiguate multiple sets of results in a test run. It is useful if
   *   tests are run across multiple platforms, for example.
   * @param persist Whether the results created by the run should be
   *   persisted in the editor. This may be false if the results are coming from
   *   a file already saved externally, such as a coverage information file.
   * @return An instance of the [TestRun]. It will be considered "running"
   *   from the moment this method is invoked until [TestRun.end] is called.
   */
  fun createTestRun(
    request: TestRunRequest,
    name: String = definedExternally,
    persist: Boolean = definedExternally,
  ): TestRun

  /**
   * Creates a new managed [TestItem] instance. It can be added into
   * the [TestItem.children] of an existing item, or into the
   * [TestController.items].
   *
   * @param id Identifier for the TestItem. The test item's ID must be unique
   *   in the [TestItemCollection] it's added to.
   * @param label Human-readable label of the test item.
   * @param uri URI this TestItem is associated with. May be a file or directory.
   */
  fun createTestItem(
    id: String,
    label: String,
    uri: Uri = definedExternally,
  ): TestItem

  /**
   * Marks an item's results as being outdated. This is commonly called when
   * code or configuration changes and previous results should no longer
   * be considered relevant. The same logic used to mark results as outdated
   * may be used to drive continuous test runs ([TestRunRequest.continuous]).
   *
   * If an item is passed to this method, test results for the item and all of
   * its children will be marked as outdated. If no item is passed, then all
   * test owned by the TestController will be marked as outdated.
   *
   * Any test runs started before the moment this method is called, including
   * runs which may still be ongoing, will be marked as outdated and deprioritized
   * in the editor's UI.
   *
   * @param item Item to mark as outdated. If undefined, all the controller's items are marked outdated.
   */
  fun invalidateTestResults(items: TestItem = definedExternally)

  fun invalidateTestResults(items: ReadonlyArray<TestItem> = definedExternally)

  /**
   * Unregisters the test controller, disposing of its associated tests
   * and unpersisted results.
   */
  fun dispose()
}
