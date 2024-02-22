@file:JsModule("@zowe/imperative")

package zowe.imperative.config

import js.promise.Promise
import zowe.imperative.*
import zowe.imperative.cmd.*
import zowe.imperative.cmd.builders.*
import zowe.imperative.cmd.constants.*
import zowe.imperative.cmd.doc.*
import zowe.imperative.cmd.doc.args.*
import zowe.imperative.cmd.doc.handler.*
import zowe.imperative.cmd.doc.option.*
import zowe.imperative.cmd.doc.parms.*
import zowe.imperative.cmd.doc.processor.*
import zowe.imperative.cmd.doc.profiles.*
import zowe.imperative.cmd.doc.profiles.definition.*
import zowe.imperative.cmd.doc.response.*
import zowe.imperative.cmd.doc.response.response.*
import zowe.imperative.cmd.handlers.*
import zowe.imperative.cmd.help.*
import zowe.imperative.cmd.help.abstract.*
import zowe.imperative.cmd.help.doc.*
import zowe.imperative.cmd.profiles.*
import zowe.imperative.cmd.response.*
import zowe.imperative.cmd.syntax.*
import zowe.imperative.cmd.types.*
import zowe.imperative.cmd.utils.*
import zowe.imperative.cmd.yargs.*
import zowe.imperative.cmd.yargs.doc.*
import zowe.imperative.config.api.*
import zowe.imperative.config.doc.*
import zowe.imperative.console.*
import zowe.imperative.console.doc.*
import zowe.imperative.constants.*
import zowe.imperative.error.*
import zowe.imperative.error.doc.*
import zowe.imperative.expect.*
import zowe.imperative.imperative.*
import zowe.imperative.imperative.api.*
import zowe.imperative.imperative.api.doc.*
import zowe.imperative.imperative.auth.builders.*
import zowe.imperative.imperative.auth.doc.*
import zowe.imperative.imperative.auth.handlers.*
import zowe.imperative.imperative.config.*
import zowe.imperative.imperative.doc.*
import zowe.imperative.imperative.env.*
import zowe.imperative.imperative.handlers.*
import zowe.imperative.imperative.help.*
import zowe.imperative.imperative.plugins.*
import zowe.imperative.imperative.plugins.cmd.install.*
import zowe.imperative.imperative.plugins.cmd.list.*
import zowe.imperative.imperative.plugins.cmd.showfirststeps.*
import zowe.imperative.imperative.plugins.cmd.uninstall.*
import zowe.imperative.imperative.plugins.cmd.update.*
import zowe.imperative.imperative.plugins.cmd.validate.*
import zowe.imperative.imperative.plugins.doc.*
import zowe.imperative.imperative.plugins.errors.*
import zowe.imperative.imperative.plugins.utilities.*
import zowe.imperative.imperative.profiles.*
import zowe.imperative.imperative.profiles.builders.*
import zowe.imperative.imperative.profiles.handlers.*
import zowe.imperative.interfaces.doc.*
import zowe.imperative.interfaces.types.*
import zowe.imperative.io.*
import zowe.imperative.logger.*
import zowe.imperative.logger.doc.*
import zowe.imperative.messages.*
import zowe.imperative.messages.doc.*
import zowe.imperative.operations.*
import zowe.imperative.operations.doc.*
import zowe.imperative.profiles.*
import zowe.imperative.profiles.abstract.*
import zowe.imperative.profiles.constants.*
import zowe.imperative.profiles.doc.api.*
import zowe.imperative.profiles.doc.config.*
import zowe.imperative.profiles.doc.definition.*
import zowe.imperative.profiles.doc.parms.*
import zowe.imperative.profiles.doc.response.*
import zowe.imperative.profiles.utils.*
import zowe.imperative.profiles.validation.api.*
import zowe.imperative.profiles.validation.doc.*
import zowe.imperative.rest.client.*
import zowe.imperative.rest.client.doc.*
import zowe.imperative.rest.client.types.*
import zowe.imperative.rest.session.*
import zowe.imperative.rest.session.doc.*
import zowe.imperative.security.*
import zowe.imperative.security.abstract.*
import zowe.imperative.security.doc.*
import zowe.imperative.security.errors.*
import zowe.imperative.settings.*
import zowe.imperative.settings.doc.*
import zowe.imperative.settings.errors.*
import zowe.imperative.settings.persistance.*
import zowe.imperative.utilities.*
import zowe.imperative.utilities.diff.*
import zowe.imperative.utilities.diff.doc.*
import zowe.imperative.utilities.doc.*

