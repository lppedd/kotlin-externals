package vscode

/**
 * Object to configure the behavior of the validation message.
 */
external interface InputBoxValidationMessage {
  /**
   * The validation message to display.
   */
  val message: String

  /**
   * The severity of the validation message.
   *
   * NOTE: When using `InputBoxValidationSeverity.Error`, the user will not be allowed to accept (hit ENTER) the input.
   * `Info` and `Warning` will still allow the InputBox to accept the input.
   */
  val severity: InputBoxValidationSeverity
}
