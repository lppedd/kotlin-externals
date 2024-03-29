package vscode

import kotlin.ts.Union

/**
 * Event triggered by extensions to signal to the editor that an edit has occurred on an [CustomDocument].
 *
 * @see CustomEditorProvider.onDidChangeCustomDocument
 */
external interface CustomDocumentEditEvent<T : CustomDocument /* default is CustomDocument */> {
  /**
   * The document that the edit is for.
   */
  val document: T

  /**
   * Undo the edit operation.
   *
   * This is invoked by the editor when the user undoes this edit. To implement `undo`, your
   * extension should restore the document and editor to the state they were in just before this
   * edit was added to the editor's internal edit stack by `onDidChangeCustomDocument`.
   */
  fun undo(): Union<Thenable<Unit>, Unit> // Thenable<void> | void

  /**
   * Redo the edit operation.
   *
   * This is invoked by the editor when the user redoes this edit. To implement `redo`, your
   * extension should restore the document and editor to the state they were in just after this
   * edit was added to the editor's internal edit stack by `onDidChangeCustomDocument`.
   */
  fun redo(): Union<Thenable<Unit>, Unit> // Thenable<void> | void

  /**
   * Display name describing the edit.
   *
   * This will be shown to users in the UI for undo/redo operations.
   */
  val label: String?
}
