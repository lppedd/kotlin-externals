package vscode

/**
 * Options to configure the behavior of the message.
 *
 * @see [window.showInformationMessage showInformationMessage]
 * @see [window.showWarningMessage showWarningMessage]
 * @see [window.showErrorMessage showErrorMessage]
 */
external interface MessageOptions {
  /**
   * Indicates that this message should be modal.
   */
  var modal: Boolean?

  /**
   * Human-readable detail message that is rendered less prominent. _Note_ that detail
   * is only shown for [MessageOptions.modal modal] messages.
   */
  var detail: String?
}
