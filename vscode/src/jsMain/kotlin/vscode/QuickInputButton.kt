package vscode

/**
 * Button for an action in a [QuickPick} or {@link InputBox].
 */

external interface QuickInputButton {
  /**
   * Icon for the button.
   */
  val iconPath: Any /* Uri | {
    light: Uri;
    dark: Uri;
} | ThemeIcon */

  /**
   * An optional tooltip.
   */
  val tooltip: String?
}
