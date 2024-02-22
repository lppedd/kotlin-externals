package vscode

/**
 * Defines a port mapping used for localhost inside the webview.
 */
external interface WebviewPortMapping {
  /**
   * Localhost port to remap inside the webview.
   */
  val webviewPort: Double

  /**
   * Destination port. The `webviewPort` is resolved to this port.
   */
  val extensionHostPort: Double
}
