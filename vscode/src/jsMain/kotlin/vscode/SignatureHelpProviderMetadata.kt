package vscode

import js.array.ReadonlyArray

/**
 * Metadata about a registered [SignatureHelpProvider].
 */
external interface SignatureHelpProviderMetadata {
  /**
   * List of characters that trigger signature help.
   */
  val triggerCharacters: ReadonlyArray<String>

  /**
   * List of characters that re-trigger signature help.
   *
   * These trigger characters are only active when signature help is already showing. All trigger characters
   * are also counted as re-trigger characters.
   */
  val retriggerCharacters: ReadonlyArray<String>
}
