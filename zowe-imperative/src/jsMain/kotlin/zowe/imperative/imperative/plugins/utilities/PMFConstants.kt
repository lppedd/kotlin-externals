@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities

import zowe.imperative.config.Config

/**
 * Constants used by the PMF.
 */
external class PMFConstants {
  constructor()

  /**
   * The NPM package name for the command line app's core package.
   */
  val CLI_CORE_PKG_NAME: String

  /**
   * The NPM package name for the command line app's core package.
   */
  val IMPERATIVE_PKG_NAME: String

  /**
   * The namespace that we use for imperative and our CLI app.
   */
  val NPM_NAMESPACE: String

  /**
   * The root directory for all plugin related items.
   */
  val PMF_ROOT: String

  /**
   * The plugin.json config file location.
   */
  val PLUGIN_JSON: String

  /**
   * Installation directory for plugins
   */
  val PLUGIN_INSTALL_LOCATION: String

  /**
   * This stores the plugin node_module location. Since linux and windows can differ here, this will
   * be PLUGIN_INSTALL_LOCATION appended with either node_modules or lib/node_modules.
   */
  val PLUGIN_NODE_MODULE_LOCATION: Array<String>

  /**
   * Indicates if we are using a configuration file
   */
  val PLUGIN_USING_CONFIG: Boolean

  /**
   * The config object
   */
  val PLUGIN_CONFIG: Config

  /**
   * The home location for plugins
   */
  val PLUGIN_HOME_LOCATION: String

  companion object {
    /**
     * Get the singleton PMFConstants object. The first time this is requested, a new object is
     * created.
     *
     * @return The constants class
     */
    val instance: PMFConstants
  }
}