/**
 * The Config class provides facilities for reading and writing team configuration files. It is used
 * by Imperative to perform low-level operations on a team configuration. The intent is that
 * consumer apps will not typically use the Config class, since end-users are expected to write team
 * configuration files by directly editing them in an editor like VSCode.
 */
external class Config {
  var opts: IConfigOpts?

  /**
   * Reload config files from disk in the current project directory.
   *
   * @param opts Options to control how Config class behaves
   * @throws ImperativeError if the configuration does not load successfully
   */
  fun reload(opts: IConfigOpts = definedExternally): Promise<Unit>

  /**
   * Save config files to disk and store secure properties in vault.
   *
   * @param allLayers Specify true to save all config layers instead of only the active one
   */
  fun save(allLayers: Boolean = definedExternally): Promise<Unit>

  /**
   * Access the config API for manipulating profiles, plugins, layers, and secure values.
   */
  val api: ConfigApi

  /**
   * True if any config layers exist on disk, otherwise false.
   */
  val exists: Boolean

  /**
   * List of absolute file paths for all config layers.
   */
  val paths: Array<String>

  /**
   * List of all config layers. Returns a clone to prevent accidental edits of the original object.
   */
  val layers: Array<IConfigLayer>

  /**
   * List of properties across all config layers. Returns a clone to prevent accidental edits of the
   * original object.
   */
  val properties: IConfig

  /**
   * App name used in config filenames (e.g., *my_cli*.config.json)
   */
  val appName: String

  /**
   * Filename used for config JSONC files
   */
  val configName: String

  /**
   * Filename used for user config JSONC files
   */
  val userConfigName: String

  /**
   * Filename used for config schema JSON files
   */
  val schemaName: String

  /**
   * Schema file path used by the active layer
   */
  fun getSchemaInfo(): IConfigSchemaInfo

  /**
   * The properties object with secure values masked.
   */
  val maskedProperties: IConfig

  /**
   * Set value of a property in the active config layer.
   *
   * @param propertyPath Property path
   * @param value Property value
   * @param opts Optional parameters to change behavior
   *   - `parseString` - If true, strings will be converted to a more specific type like boolean or
   *     number when possible
   *   - `secure` - If true, the property will be stored securely. If false, the property will be
   *     stored in plain text.
   *
   * TODO: more validation
   */
  fun set(
    propertyPath: String,
    value: Any?,
    opts: ConfigSetOpts = definedExternally,
  )

  /**
   * Unset value of a property in the active config layer.
   *
   * @param propertyPath Property path
   * @param opts Include `secure: false` to preserve property in secure array
   */
  fun delete(
    propertyPath: String,
    opts: ConfigDeleteOpts = definedExternally,
  )

  /**
   * Set the $schema value at the top of the config JSONC.
   * Also save the schema to disk if an object is provided.
   *
   * @param schema The URI of JSON schema, or a schema object to use
   */
  fun setSchema(schema: String)

  /**
   * Set the $schema value at the top of the config JSONC.
   * Also save the schema to disk if an object is provided.
   *
   * @param schema The URI of JSON schema, or a schema object to use
   */
  fun setSchema(schema: Any)

  /**
   * Check if a layer exists in the given path
   *
   * @param inDir The directory to which you want to look for the layer.
   */
  fun layerExists(
    inDir: String,
    user: Boolean = definedExternally,
  ): Boolean

  /**
   * Form the path name of the team config file to display in messages. Always return the team name
   * (not the user name). If the a team configuration is active, return the full path to the config
   * file.
   *
   * @param options a map containing option properties.
   *   Currently, the only property supported is a boolean named addPath. {addPath: true | false}
   * @return The path (if requested) and file name of the team config file.
   */
  fun formMainConfigPathNm(options: Any?): String

  companion object {
    /**
     * Return a Config interface with required fields initialized as empty.
     */
    fun empty(): IConfig

    /**
     * Load config files from disk and secure properties from vault.
     *
     * @param app App name used in config filenames (e.g., *my_cli*.config.json)
     * @param opts Options to control how Config class behaves
     * @throws ImperativeError if the configuration does not load successfully
     */
    fun load(
      app: String,
      opts: IConfigOpts = definedExternally,
    ): Promise<Config>

    /**
     * Search up the directory tree for the directory containing the specified config file.
     *
     * @param file Contains the name of the desired config file
     * @param opts.ignoreDirs Contains an array of directory names to be ignored (skipped) during the search.
     * @param opts.startDir Contains the name of the directory where the search should be started.
     *   Defaults to working directory.
     * @return The full path name to config file or null if not found.
     */
    fun search(
      file: String,
      opts: ConfigSearchOpts = definedExternally,
    ): String
  }
}
