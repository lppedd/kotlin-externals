package zowe.imperative.security.doc

import kotlin.js.plain.JsPlainObject

/**
 * This interface represents the association of plugin name, VS Code extension name, and credential
 * manager override name for components that override the default credential manager. Our imperative
 * module will keep a list of known plugins and VS Code extensions that can override the default
 * credential manager. The name of the default credential manager will also be in that list.
 * Imperative will be able to use this name mapping to identify the correct plugin or extension
 * which provides a given credential manager override.
 */
@JsPlainObject
external interface ICredentialManagerNameMap {
  /**
   * Name of the credential manager.
   * This is the name that will be stored in $ZOWE_CLI_HOME/settings/imperative.json.
   */
  var credMgrDisplayName: String

  /**
   * Name of the plugin that supplies the credential manager override software.
   * A credential manager supplier must supply a CLI plugin, or a ZE extension, or both.
   */
  var credMgrPluginName: String?

  /**
   * Name of the Zowe Explorer extension that supplies the credential manager override software.
   * A credential manager supplier must supply a CLI plugin, or a ZE extension, or both.
   */
  var credMgrZEName: String?
}
