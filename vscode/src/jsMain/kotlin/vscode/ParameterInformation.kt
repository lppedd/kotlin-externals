@file:JsModule("vscode")

package vscode

import js.array.JsTuple2

/**
 * Represents a parameter of a callable-signature. A parameter can
 * have a label and a doc-comment.
 */
external class ParameterInformation {
  /**
   * Creates a new parameter information object.
   *
   * @param label A label string or inclusive start and exclusive end offsets within its containing signature label.
   * @param documentation A doc string.
   */
  constructor(label: String, documentation: String = definedExternally)

  constructor(label: String, documentation: MarkdownString = definedExternally)

  constructor(
    label: JsTuple2<Int, Int>, // [ number, number ]
    documentation: String = definedExternally,
  )

  constructor(
    label: JsTuple2<Int, Int>, // [ number, number ]
    documentation: MarkdownString = definedExternally,
  )

  /**
   * The label of this signature.
   *
   * Either a string or inclusive start and exclusive end offsets within its containing
   * [SignatureInformation.label]. *Note*: A label of type string must be
   * a substring of its containing signature information's [SignatureInformation.label].
   */
  var label: Union<String, JsTuple2<Int, Int>> // string | [ number, number ]

  /**
   * The human-readable doc-comment of this signature. Will be shown
   * in the UI but can be omitted.
   */
  var documentation: Union<String, MarkdownString>? // string | MarkdownString | undefined
}
