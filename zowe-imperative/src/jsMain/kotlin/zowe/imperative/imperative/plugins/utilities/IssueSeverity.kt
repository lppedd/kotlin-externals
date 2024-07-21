package zowe.imperative.imperative.plugins.utilities

import seskar.js.JsValue

/**
 * This enum represents the possible severity types of a plugin issue.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface IssueSeverity {
  companion object {
    /**
     * Configuration errors. We cannot even properly define this plugin. The plugin cannot be used.
     */
    @JsValue("CfgError")
    val CFG_ERROR: IssueSeverity

    /**
     * An error in a plugin's set of commands. The plugin's commands will not be loaded into the
     * host CLI app. It's overrides may be used.
     */
    @JsValue("CmdError")
    val CMD_ERROR: IssueSeverity

    /**
     * An error in a plugin's override component. The plugin's overrides will not be used by
     * imperative It's commands may be added to the host CLI app.
     */
    @JsValue("OverrideError")
    val OVER_ERROR: IssueSeverity

    /**
     * Warnings identify optional items not implemented by a plugin.
     */
    @JsValue("Warning")
    val WARNING: IssueSeverity
  }
}
