package vscode

/**
 * The event data that is fired when a secret is added or removed.
 */
external interface SecretStorageChangeEvent {
  /**
   * The key of the secret that has changed.
   */
  val key: String
}
