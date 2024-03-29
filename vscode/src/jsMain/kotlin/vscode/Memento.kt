package vscode

import js.array.ReadonlyArray

/**
 * A memento represents a storage utility. It can store and retrieve
 * values.
 */
external interface Memento {
  /**
   * Returns the stored keys.
   *
   * @return The stored keys.
   */
  fun keys(): ReadonlyArray<String>

  /**
   * Return a value.
   *
   * @param key A string.
   * @return The stored value or `undefined`.
   */
  fun <T> get(key: String): T?

  /**
   * Return a value.
   *
   * @param key A string.
   * @param defaultValue A value that should be returned when there is no
   *   value (`undefined`) with the given key.
   * @return The stored value or the defaultValue.
   */
  fun <T> get(
    key: String,
    defaultValue: T,
  ): T

  /**
   * Store a value. The value must be JSON-stringifyable.
   *
   * *Note* that using `undefined` as value removes the key from the underlying
   * storage.
   *
   * @param key A string.
   * @param value A value. MUST not contain cyclic references.
   */
  fun update(
    key: String,
    value: Any?,
  ): Thenable<Unit>
}
