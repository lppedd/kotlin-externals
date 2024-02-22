package vscode

/**
 * Assumes a [TerminalLocation} of editor and allows specifying a {@link ViewColumn] and
 * [TerminalEditorLocationOptions.preserveFocus preserveFocus ] property
 */

external interface TerminalEditorLocationOptions {
/**
   * A view column in which the [Terminal terminal] should be shown in the editor area.
   * The default is the [ViewColumn.Active active]. Columns that do not exist
   * will be created as needed up to the maximum of {@linkcode ViewColumn.Nine}.
   * Use {@linkcode ViewColumn.Beside} to open the editor to the side of the currently
   * active one.
   */
  var viewColumn: ViewColumn

/**
   * An optional flag that when `true` will stop the [Terminal] from taking focus.
   */
  var preserveFocus: Boolean?
}
