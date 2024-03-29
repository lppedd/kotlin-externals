package vscode

/**
 * Represents an action that is shown with an information, warning, or
 * error message.
 *
 * @see [window.showInformationMessage showInformationMessage]
 * @see [window.showWarningMessage showWarningMessage]
 * @see [window.showErrorMessage showErrorMessage]
 */
external interface MessageItem {
  /**
   * A short title like 'Retry', 'Open Log' etc.
   */
  var title: String

  /**
   * A hint for modal dialogs that the item should be triggered
   * when the user cancels the dialog (e.g. by pressing the ESC
   * key).
   *
   * Note: this option is ignored for non-modal messages.
   */
  var isCloseAffordance: Boolean?
}
