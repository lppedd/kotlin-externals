package vscode

import seskar.js.JsIntValue

/**
 * Describes how an [InlineCompletionItemProvider] was triggered.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface InlineCompletionTriggerKind {
  companion object {
    /**
     * Completion was triggered explicitly by a user gesture.
     * Return multiple completion items to enable cycling through them.
     */
    @JsIntValue(0)
    val Invoke: InlineCompletionTriggerKind

    /**
     * Completion was triggered automatically while editing.
     * It is sufficient to return a single completion item in this case.
     */
    @JsIntValue(1)
    val Automatic: InlineCompletionTriggerKind
  }
}
