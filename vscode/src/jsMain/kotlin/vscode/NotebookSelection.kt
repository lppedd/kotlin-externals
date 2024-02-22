package vscode

external interface NotebookSelection {
  /**
   * The notebook for which the controller has been selected or un-selected.
   */
  val notebook: NotebookDocument

  /**
   * Whether the controller has been selected or un-selected.
   */
  val selected: Boolean
}
