package vscode

/**
 * Represents a storage utility for secrets, information that is
 * sensitive.
 */

external interface SecretStorage {
  /**
   * Retrieve a secret that was stored with key. Returns undefined if there
   * is no password matching that key.
   * @param key The key the secret was stored under.
   * @return The stored value or `undefined`.
   */
  fun get(key: String): Thenable<String?>

  /**
   * Store a secret under a given key.
   * @param key The key to store the secret under.
   * @param value The secret.
   */
  fun store(
    key: String,
    value: String,
  ): Thenable<Unit>

  /**
   * Remove a secret from storage.
   * @param key The key the secret was stored under.
   */
  fun delete(key: String): Thenable<Unit>

  /**
   * Fires when a secret is stored or deleted.
   */
  var onDidChange: Event<SecretStorageChangeEvent>
}
