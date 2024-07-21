package vscode

import seskar.js.JsIntValue

/**
 * How a [CompletionItemProvider] was triggered
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface CompletionTriggerKind {
  companion object {
    /**
     * Completion was triggered normally.
     */
    @JsIntValue(0)
    val Invoke: CompletionTriggerKind

    /**
     * Completion was triggered by a trigger character.
     */
    @JsIntValue(1)
    val TriggerCharacter: CompletionTriggerKind

    /**
     * Completion was re-triggered as current completion list is incomplete
     */
    @JsIntValue(2)
    val TriggerForIncompleteCompletions: CompletionTriggerKind
  }
}
