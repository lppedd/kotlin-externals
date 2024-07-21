package vscode

import seskar.js.JsIntValue

/**
 * Represents the type of user feedback received.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ChatResultFeedbackKind {
  companion object {
    /**
     * The user marked the result as unhelpful.
     */
    @JsIntValue(0)
    val Unhelpful: ChatResultFeedbackKind

    /**
     * The user marked the result as helpful.
     */
    @JsIntValue(1)
    val Helpful: ChatResultFeedbackKind
  }
}
