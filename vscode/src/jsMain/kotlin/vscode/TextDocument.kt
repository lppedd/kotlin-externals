package vscode

import kotlin.js.RegExp

/**
 * Represents a text document, such as a source file. Text documents have
 * lines ([TextLine]) and knowledge about an underlying resource like a file.
 */
external interface TextDocument {
  /**
   * The associated uri for this document.
   *
   * *Note* that most documents use the `file`-scheme, which means they are files on disk. However, **not** all documents are
   * saved on disk and therefore the `scheme` must be checked before trying to access the underlying file or siblings on disk.
   *
   * @see [FileSystemProvider]
   * @see [TextDocumentContentProvider]
   */
  val uri: Uri

  /**
   * The file system path of the associated resource. Shorthand
   * notation for [TextDocument.uri]`.fsPath`. Independent of the uri scheme.
   */
  val fileName: String

  /**
   * Is this document representing an untitled file which has never been saved yet. *Note* that
   * this does not mean the document will be saved to disk, use [Uri.scheme]
   * to figure out where a document will be saved ([FileSystemProvider]), e.g. `file`, `ftp` etc.
   */
  val isUntitled: Boolean

  /**
   * The identifier of the language associated with this document.
   */
  val languageId: String

  /**
   * The version number of this document (it will strictly increase after each
   * change, including undo/redo).
   */
  val version: Int

  /**
   * `true` if there are unpersisted changes.
   */
  val isDirty: Boolean

  /**
   * `true` if the document has been closed. A closed document isn't synchronized anymore
   * and won't be re-used when the same resource is opened again.
   */
  val isClosed: Boolean

  /**
   * Save the underlying file.
   *
   * @return A promise that will resolve to `true` when the file
   *   has been saved. If the save failed, will return `false`.
   */
  fun save(): Thenable<Boolean>

  /**
   * The [EndOfLine] sequence that is predominately
   * used in this document.
   */
  val eol: EndOfLine

  /**
   * The number of lines in this document.
   */
  val lineCount: Int

  /**
   * Returns a text line denoted by the line number. Note
   * that the returned object is *not* live and changes to the
   * document are not reflected.
   *
   * @param line A line number in [0, lineCount).
   * @return A [TextLine line].
   */
  fun lineAt(line: Int): TextLine

  /**
   * Returns a text line denoted by the position. Note
   * that the returned object is *not* live and changes to the
   * document are not reflected.
   *
   * The position will be adjusted ([TextDocument.validatePosition]).
   *
   * @see [TextDocument.lineAt]
   *
   * @param position A position.
   * @return A [TextLine].
   */
  fun lineAt(position: Position): TextLine

  /**
   * Converts the position to a zero-based offset.
   *
   * The position will be adjusted ([TextDocument.validatePosition]).
   *
   * @param position A position.
   * @return A valid zero-based offset.
   */
  fun offsetAt(position: Position): Int

  /**
   * Converts a zero-based offset to a position.
   *
   * @param offset A zero-based offset.
   * @return A valid [Position].
   */
  fun positionAt(offset: Int): Position

  /**
   * Get the text of this document. A substring can be retrieved by providing
   * a range. The range will be adjusted ([TextDocument.validateRange]).
   *
   * @param range Include only the text included by the range.
   * @return The text inside the provided range or the entire text.
   */
  fun getText(range: Range = definedExternally): String

  /**
   * Get a word-range at the given position. By default words are defined by
   * common separators, like space, -, _, etc. In addition, per language custom
   * [word definitions] can be defined. It
   * is also possible to provide a custom regular expression.
   *
   * * *Note 1:* A custom regular expression must not match the empty string and
   *   if it does, it will be ignored.
   * * *Note 2:* A custom regular expression will fail to match multiline strings
   *   and in the name of speed regular expressions should not match words with
   *   spaces. Use [TextLine.text] for more complex, non-wordy, scenarios.
   *
   * The position will be adjusted ([TextDocument.validatePosition]).
   *
   * @param position A position.
   * @param regex Optional regular expression that describes what a word is.
   * @return A range spanning a word, or `undefined`.
   */
  fun getWordRangeAtPosition(
    position: Position,
    regex: RegExp = definedExternally,
  ): Range?

  /**
   * Ensure a range is completely contained in this document.
   *
   * @param range A range.
   * @return The given range or a new, adjusted range.
   */
  fun validateRange(range: Range): Range

  /**
   * Ensure a position is contained in the range of this document.
   *
   * @param position A position.
   * @return The given position or a new, adjusted position.
   */
  fun validatePosition(position: Position): Position
}
