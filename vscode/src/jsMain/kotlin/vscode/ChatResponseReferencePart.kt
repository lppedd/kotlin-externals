@file:JsModule("vscode")

package vscode

import kotlin.ts.Union
import kotlin.ts.Union3

/**
 * Represents a part of a chat response that is a reference, rendered separately from the content.
 */
external class ChatResponseReferencePart {
  /**
   * Create a new [ChatResponseReferencePart].
   *
   * @param value A uri or location
   * @param iconPath Icon for the reference shown in UI
   */
  constructor(value: Union<Uri, Location>, iconPath: Union3<Uri, ThemeIcon, ThemeUris> = definedExternally)

  /**
   * The reference target.
   */
  var `value`: Union<Uri, Location>

  /**
   * The icon for the reference.
   */
  var iconPath: Union3<Uri, ThemeIcon, ThemeUris>?
}
