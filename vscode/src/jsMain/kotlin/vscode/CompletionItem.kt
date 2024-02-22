@file:JsModule("vscode")

package vscode

import js.array.ReadonlyArray

/**
 * A completion item represents a text snippet that is proposed to complete text that is being typed.
 *
 * It is sufficient to create a completion item from just a [label]. In that
 * case the completion item will replace the [TextDocument.getWordRangeAtPosition]
 * until the cursor with the given label or [insertText]. Otherwise the
 * given [textEdit] is used.
 *
 * When selecting a completion item in the editor its defined or synthesized text edit will be applied
 * to *all* cursors/selections whereas [additionalTextEdits] will be
 * applied as provided.
 *
 * @see [CompletionItemProvider.provideCompletionItems]
 * @see [CompletionItemProvider.resolveCompletionItem]
 */
external class CompletionItem {
  /**
   * Creates a new completion item.
   *
   * Completion items must have at least a [label] which then
   * will be used as insert text as well as for sorting and filtering.
   *
   * @param label The label of the completion.
   * @param kind The [CompletionItemKind] of the completion.
   */
  constructor(label: String, kind: CompletionItemKind = definedExternally)

  /**
   * Creates a new completion item.
   *
   * Completion items must have at least a [label] which then
   * will be used as insert text as well as for sorting and filtering.
   *
   * @param label The label of the completion.
   * @param kind The [CompletionItemKind] of the completion.
   */
  constructor(label: CompletionItemLabel, kind: CompletionItemKind = definedExternally)

  /**
   * The label of this completion item. By default
   * this is also the text that is inserted when selecting
   * this completion.
   */
  var label: Union<String, CompletionItemLabel>

  /**
   * The kind of this completion item. Based on the kind
   * an icon is chosen by the editor.
   */
  var kind: CompletionItemKind?

  /**
   * Tags for this completion item.
   */
  var tags: ReadonlyArray<CompletionItemTag>?

  /**
   * A human-readable string with additional information
   * about this item, like type or symbol information.
   */
  var detail: String?

  /**
   * A human-readable string that represents a doc-comment.
   */
  var documentation: Union<String, MarkdownString>?

  /**
   * A string that should be used when comparing this item
   * with other items. When `falsy` the [CompletionItem.label]
   * is used.
   *
   * Note that `sortText` is only used for the initial ordering of completion
   * items. When having a leading word (prefix) ordering is based on how
   * well completions match that prefix and the initial ordering is only used
   * when completions match equally well. The prefix is defined by the
   * [CompletionItem.range]-property and can therefore be different
   * for each completion.
   */
  var sortText: String?

  /**
   * A string that should be used when filtering a set of
   * completion items. When `falsy` the [CompletionItem.label]
   * is used.
   *
   * Note that the filter text is matched against the leading word (prefix) which is defined
   * by the [CompletionItem.range]-property.
   */
  var filterText: String?

  /**
   * Select this item when showing. *Note* that only one completion item can be selected and
   * that the editor decides which item that is. The rule is that the *first* item of those
   * that match best is selected.
   */
  var preselect: Boolean?

  /**
   * A string or snippet that should be inserted in a document when selecting
   * this completion. When `falsy` the [CompletionItem.label]
   * is used.
   */
  var insertText: Union<String, SnippetString>?

  /**
   * A range or a insert and replace range selecting the text that should be replaced by this completion item.
   *
   * When omitted, the range of the [TextDocument.getWordRangeAtPosition] is used as replace-range
   * and as insert-range the start of the [TextDocument.getWordRangeAtPosition] to the
   * current position is used.
   *
   * *Note 1:* A range must be a [Range.isSingleLine] and it must
   * [Range.contains] the position at which completion has been [CompletionItemProvider.provideCompletionItems].
   * *Note 2:* A insert range must be a prefix of a replace range, that means it must be contained and starting at the same position.
   */
  var range: Union<Range, RangeDetail>?

  /**
   * An optional set of characters that when pressed while this completion is active will accept it first and
   * then type that character. *Note* that all commit characters should have `length=1` and that superfluous
   * characters will be ignored.
   */
  var commitCharacters: Array<String>?

  /**
   * Keep whitespace of the [CompletionItem.insertText] as is. By default, the editor adjusts leading
   * whitespace of new lines so that they match the indentation of the line for which the item is accepted - setting
   * this to `true` will prevent that.
   */
  var keepWhitespace: Boolean?

  /**
   * An [TextEdit] which is applied to a document when selecting
   * this completion. When an edit is provided the value of
   * [CompletionItem.insertText] is ignored.
   *
   * The [Range] of the edit must be single-line and on the same
   * line completions were requested ([CompletionItemProvider.provideCompletionItems]) at.
   */
  @Deprecated("Use CompletionItem.insertText and CompletionItem.range instead")
  var textEdit: TextEdit?

  /**
   * An optional array of additional [TextEdit]s that are applied when
   * selecting this completion. Edits must not overlap with the main [CompletionItem.textEdit]
   * nor with themselves.
   */
  var additionalTextEdits: Array<TextEdit>?

  /**
   * An optional [Command] that is executed *after* inserting this completion. *Note* that
   * additional modifications to the current document should be described with the
   * [CompletionItem.additionalTextEdits]-property.
   */
  var command: Command?
}
