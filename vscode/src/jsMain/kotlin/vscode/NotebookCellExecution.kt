package vscode

/**
 * A NotebookCellExecution is how [NotebookController notebook controller] modify a notebook cell as
 * it is executing.
 *
 * When a cell execution object is created, the cell enters the {@linkcode NotebookCellExecutionState.Pending Pending} state.
 * When {@linkcode NotebookCellExecution.start start(...)} is called on the execution task, it enters the {@linkcode NotebookCellExecutionState.Executing Executing} state. When
 * {@linkcode NotebookCellExecution.end end(...)} is called, it enters the {@linkcode NotebookCellExecutionState.Idle Idle} state.
 */
external interface NotebookCellExecution {
  /**
   * The [NotebookCell cell] for which this execution has been created.
   */
  val cell: NotebookCell

  /**
   * A cancellation token which will be triggered when the cell execution is canceled
   * from the UI.
   *
   * _Note_ that the cancellation token will not be triggered when the [NotebookController controller]
   * that created this execution uses an [NotebookController.interruptHandler interrupt-handler].
   */
  val token: CancellationToken

  /**
   * Set and unset the order of this cell execution.
   */
  var executionOrder: Int?

  /**
   * Signal that the execution has begun.
   *
   * @param startTime The time that execution began, in milliseconds in the Unix epoch. Used to drive the clock
   *   that shows for how long a cell has been running. If not given, the clock won't be shown.
   */
  fun start(startTime: Int = definedExternally)

  /**
   * Signal that execution has ended.
   *
   * @param success If true, a green check is shown on the cell status bar.
   *   If false, a red X is shown.
   *   If undefined, no check or X icon is shown.
   * @param endTime The time that execution finished, in milliseconds in the Unix epoch.
   */
  fun end(
    success: Boolean?,
    endTime: Int = definedExternally,
  )

  /**
   * Clears the output of the cell that is executing or of another cell that is affected by this execution.
   *
   * @param cell Cell for which output is cleared. Defaults to the [NotebookCellExecution.cell cell] of
   *   this execution.
   * @return A thenable that resolves when the operation finished.
   */
  fun clearOutput(cell: NotebookCell = definedExternally): Thenable<Unit>

  /**
   * Replace the output of the cell that is executing or of another cell that is affected by this execution.
   *
   * @param out Output that replaces the current output.
   * @param cell Cell for which output is cleared. Defaults to the [NotebookCellExecution.cell cell] of
   *   this execution.
   * @return A thenable that resolves when the operation finished.
   */
  fun replaceOutput(
    out: NotebookCellOutput,
    cell: NotebookCell = definedExternally,
  ): Thenable<Unit>

  fun replaceOutput(
    out: Array<out NotebookCellOutput>,
    cell: NotebookCell = definedExternally,
  ): Thenable<Unit>

  /**
   * Append to the output of the cell that is executing or to another cell that is affected by this execution.
   *
   * @param out Output that is appended to the current output.
   * @param cell Cell for which output is cleared. Defaults to the [NotebookCellExecution.cell cell] of
   *   this execution.
   * @return A thenable that resolves when the operation finished.
   */
  fun appendOutput(
    out: NotebookCellOutput,
    cell: NotebookCell = definedExternally,
  ): Thenable<Unit>

  fun appendOutput(
    out: Array<out NotebookCellOutput>,
    cell: NotebookCell = definedExternally,
  ): Thenable<Unit>

  /**
   * Replace all output items of existing cell output.
   *
   * @param items Output items that replace the items of existing output.
   * @param output Output object that already exists.
   * @return A thenable that resolves when the operation finished.
   */
  fun replaceOutputItems(
    items: NotebookCellOutputItem,
    output: NotebookCellOutput,
  ): Thenable<Unit>

  fun replaceOutputItems(
    items: Array<out NotebookCellOutputItem>,
    output: NotebookCellOutput,
  ): Thenable<Unit>

  /**
   * Append output items to existing cell output.
   *
   * @param items Output items that are append to existing output.
   * @param output Output object that already exists.
   * @return A thenable that resolves when the operation finished.
   */
  fun appendOutputItems(
    items: NotebookCellOutputItem,
    output: NotebookCellOutput,
  ): Thenable<Unit>

  fun appendOutputItems(
    items: Array<out NotebookCellOutputItem>,
    output: NotebookCellOutput,
  ): Thenable<Unit>
}
