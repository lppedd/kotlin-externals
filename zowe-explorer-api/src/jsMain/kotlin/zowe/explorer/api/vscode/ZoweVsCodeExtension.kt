@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.vscode

import js.promise.Promise
import vscode.InputBoxOptions
import zowe.explorer.api.logger.IZoweLogger
import zowe.explorer.api.logger.MessageSeverity
import zowe.explorer.api.profiles.ProfilesCache
import zowe.explorer.api.profiles.ZoweExplorerApi
import zowe.explorer.api.tree.IZoweTreeNode
import zowe.explorer.api.vscode.doc.IPromptCredentialsOptions
import zowe.imperative.profiles.doc.response.IProfileLoaded

/**
 * Collection of utility functions for writing Zowe Explorer VS Code extensions.
 */
external class ZoweVsCodeExtension {
  companion object {
    /**
     * Get custom logging path if one is defined in VS Code settings.
     */
    val customLoggingPath: String?

    /**
     * @param requiredVersion Optional semver string specifying the minimal required version
     *           of Zowe Explorer that needs to be installed for the API to be usable to the client.
     * @return an initialized instance `ZoweExplorerApi.IApiRegisterClient` that extenders can use
     *          to access the Zowe Explorer APIs or `undefined`. Also `undefined` if requiredVersion
     *          is larger than the version of Zowe Explorer found.
     */
    fun getZoweExplorerApi(requiredVersion: String = definedExternally): ZoweExplorerApi.IApiRegisterClient

    /**
     * Show a message within VS Code dialog, and log it to an Imperative logger
     * @param message The message to display
     * @param severity The level of severity for the message (see `MessageSeverity`)
     * @param logger The IZoweLogger object for logging the message
     */
    @Deprecated("Please use Gui.showMessage instead")
    fun showVsCodeMessage(
      message: String,
      severity: MessageSeverity,
      logger: IZoweLogger,
    )

    /**
     * Opens an input box dialog within VS Code, given an options object
     * @param inputBoxOptions The options for this input box
     */
    @Deprecated("Please use Gui.showInputBox instead")
    fun inputBox(inputBoxOptions: InputBoxOptions): Promise<String>

    /**
     * Helper function to standardize the way we ask the user for credentials
     * @param options Set of options to use when prompting for credentials
     * @return Instance of imperative.IProfileLoaded containing information about the updated profile
     */
    @Deprecated("")
    fun promptCredentials(options: IPromptCredentialsOptions): Promise<IProfileLoaded>

    /**
     * Helper function to standardize the way we ask the user for credentials that updates ProfilesCache
     * @param options Set of options to use when prompting for credentials
     * @return Instance of imperative.IProfileLoaded containing information about the updated profile
     */
    fun updateCredentials(
      options: IPromptCredentialsOptions,
      apiRegister: ZoweExplorerApi.IApiRegisterClient,
    ): Promise<IProfileLoaded>

    /**
     * Trigger a login operation with the merged contents between the service profile and the base profile.
     *  If the connection details (host:port) do not match (service vs base), the token will be stored in the service profile.
     *  If there is no API registered for the profile type, this method defaults the login behavior to that of the APIML.
     * @param serviceProfile Profile to be used for login pursposes (either the name of the IProfileLoaded instance)
     * @param loginTokenType The tokenType value for compatibility purposes
     * @param node The node for compatibility purposes
     * @param zeRegister The ZoweExplorerApiRegister instance for compatibility purposes
     * @param zeProfiles The Zowe Explorer "Profiles.ts" instance for compatibility purposes
     */
    fun loginWithBaseProfile(
      serviceProfile: String,
      loginTokenType: String = definedExternally,
      node: IZoweTreeNode = definedExternally,
      zeRegister: ZoweExplorerApi.IApiRegisterClient = definedExternally,
      zeProfiles: ProfilesCache = definedExternally,
    ): Promise<Boolean>

    /**
     * Trigger a login operation with the merged contents between the service profile and the base profile.
     *  If the connection details (host:port) do not match (service vs base), the token will be stored in the service profile.
     *  If there is no API registered for the profile type, this method defaults the login behavior to that of the APIML.
     * @param serviceProfile Profile to be used for login pursposes (either the name of the IProfileLoaded instance)
     * @param loginTokenType The tokenType value for compatibility purposes
     * @param node The node for compatibility purposes
     * @param zeRegister The ZoweExplorerApiRegister instance for compatibility purposes
     * @param zeProfiles The Zowe Explorer "Profiles.ts" instance for compatibility purposes
     */
    fun loginWithBaseProfile(
      serviceProfile: IProfileLoaded,
      loginTokenType: String = definedExternally,
      node: IZoweTreeNode = definedExternally,
      zeRegister: ZoweExplorerApi.IApiRegisterClient = definedExternally,
      zeProfiles: ProfilesCache = definedExternally,
    ): Promise<Boolean>

    /**
     * Trigger a logout operation with the merged contents between the service profile and the base profile.
     *  If the connection details (host:port) do not match (service vs base), the token will be removed from the service profile.
     *  If there is no API registered for the profile type, this method defaults the logout behavior to that of the APIML.
     * @param serviceProfile Profile to be used for logout pursposes (either the name of the IProfileLoaded instance)
     * @param zeRegister The ZoweExplorerApiRegister instance for compatibility purposes
     * @param zeProfiles The Zowe Explorer "Profiles.ts" instance for compatibility purposes
     */
    fun logoutWithBaseProfile(
      serviceProfile: String,
      zeRegister: ZoweExplorerApi.IApiRegisterClient = definedExternally,
      zeProfiles: ProfilesCache = definedExternally,
    ): Promise<Unit>

    /**
     * Trigger a logout operation with the merged contents between the service profile and the base profile.
     *  If the connection details (host:port) do not match (service vs base), the token will be removed from the service profile.
     *  If there is no API registered for the profile type, this method defaults the logout behavior to that of the APIML.
     * @param serviceProfile Profile to be used for logout pursposes (either the name of the IProfileLoaded instance)
     * @param zeRegister The ZoweExplorerApiRegister instance for compatibility purposes
     * @param zeProfiles The Zowe Explorer "Profiles.ts" instance for compatibility purposes
     */
    fun logoutWithBaseProfile(
      serviceProfile: IProfileLoaded,
      zeRegister: ZoweExplorerApi.IApiRegisterClient = definedExternally,
      zeProfiles: ProfilesCache = definedExternally,
    ): Promise<Unit>
  }
}
