@file:JsModule("vscode")

package vscode

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * The ExtensionMode is provided on the `ExtensionContext` and indicates the
 * mode the specific extension is running in.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ExtensionMode {
  companion object {
    /**
     * The extension is installed normally (for example, from the marketplace
     * or VSIX) in the editor.
     */
    @JsIntValue(1)
    val Production: ExtensionMode

    /**
     * The extension is running from an `--extensionDevelopmentPath` provided
     * when launching the editor.
     */
    @JsIntValue(2)
    val Development: ExtensionMode

    /**
     * The extension is running from an `--extensionTestsPath` and
     * the extension host is running unit tests.
     */
    @JsIntValue(3)
    val Test: ExtensionMode
  }
}
