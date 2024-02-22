package vscode

/**
 * A TestRun represents an in-progress or completed test run and
 * provides methods to report the state of individual tests in the run.
 */

external interface TestRun {
  /**
   * The human-readable name of the run. This can be used to
   * disambiguate multiple sets of results in a test run. It is useful if
   * tests are run across multiple platforms, for example.
   */
  val name: String?

  /**
   * A cancellation token which will be triggered when the test run is
   * canceled from the UI.
   */
  val token: CancellationToken

  /**
   * Whether the test run will be persisted across reloads by the editor.
   */
  val isPersisted: Boolean

  /**
   * Indicates a test is queued for later execution.
   * @param test Test item to update.
   */
  fun enqueued(test: TestItem): Unit

  /**
   * Indicates a test has started running.
   * @param test Test item to update.
   */
  fun started(test: TestItem): Unit

  /**
   * Indicates a test has been skipped.
   * @param test Test item to update.
   */
  fun skipped(test: TestItem): Unit

  /**
   * Indicates a test has failed. You should pass one or more
   * [TestMessage TestMessages] to describe the failure.
   * @param test Test item to update.
   * @param message Messages associated with the test failure.
   * @param duration How long the test took to execute, in milliseconds.
   */
  fun failed(
    test: TestItem,
    message: TestMessage,
    duration: Double = definedExternally,
  ): Unit

  fun failed(
    test: TestItem,
    message: Array<out TestMessage>,
    duration: Double = definedExternally,
  ): Unit

  /**
   * Indicates a test has errored. You should pass one or more
   * [TestMessage TestMessages] to describe the failure. This differs
   * from the "failed" state in that it indicates a test that couldn't be
   * executed at all, from a compilation error for example.
   * @param test Test item to update.
   * @param message Messages associated with the test failure.
   * @param duration How long the test took to execute, in milliseconds.
   */
  fun errored(
    test: TestItem,
    message: TestMessage,
    duration: Double = definedExternally,
  ): Unit

  fun errored(
    test: TestItem,
    message: Array<out TestMessage>,
    duration: Double = definedExternally,
  ): Unit

  /**
   * Indicates a test has passed.
   * @param test Test item to update.
   * @param duration How long the test took to execute, in milliseconds.
   */
  fun passed(
    test: TestItem,
    duration: Double = definedExternally,
  ): Unit

  /**
   * Appends raw output from the test runner. On the user's request, the
   * output will be displayed in a terminal. ANSI escape sequences,
   * such as colors and text styles, are supported. New lines must be given
   * as CRLF (`\r\n`) rather than LF (`\n`).
   *
   * @param output Output text to append.
   * @param location Indicate that the output was logged at the given
   * location.
   * @param test Test item to associate the output with.
   */
  fun appendOutput(
    output: String,
    location: Location = definedExternally,
    test: TestItem = definedExternally,
  ): Unit

  /**
   * Signals the end of the test run. Any tests included in the run whose
   * states have not been updated will have their state reset.
   */
  fun end(): Unit
}