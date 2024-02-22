@file:JsModule("@zowe/imperative")

package zowe.imperative.config

import js.promise.Promise
import node.Module
import zowe.imperative.config.doc.IProfOpts
import zowe.imperative.security.doc.ICredentialManagerInit

external class ProfileCredentials {
  constructor(mProfileInfo: ProfileInfo, opts: IProfOpts = definedExternally)

  constructor(mProfileInfo: ProfileInfo, opts: () -> Module = definedExternally)

  /**
   * Check if secure credentials will be encrypted or stored in plain text. If using team config,
   * this will always return true. If using classic profiles, this will check whether a custom
   * CredentialManager is defined in the Imperative settings.json file.
   */
  val isSecured: Boolean

  /**
   * Initialize credential manager to be used for secure credential storage. This method throws if
   * ProfileCredentials.isSecured is false. If the CredentialManagerFactory is already initialized,
   * it is reused since it is not possible to reinitialize.
   */
  fun loadManager(): Promise<Unit>

  companion object {
    /**
     * Given a custom method to require Keytar, return an object that defines credential manager
     * settings to replace the default credential manager. If the credential manager is not
     * overridden, the default implementation is to `require("keytar")` from the caller app's
     * node_modules folder.
     *
     * @param requireKeytar Callback to require Keytar module for managing secure credentials
     * @return Credential manager settings with Keytar module overridden
     */
    fun defaultCredMgrWithKeytar(requireKeytar: () -> Module): ICredentialManagerInit
  }
}
