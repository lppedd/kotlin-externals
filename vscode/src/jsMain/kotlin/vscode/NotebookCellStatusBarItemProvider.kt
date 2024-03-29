package vscode

/**
 * A provider that can contribute items to the status bar that appears below a cell's editor.
 */
external interface NotebookCellStatusBarItemProvider {
  /**
   * An optional event to signal that statusbar items have changed. The provide method will be called again.
   */
  var onDidChangeCellStatusBarItems: Event<Unit>?

  /**
   * The provider will be called when the cell scrolls into view, when its content, outputs, language, or metadata change, and when it changes execution state.
   * @param cell The cell for which to return items.
   * @param token A token triggered if this request should be cancelled.
   * @return One or more [NotebookCellStatusBarItem cell statusbar items]
   */
  fun provideCellStatusBarItems(
    cell: NotebookCell,
    token: CancellationToken,
  ): ProviderResult<Any /* NotebookCellStatusBarItem | NotebookCellStatusBarItem[] */>
}
