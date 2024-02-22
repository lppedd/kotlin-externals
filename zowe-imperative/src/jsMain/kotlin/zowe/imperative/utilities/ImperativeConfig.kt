@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import js.objects.Record
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileSchema
import zowe.imperative.config.Config
import zowe.imperative.imperative.doc.IDaemonContext
import zowe.imperative.imperative.doc.IImperativeConfig

/**
 * This class is used to contain all configuration being set by Imperative. It is a singleton and
 * should be accessed via ImperativeConfig.instance.
 */
external class ImperativeConfig {
  /**
   * Get the configured environmental variable prefix for the user's CLI
   *
   * @return the configured or default prefix for environmental variables for use in the
   *   environmental variable service
   */
  val envVariablePrefix: String

  /**
   * Set the caller location.
   */
  var callerLocation: String

  /**
   * Set the loaded config data.
   */
  var loadedConfig: IImperativeConfig

  /**
   * Set our root command name.
   */
  var rootCommandName: String

  /**
   * Retrieve the host package name from which imperative was called.
   */
  val hostPackageName: String

  /**
   * Retrieve the package name of the imperative application.
   */
  val imperativePackageName: String

  /**
   * Parses the package.json file and searches for the symlink name used under "bin".
   *
   * @return return bin symlink name if present, otherwise null
   */
  fun findPackageBinName(): String

  /**
   * Return the cli Home path.
   */
  val cliHome: String

  /**
   * Return profile Directory.
   */
  val profileDir: String

  /**
   * Return package.json of the imperative user
   */
  val callerPackageJson: Any?

  /**
   * Retrieve the command line.
   *
   * For example, in "banana a b --c", "a b --c" is the command line.
   */
  var commandLine: String

  /**
   * Set context for daemon to retrieve if no handler is called.
   */
  var daemonContext: IDaemonContext

  /**
   * Set the config
   */
  var config: Config

  /**
   * Require a file from a project using imperative accounting for imperative being contained
   * separately from the current implementers directory.
   *
   * @param file the file to require from project using imperative
   */
  fun getCallerFile(file: String): Any?

  /**
   * @return a key/value object where the key is the profile type and the value is the profile type schema
   */
  val profileSchemas: Record<String, ICommandProfileSchema>

  companion object {
    /**
     * Gets a single instance of the PluginIssues. On the first call of ImperativeConfig.instance, a
     * new Plugin Issues object is initialized and returned. Every subsequent call will use the one
     * that was first created.
     *
     * @return The newly initialized PMF object.
     */
    val instance: ImperativeConfig
  }
}
