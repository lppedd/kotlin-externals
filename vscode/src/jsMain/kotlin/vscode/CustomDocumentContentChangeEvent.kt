package vscode

/**
 * Event triggered by extensions to signal to the editor that the content of a [CustomDocument]
 * has changed.
 *
 * @see CustomEditorProvider.onDidChangeCustomDocument
 */
external interface CustomDocumentContentChangeEvent<T : CustomDocument /* default is CustomDocument */> {
  /**
   * The document that the change is for.
   */
  val document: T
}
