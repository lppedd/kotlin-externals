@file:JsModule("vscode")

package vscode

/**
 * Represents the signature of something callable. A signature
 * can have a label, like a function-name, a doc-comment, and
 * a set of parameters.
 */
external class SignatureInformation {
  /**
   * Creates a new signature information object.
   *
   * @param label A label string.
   * @param documentation A doc string.
   */
  constructor(label: String, documentation: String = definedExternally)

  /**
   * Creates a new signature information object.
   *
   * @param label A label string.
   * @param documentation A doc string.
   */
  constructor(label: String, documentation: MarkdownString = definedExternally)

  /**
   * The label of this signature. Will be shown in
   * the UI.
   */
  var label: String

  /**
   * The human-readable doc-comment of this signature. Will be shown
   * in the UI but can be omitted.
   */
  var documentation: Union<String, MarkdownString>?

  /**
   * The parameters of this signature.
   */
  var parameters: Array<ParameterInformation>

  /**
   * The index of the active parameter.
   *
   * If provided, this is used in place of [SignatureHelp.activeParameter].
   */
  var activeParameter: Int?
}
