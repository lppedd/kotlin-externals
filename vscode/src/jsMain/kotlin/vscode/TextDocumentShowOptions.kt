package vscode

/**
 * Represents options to configure the behavior of showing a [TextDocument] in an [TextEditor].
 */
external interface TextDocumentShowOptions {
  /**
   * An optional view column in which the [TextEditor] should be shown.
   * The default is the [ViewColumn.Active]. Columns that do not exist
   * will be created as needed up to the maximum of [ViewColumn.Nine].
   * Use [ViewColumn.Beside] to open the editor to the side of the currently
   * active one.
   */
  var viewColumn: ViewColumn?

  /**
   * An optional flag that when `true` will stop the [TextEditor] from taking focus.
   */
  var preserveFocus: Boolean?

  /**
   * An optional flag that controls if an [TextEditor]-tab shows as preview. Preview tabs will
   * be replaced and reused until set to stay - either explicitly or through editing.
   *
   * *Note* that the flag is ignored if a user has disabled preview editors in settings.
   */
  var preview: Boolean?

  /**
   * An optional selection to apply for the document in the [TextEditor].
   */
  var selection: Range?
}
