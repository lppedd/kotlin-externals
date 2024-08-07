@file:JsModule("vscode")

package vscode

/**
 * A link on a terminal line.
 */
open external class TerminalLink {
  /**
   * Creates a new terminal link.
   *
   * @param startIndex The start index of the link on [TerminalLinkContext.line].
   * @param length The length of the link on [TerminalLinkContext.line].
   * @param tooltip The tooltip text when you hover over this link.
   *   If a tooltip is provided, is will be displayed in a string that includes instructions on
   *   how to trigger the link, such as `{0} (ctrl + click)`. The specific instructions vary
   *   depending on OS, user settings, and localization.
   */
  constructor(startIndex: Int, length: Int, tooltip: String = definedExternally)

  /**
   * The start index of the link on [TerminalLinkContext.line].
   */
  var startIndex: Int

  /**
   * The length of the link on [TerminalLinkContext.line].
   */
  var length: Int

  /**
   * The tooltip text when you hover over this link.
   *
   * If a tooltip is provided, is will be displayed in a string that includes instructions on
   * how to trigger the link, such as `{0} (ctrl + click)`. The specific instructions vary
   * depending on OS, user settings, and localization.
   */
  var tooltip: String?
}
