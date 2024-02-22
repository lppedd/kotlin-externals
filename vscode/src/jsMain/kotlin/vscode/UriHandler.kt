package vscode

/**
 * A uri handler is responsible for handling system-wide [Uri]s.
 *
 * @see [vscode.window.registerUriHandler].
 */
external interface UriHandler {
  /**
   * Handle the provided system-wide [Uri].
   *
   * @see [vscode.window.registerUriHandler].
   */
  fun handleUri(uri: Uri): ProviderResult<Unit>
}
