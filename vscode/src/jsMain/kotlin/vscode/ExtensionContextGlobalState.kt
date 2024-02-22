package vscode

external interface ExtensionContextGlobalState : Memento {
/**
   * Set the keys whose values should be synchronized across devices when synchronizing user-data
   * like configuration, extensions, and mementos.
   *
   * Note that this function defines the whole set of keys whose values are synchronized:
   *  - calling it with an empty array stops synchronization for this memento
   *  - calling it with a non-empty array replaces all keys whose values are synchronized
   *
   * For any given set of keys this function needs to be called only once but there is no harm in
   * repeatedly calling it.
   *
   * @param keys The set of keys whose values are synced.
   */
  fun setKeysForSync(keys: Array<out String>): Unit
}
