package vscode

/**
 * A structured label for a [CompletionItem].
 */
external interface CompletionItemLabel {
  /**
   * The label of this completion item.
   *
   * By default this is also the text that is inserted when this completion is selected.
   */
  var label: String

  /**
   * An optional string which is rendered less prominently directly after [CompletionItemLabel.label],
   * without any spacing. Should be used for function signatures or type annotations.
   */
  var detail: String?

  /**
   * An optional string which is rendered less prominently after [CompletionItemLabel.detail]. Should be used
   * for fully qualified names or file path.
   */
  var description: String?
}
