@file:JsModule("vscode")

package vscode

/**
 * Represents a collection of [InlineCompletionItem inline completion items] to be presented
 * in the editor.
 */

external class InlineCompletionList {
  /**
   * Creates a new list of inline completion items.
   */
  constructor (items: Array<InlineCompletionItem>)

  /**
   * The inline completion items.
   */
  var items: Array<InlineCompletionItem>
}
