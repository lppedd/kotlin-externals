package vscode

/**
 * Additional information about the context in which a
 * `SignatureHelpProvider` ([SignatureHelpProvider.provideSignatureHelp]) was triggered.
 */
external interface SignatureHelpContext {
  /**
   * Action that caused signature help to be triggered.
   */
  val triggerKind: SignatureHelpTriggerKind

  /**
   * Character that caused signature help to be triggered.
   *
   * This is `undefined` when signature help is not triggered by typing, such as when manually invoking
   * signature help or when moving the cursor.
   */
  val triggerCharacter: String?

  /**
   * `true` if signature help was already showing when it was triggered.
   *
   * Retriggers occur when the signature help is already active and can be caused by actions such as
   * typing a trigger character, a cursor move, or document content changes.
   */
  val isRetrigger: Boolean

  /**
   * The currently active [SignatureHelp].
   *
   * The `activeSignatureHelp` has its [SignatureHelp.activeSignature] field updated based on
   * the user arrowing through available signatures.
   */
  val activeSignatureHelp: SignatureHelp?
}
