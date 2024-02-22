@file:JsModule("vscode")

package vscode

/**
 * Describes how an [InlineCompletionItemProvider inline completion provider] was triggered.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface InlineCompletionTriggerKind {
  companion object {
/**
     * Completion was triggered explicitly by a user gesture.
     * Return multiple completion items to enable cycling through them.
     */
    val Invoke: InlineCompletionTriggerKind

/**
     * Completion was triggered automatically while editing.
     * It is sufficient to return a single completion item in this case.
     */
    val Automatic: InlineCompletionTriggerKind
  }
}