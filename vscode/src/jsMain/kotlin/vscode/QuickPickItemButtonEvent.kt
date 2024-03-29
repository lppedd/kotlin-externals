package vscode

/**
 * An event signaling when a button in a particular [QuickPickItem] was triggered.
 * This event does not fire for buttons in the title bar.
 */
external interface QuickPickItemButtonEvent<T : QuickPickItem> {
  /**
   * The button that was clicked.
   */
  val button: QuickInputButton

  /**
   * The item that the button belongs to.
   */
  val item: T
}
