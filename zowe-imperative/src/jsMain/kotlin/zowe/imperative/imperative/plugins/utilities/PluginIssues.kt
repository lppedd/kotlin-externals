@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities

import zowe.imperative.imperative.plugins.doc.IPluginIssue
import zowe.imperative.imperative.plugins.doc.IPluginIssues
import zowe.imperative.imperative.plugins.doc.IPluginJson

/**
 * This class is used to record and access plugin errors and warnings. It is a singleton and should
 * be accessed via PluginIssues.instance.
 */
external class PluginIssues {
  /**
   * Reports whether or not a plugin has any issues with any of the specified severities.
   *
   * @param pluginName The name of the plugin
   * @param issueSevs An array of issue severities.
   * @return True if any plugin issues have any of the severities. False otherwise.
   */
  fun doesPluginHaveIssueSev(
    pluginName: String,
    issueSevs: Array<IssueSeverity>,
  ): Boolean

  /**
   * Get the issues recorded for all plugins.
   *
   * @return Map of plugin names to their array of issues.
   */
  fun getAllIssues(): IPluginIssues

  /**
   * Get the set of installed plugins. This function should be the only means used to access our
   * installedPlugins class variable.
   *
   * @return The set of installed plugins.
   */
  fun getInstalledPlugins(): IPluginJson

  /**
   * Get the array of issues for the specified plugin.
   *
   * @param pluginName The name of the plugin
   * @return Array of issues for the plugin. If no issues, an empty array is returned.
   */
  fun getIssueListForPlugin(pluginName: String): Array<IPluginIssue>

  /**
   * Remove the specified plugin from the collection of plugin issues.
   *
   * @param pluginName The name of the plugin to remove
   */
  fun removeIssuesForPlugin(pluginName: String)

  /**
   * Record an issue that was discovered in a plugin into an in-memory structure. The plugin issues
   * can later be accessed to report the health of a plugin.
   *
   * @param pluginName The name of the plugin
   * @param issueSev The severity of the issue. Use PluginIssues.ERROR or PluginIssues.WARNING
   * @param issueText The issue message text to record.
   */
  fun recordIssue(
    pluginName: String,
    issueSev: IssueSeverity,
    issueText: String,
  )

  companion object {
    /**
     * Gets a single instance of the PluginIssues. On the first call of PluginIssues.instance, a new
     * Plugin Issues object is initialized and returned. Every subsequent call will use the one that
     * was first created.
     *
     * @return The newly initialized PMF object.
     */
    val instance: PluginIssues
  }
}
