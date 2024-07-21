package vscode

import seskar.js.JsIntValue

/**
 * How a [SignatureHelpProvider] was triggered.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface SignatureHelpTriggerKind {
  companion object {
    /**
     * Signature help was invoked manually by the user or by a command.
     */
    @JsIntValue(1)
    val Invoke: SignatureHelpTriggerKind

    /**
     * Signature help was triggered by a trigger character.
     */
    @JsIntValue(2)
    val TriggerCharacter: SignatureHelpTriggerKind

    /**
     * Signature help was triggered by the cursor moving or by the document content changing.
     */
    @JsIntValue(3)
    val ContentChange: SignatureHelpTriggerKind
  }
}
