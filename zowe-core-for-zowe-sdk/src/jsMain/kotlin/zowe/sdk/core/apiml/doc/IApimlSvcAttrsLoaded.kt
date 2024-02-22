package zowe.sdk.core.apiml.doc

import zowe.imperative.imperative.doc.IApimlSvcAttrs
import kotlin.js.plain.JsPlainObject

/**
 * Once getPluginApimlConfigs() has processed the loaded ImperativeConfig,
 * and plugin properties, it returns an array of these structures.
 */
@JsPlainObject
external interface IApimlSvcAttrsLoaded : IApimlSvcAttrs {
  /**
   * Once getPluginApimlConfigs() has processed the loaded ImperativeConfig,
   * the connProfType will be a required property in the resulting object.
   */
  override var connProfType: String?

  /**
   * The plugin name from which these attributes were retrieved.
   * If retrieved from the core CLI, then the CLI name is used.
   */
  var pluginName: String
}
