@file:JsModule("@zowe/imperative")

package zowe.imperative.security

import zowe.imperative.error.ImperativeError
import zowe.imperative.security.doc.ICredentialManagerNameMap

/**
 * This class provides access to the known set of credential manager overrides and functions to
 * manipulate which credential manager is in use. Other credential managers can replace the default
 * credential manager. Both CLI plugins and Zowe Explorer extensions can override the default
 * credential manager. However, only one credential manager will be in effect on a given computer.
 * The last component to override the credential manager wins.
 */
external class CredentialManagerOverride {
  companion object {
    val CRED_MGR_SETTING_NAME: String
    val DEFAULT_CRED_MGR_NAME: String

    /**
     * Get the credential manager information for the specified credential manager display name.
     *
     * @param credMgrDisplayName display name of the credential manager
     * @return An ICredentialManagerNameMap or null if the specified plugin is not a known
     *   credential manager.
     */
    fun getCredMgrInfoByDisplayName(credMgrDisplayName: String): ICredentialManagerNameMap?

    /**
     * Get the credential manager information for the specified plugin.
     *
     * @param pluginName Name of the plugin package
     * @return An ICredentialManagerNameMap or null if the specified plugin is not a known
     *   credential manager.
     */
    fun getCredMgrInfoByPlugin(pluginName: String): ICredentialManagerNameMap?

    /**
     * Get the credential manager information for the specified plugin.
     *
     * @param ZEExtName Name of the Zowe Explorer extension
     * @return An ICredentialManagerNameMap or null if the specified extension is not a known
     *   credential manager.
     */
    fun getCredMgrInfoByZEExt(ZEExtName: String): ICredentialManagerNameMap?

    /**
     * Get the known credential managers.
     *
     * @return An array of credential managers.
     */
    fun getKnownCredMgrs(): Array<ICredentialManagerNameMap>

    /**
     * Record the specified credential manager in the configuration of overrides. A plugin or ZE
     * extension that provides a credential manager would record its credential manager name upon
     * installation.
     *
     * @param newCredMgrName The display name of your credential manager.
     * @throws ImperativeError upon error.
     */
    fun recordCredMgrInConfig(newCredMgrName: String)

    /**
     * Record the default Zowe CLI credential manager in the configuration of overrides. The
     * specified credential manager will be replaced with the default Zowe CLI credential manager. A
     * plugin or ZE extension that provides a credential manager would replace itself with the
     * default credential manager when it is being uninstalled.
     *
     * @param credMgrToReplace The display name of your credential manager. This name must also be
     *   the credential manager currently recorded in the configuration of overrides. Otherwise, no
     *   replacement will be performed. Specifying your own name is intended to prevent a plugin
     *   from inadvertently replacing another plugin's credential manager.
     * @throws ImperativeError upon error.
     */
    fun recordDefaultCredMgrInConfig(credMgrToReplace: String)
  }
}
