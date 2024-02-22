@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.imperative.doc.IImperativeOverrides
import zowe.imperative.imperative.plugins.doc.IPluginCfgProps

/**
 * This class is the main engine for the Plugin Management Facility. The underlying class should be
 * treated as a singleton and should be accessed via PluginManagmentFacility.instance.
 */
external class PluginManagementFacility {
  /**
   * Get the set of configuration properties for all loaded plugins.
   */
  val allPluginCfgProps: Array<IPluginCfgProps>

  /**
   * Object that defines what overrides will be provided by all plugins.
   */
  val pluginOverrides: IImperativeOverrides

  /**
   * Initialize the PMF. Must be called to enable the various commands provided by the facility.
   */
  fun init()

  /**
   * Add all installed plugins' commands and profiles into the host CLI's command tree.
   *
   * @param resolvedCliCmdTree The CLI command tree with module globs already resolved.
   */
  fun addAllPluginsToHostCli(resolvedCliCmdTree: ICommandDefinition)

  /**
   * Loads the configuration properties of each plugin. The configuration information is used when
   * overriding a piece of the imperative infrastructure with a plugin's capability, when validating
   * each plugin, and when adding each plugin's commands to the CLI command tree. Errors are
   * recorded in PluginIssues.
   */
  fun loadAllPluginCfgProps()

  /**
   * Produces a function that requires a module from a plugin using a relative path name from the
   * plugin's root to the module. Used as a callback function from the ConfigurationLoader to load
   * configuration handlers.
   *
   * @param pluginName The name of the plugin/module to load.
   * @return The method responsible for requiring the module
   */
  fun requirePluginModuleCallback(pluginName: String): ((relativePath: String) -> Any?)

  companion object {
    /**
     * Gets a single instance of the PMF. On the first call of PluginManagementFacility.instance, a
     * new PMF is initialized and returned. Every subsequent call will use the one that was first
     * created.
     *
     * @return The newly initialized PMF object.
     */
    val instance: PluginManagementFacility
  }
}
