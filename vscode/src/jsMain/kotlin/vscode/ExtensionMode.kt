@file:JsModule("vscode")

package vscode

/**
 * The ExtensionMode is provided on the `ExtensionContext` and indicates the
 * mode the specific extension is running in.
 */

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ExtensionMode {
  companion object {
    /**
     * The extension is installed normally (for example, from the marketplace
     * or VSIX) in the editor.
     */
    val Production: ExtensionMode

    /**
     * The extension is running from an `--extensionDevelopmentPath` provided
     * when launching the editor.
     */
    val Development: ExtensionMode

    /**
     * The extension is running from an `--extensionTestsPath` and
     * the extension host is running unit tests.
     */
    val Test: ExtensionMode
  }
}
