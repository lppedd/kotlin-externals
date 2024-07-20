@file:JsModule("vscode")

package vscode

import kotlin.ts.Union

/**
 * Represents a part of a chat response that is an anchor, that is rendered as a link to a target.
 */
external class ChatResponseAnchorPart {
  /**
   * Create a new ChatResponseAnchorPart.
   *
   * @param value A uri or location.
   * @param title An optional title that is rendered with value.
   */
  constructor(value: Union<Uri, Location>, title: String? = definedExternally)

  /**
   * The target of this anchor.
   */
  var `value`: Union<Uri, Location>

  /**
   * An optional title that is rendered with value.
   */
  var title: String?
}
