package vscode

import js.array.ReadonlyArray

/**
 * Represents an event describing the change in a text editor's selections ([TextEditor.selections]).
 */
external interface TextEditorSelectionChangeEvent {
  /**
   * The [TextEditor] for which the selections have changed.
   */
  val textEditor: TextEditor

  /**
   * The new value for the text editor's selections ([TextEditor.selections]).
   */
  val selections: ReadonlyArray<Selection>

  /**
   * The [TextEditorSelectionChangeKind] which has triggered this
   * event. Can be `undefined`.
   */
  val kind: TextEditorSelectionChangeKind?
}
