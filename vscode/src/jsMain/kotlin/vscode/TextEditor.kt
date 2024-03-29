package vscode

import js.array.ReadonlyArray

/**
 * Represents an editor that is attached to a [TextDocument].
 */
external interface TextEditor {
  /**
   * The document associated with this text editor. The document will be the same for the entire lifetime of this text editor.
   */
  val document: TextDocument

  /**
   * The primary selection on this text editor. Shorthand for `TextEditor.selections[0]`.
   */
  var selection: Selection

  /**
   * The selections in this text editor. The primary selection is always at index 0.
   */
  var selections: ReadonlyArray<Selection>

  /**
   * The current visible ranges in the editor (vertically).
   * This accounts only for vertical scrolling, and not for horizontal scrolling.
   */
  val visibleRanges: ReadonlyArray<Range>

  /**
   * Text editor options.
   */
  var options: TextEditorOptions

  /**
   * The column in which this editor shows. Will be `undefined` in case this
   * isn't one of the main editors, e.g. an embedded editor, or when the editor
   * column is larger than three.
   */
  val viewColumn: ViewColumn?

  /**
   * Perform an edit on the document associated with this text editor.
   *
   * The given callback-function is invoked with an [TextEditorEdit] which must
   * be used to make edits. Note that the edit-builder is only valid while the
   * callback executes.
   *
   * @param callback A function which can create edits using an [TextEditorEdit].
   * @param options The undo/redo behavior around this edit. By default, undo stops will be created before and after this edit.
   * @return A promise that resolves with a value indicating if the edits could be applied.
   */
  fun edit(
    callback: (editBuilder: TextEditorEdit) -> Unit,
    options: TextEditorEditOptions = definedExternally,
  ): Thenable<Boolean>

  /**
   * Insert a [SnippetString] and put the editor into snippet mode. "Snippet mode"
   * means the editor adds placeholders and additional cursors so that the user can complete
   * or accept the snippet.
   *
   * @param snippet The snippet to insert in this edit.
   * @param location Position or range at which to insert the snippet, defaults to the current editor selection or selections.
   * @param options The undo/redo behavior around this edit. By default, undo stops will be created before and after this edit.
   * @return A promise that resolves with a value indicating if the snippet could be inserted. Note that the promise does not signal
   *   that the snippet is completely filled-in or accepted.
   */
  fun insertSnippet(
    snippet: SnippetString,
    location: Position = definedExternally,
    options: TextEditorInsertSnippetOptions = definedExternally,
  ): Thenable<Boolean>

  /**
   * Insert a [SnippetString] and put the editor into snippet mode. "Snippet mode"
   * means the editor adds placeholders and additional cursors so that the user can complete
   * or accept the snippet.
   *
   * @param snippet The snippet to insert in this edit.
   * @param location Position or range at which to insert the snippet, defaults to the current editor selection or selections.
   * @param options The undo/redo behavior around this edit. By default, undo stops will be created before and after this edit.
   * @return A promise that resolves with a value indicating if the snippet could be inserted. Note that the promise does not signal
   *   that the snippet is completely filled-in or accepted.
   */
  fun insertSnippet(
    snippet: SnippetString,
    location: Range = definedExternally,
    options: TextEditorInsertSnippetOptions = definedExternally,
  ): Thenable<Boolean>

  /**
   * Insert a [SnippetString] and put the editor into snippet mode. "Snippet mode"
   * means the editor adds placeholders and additional cursors so that the user can complete
   * or accept the snippet.
   *
   * @param snippet The snippet to insert in this edit.
   * @param location Position or range at which to insert the snippet, defaults to the current editor selection or selections.
   * @param options The undo/redo behavior around this edit. By default, undo stops will be created before and after this edit.
   * @return A promise that resolves with a value indicating if the snippet could be inserted. Note that the promise does not signal
   *   that the snippet is completely filled-in or accepted.
   */
  fun insertSnippet(
    snippet: SnippetString,
    location: ReadonlyArray<Position> = definedExternally,
    options: TextEditorInsertSnippetOptions = definedExternally,
  ): Thenable<Boolean>

  /**
   * Insert a [SnippetString] and put the editor into snippet mode. "Snippet mode"
   * means the editor adds placeholders and additional cursors so that the user can complete
   * or accept the snippet.
   *
   * @param snippet The snippet to insert in this edit.
   * @param location Position or range at which to insert the snippet, defaults to the current editor selection or selections.
   * @param options The undo/redo behavior around this edit. By default, undo stops will be created before and after this edit.
   * @return A promise that resolves with a value indicating if the snippet could be inserted. Note that the promise does not signal
   *   that the snippet is completely filled-in or accepted.
   */
  fun insertSnippet(
    snippet: SnippetString,
    location: ReadonlyArray<Range> = definedExternally,
    options: TextEditorInsertSnippetOptions = definedExternally,
  ): Thenable<Boolean>

  /**
   * Adds a set of decorations to the text editor. If a set of decorations already exists with
   * the given [TextEditorDecorationType], they will be replaced. If
   * `rangesOrOptions` is empty, the existing decorations with the given [TextEditorDecorationType]
   * will be removed.
   *
   * @see [vscode.window.createTextEditorDecorationType].
   *
   * @param decorationType A decoration type.
   * @param rangesOrOptions Either [Range]s or more detailed [DecorationOptions].
   */
  fun setDecorations(
    decorationType: TextEditorDecorationType,
    rangesOrOptions: ReadonlyArray<Range>,
  )

  /**
   * Adds a set of decorations to the text editor. If a set of decorations already exists with
   * the given [TextEditorDecorationType], they will be replaced. If
   * `rangesOrOptions` is empty, the existing decorations with the given [TextEditorDecorationType]
   * will be removed.
   *
   * @see [vscode.window.createTextEditorDecorationType].
   *
   * @param decorationType A decoration type.
   * @param rangesOrOptions Either [Range]s or more detailed [DecorationOptions].
   */
  fun setDecorations(
    decorationType: TextEditorDecorationType,
    rangesOrOptions: ReadonlyArray<DecorationOptions>,
  )

  /**
   * Scroll as indicated by `revealType` in order to reveal the given range.
   *
   * @param range A range.
   * @param revealType The scrolling strategy for revealing `range`.
   */
  fun revealRange(
    range: Range,
    revealType: TextEditorRevealType = definedExternally,
  )

  /**
   * Show the text editor.
   *
   * @param column The [ViewColumn] in which to show this editor.
   */
  @Deprecated(
    """
        Use vscode.window.showTextDocument instead.
        This method shows unexpected behavior and will be removed in the next major update.
        """,
  )
  fun show(column: ViewColumn = definedExternally)

  /**
   * Hide the text editor.
   */
  @Deprecated(
    """
        Use the command vscode.workbench.action.closeActiveEditor instead.
        This method shows unexpected behavior and will be removed in the next major update.
        """,
  )
  fun hide()
}
