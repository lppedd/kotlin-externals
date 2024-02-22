@file:JsModule("vscode")

package vscode

/**
 * An edit operation applied [DocumentDropEditProvider on drop].
 */

external class DocumentDropEdit {
  /**
   * @param insertText The text or snippet to insert at the drop location.
   */
  constructor(insertText: String)

  constructor(insertText: SnippetString)

  /**
   * The text or snippet to insert at the drop location.
   */
  var insertText: Any // string | SnippetString

  /**
   * An optional additional edit to apply on drop.
   */
  var additionalEdit: WorkspaceEdit?
}
