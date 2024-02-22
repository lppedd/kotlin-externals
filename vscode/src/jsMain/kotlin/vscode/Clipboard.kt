package vscode

/**
 * The clipboard provides read and write access to the system's clipboard.
 */
external interface Clipboard {
  /**
   * Read the current clipboard contents as text.
   * @return A thenable that resolves to a string.
   */
  fun readText(): Thenable<String>

  /**
   * Writes text into the clipboard.
   * @return A thenable that resolves when writing happened.
   */
  fun writeText(value: String): Thenable<Unit>
}
