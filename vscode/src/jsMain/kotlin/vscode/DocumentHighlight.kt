@file:JsModule("vscode")

package vscode

/**
 * A document highlight is a range inside a text document which deserves
 * special attention. Usually a document highlight is visualized by changing
 * the background color of its range.
 */
external class DocumentHighlight {
  /**
   * Creates a new document highlight object.
   *
   * @param range The range the highlight applies to.
   * @param kind The highlight kind, default is [DocumentHighlightKind.Text].
   */
  constructor(range: Range, kind: DocumentHighlightKind = definedExternally)

  /**
   * The range this highlight applies to.
   */
  var range: Range

  /**
   * The highlight kind, default is [DocumentHighlightKind.Text].
   */
  var kind: DocumentHighlightKind?
}
