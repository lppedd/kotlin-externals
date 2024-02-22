@file:JsModule("vscode")

package vscode

import kotlin.ts.Union

/**
 * An edit operation applied on drop ([DocumentDropEditProvider].)
 */
external class DocumentDropEdit {
  /**
   * @param insertText The text or snippet to insert at the drop location.
   */
  constructor(insertText: String)

  /**
   * @param insertText The text or snippet to insert at the drop location.
   */
  constructor(insertText: SnippetString)

  /**
   * The text or snippet to insert at the drop location.
   */
  var insertText: Union<String, SnippetString> // string | SnippetString

  /**
   * An optional additional edit to apply on drop.
   */
  var additionalEdit: WorkspaceEdit?
}
