@file:JsModule("vscode")

package vscode

/**
 * A hover represents additional information for a symbol or word. Hovers are
 * rendered in a tooltip-like widget.
 */
external class Hover {
  /**
   * Creates a new hover object.
   *
   * @param contents The contents of the hover.
   * @param range The range to which the hover applies.
   */
  constructor(contents: MarkdownString, range: Range = definedExternally)

  /**
   * Creates a new hover object.
   *
   * @param contents The contents of the hover.
   * @param range The range to which the hover applies.
   */
  @Suppress("DEPRECATION")
  constructor(contents: MarkedString, range: Range = definedExternally)

  /**
   * Creates a new hover object.
   *
   * @param contents The contents of the hover.
   * @param range The range to which the hover applies.
   */
  constructor(contents: Array<Any /* MarkdownString | MarkedString */>, range: Range = definedExternally)

  /**
   * The contents of this hover.
   */
  var contents: Array<Any /* MarkdownString | MarkedString */>

  /**
   * The range to which this hover applies. When missing, the
   * editor will use the range at the current position or the
   * current position itself.
   */
  var range: Range?
}
