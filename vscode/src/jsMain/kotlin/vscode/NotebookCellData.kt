@file:JsModule("vscode")

package vscode

import js.objects.Record

/**
 * NotebookCellData is the raw representation of notebook cells. Its is part of [NotebookData].
 */
external class NotebookCellData {
  /**
   * Create new cell data. Minimal cell data specifies its kind, its source value, and the
   * language identifier of its source.
   *
   * @param kind The kind.
   * @param value The source value.
   * @param languageId The language identifier of the source value.
   */
  constructor(kind: NotebookCellKind, value: String, languageId: String)

  /**
   * The [NotebookCellKind] of this cell data.
   */
  var kind: NotebookCellKind

  /**
   * The source value of this cell data - either source code or formatted text.
   */
  var value: String

  /**
   * The language identifier of the source value of this cell data. Any value from
   * [vscode.languages.getLanguages] is possible.
   */
  var languageId: String

  /**
   * The outputs of this cell data.
   */
  var outputs: Array<NotebookCellOutput>?

  /**
   * Arbitrary metadata of this cell data. Can be anything but must be JSON-stringifyable.
   */
  var metadata: Record<String, Any>?

  /**
   * The execution summary of this cell data.
   */
  var executionSummary: NotebookCellExecutionSummary?
}
