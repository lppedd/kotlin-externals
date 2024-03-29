package vscode

/**
 * The shell quoting options.
 */
external interface ShellQuotingOptions {
  /**
   * The character used to do character escaping. If a string is provided only spaces
   * are escaped. If a `{ escapeChar, charsToEscape }` literal is provide all characters
   * in `charsToEscape` are escaped using the `escapeChar`.
   */
  // TODO(Edoardo): split into 2 interfaces
  var escape: (Any /* string | { escapeChar: string; charsToEscape: string; } */)?

  /**
   * The character used for strong quoting. The string's length must be 1.
   */
  var strong: String?

  /**
   * The character used for weak quoting. The string's length must be 1.
   */
  var weak: String?
}
