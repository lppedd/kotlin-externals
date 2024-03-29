@file:JsModule("vscode")

package vscode

/**
 * An inline completion item represents a text snippet that is proposed inline to complete text that is being typed.
 *
 * @see [InlineCompletionItemProvider.provideInlineCompletionItems]
 */
external class InlineCompletionItem {
  /**
   * Creates a new inline completion item.
   *
   * @param insertText The text to replace the range with.
   * @param range The range to replace. If not set, the word at the requested position will be used.
   * @param command An optional [Command] that is executed *after* inserting this completion.
   */
  constructor(insertText: String, range: Range = definedExternally, command: Command = definedExternally)

  constructor(insertText: SnippetString, range: Range = definedExternally, command: Command = definedExternally)

  /**
   * The text to replace the range with. Must be set.
   * Is used both for the preview and the accept operation.
   */
  var insertText: Any // string | SnippetString

  /**
   * A text that is used to decide if this inline completion should be shown. When `falsy`
   * the [InlineCompletionItem.insertText] is used.
   *
   * An inline completion is shown if the text to replace is a prefix of the filter text.
   */
  var filterText: String?

  /**
   * The range to replace.
   * Must begin and end on the same line.
   *
   * Prefer replacements over insertions to provide a better experience when the user deletes typed text.
   */
  var range: Range?

  /**
   * An optional [Command] that is executed *after* inserting this completion.
   */
  var command: Command?
}
