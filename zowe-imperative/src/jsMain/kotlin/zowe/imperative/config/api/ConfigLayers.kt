@file:JsModule("@zowe/imperative")

package zowe.imperative.config.api

import zowe.imperative.config.doc.IConfig
import zowe.imperative.config.doc.IConfigLayer
import kotlin.ts.Union

/**
 * API Class for manipulating config layers.
 */
external class ConfigLayers : ConfigApi {
  /**
   * Read a config layer from disk into memory for application use.
   *
   * @param opts The user and global flags that indicate which of the four config files (aka layers)
   *   is to be read.
   */
  fun read(opts: ConfigLayersReadOpts = definedExternally)

  /**
   * Write a config layer to disk.
   *
   * @param opts The user and global flags that indicate which of the four config files (aka layers)
   *   is to be written.
   */
  fun write(opts: ConfigLayersWriteOpts = definedExternally)

  /**
   * Select which layer is the currently active layer.
   *
   * @param user True if you want the user layer.
   * @param global True if you want the global layer.
   * @param inDir The directory to which you want to set the file path for this layer.
   */
  fun activate(
    user: Boolean,
    global: Boolean,
    inDir: String = definedExternally,
  )

  /**
   * Gets a json object that represents the currently active layer.
   *
   * @return The json object
   */
  fun get(): IConfigLayer

  /**
   * Set the the currently active layer to the supplied json object.
   */
  fun set(cnfg: IConfig)

  /**
   * Merge properties from the supplied Config object into the active layer. If dryRun is specified,
   * merge is applied to a copy of the layer and returned. If dryRun is not specified, merge is
   * applied directly to the layer and nothing is returned.
   *
   * @param cnfg The Config object to merge.
   * @return The merged config layer or void
   */
  fun merge(
    cnfg: IConfig,
    dryRun: Boolean = definedExternally,
  ): Union<Unit, IConfigLayer>

  /**
   * Finds the highest priority layer where a profile is stored.
   *
   * @param profileName Profile name to search for
   * @return User and global properties, or undefined if profile does not exist
   */
  fun find(profileName: String): ConfigLayersFindResult
}
