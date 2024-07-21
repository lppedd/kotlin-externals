package vscode

import seskar.js.JsIntValue

/**
 * The configuration target
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ConfigurationTarget {
  companion object {
    /**
     * Global configuration
     */
    @JsIntValue(1)
    val Global: ConfigurationTarget

    /**
     * Workspace configuration
     */
    @JsIntValue(2)
    val Workspace: ConfigurationTarget

    /**
     * Workspace folder configuration
     */
    @JsIntValue(3)
    val WorkspaceFolder: ConfigurationTarget
  }
}
