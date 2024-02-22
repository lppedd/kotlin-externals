@file:JsModule("@zowe/zosmf-for-zowe-sdk")

package zowe.sdk.zosmf

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition
import zowe.imperative.rest.session.doc.ISession

/**
 * Utility Methods for Brightside
 */
external class ZosmfSession {
  companion object {
    var ZOSMF_CONNECTION_OPTION_GROUP: String

    /**
     * Option used in profile creation and commands for hostname for z/OSMF
     */
    var ZOSMF_OPTION_HOST: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for hostname for z/OSMF
     */
    @Deprecated("Use ZOSMF_OPTION_HOST instead")
    var ZOSMF_OPTION_HOST_PROFILE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for port for z/OSMF
     */
    var ZOSMF_OPTION_PORT: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for username / ID for z/OSMF
     */
    var ZOSMF_OPTION_USER: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for username / ID for z/OSMF
     */
    @Deprecated("Use ZOSMF_OPTION_USER instead")
    var ZOSMF_OPTION_USER_PROFILE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for password/passphrase for z/OSMF
     */
    var ZOSMF_OPTION_PASSWORD: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for password/passphrase for z/OSMF
     */
    @Deprecated("Use ZOSMF_OPTION_PASSWORD instead")
    var ZOSMF_OPTION_PASSWORD_PROFILE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for rejectUnauthorized setting for connecting to z/OSMF
     */
    var ZOSMF_OPTION_REJECT_UNAUTHORIZED: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for base path setting for connecting to z/OSMF
     */
    var ZOSMF_OPTION_BASE_PATH: ICommandOptionDefinition

    /**
     * Option used to specify HTTP or HTTPS Protocol
     */
    var ZOSMF_OPTION_PROTOCOL: ICommandOptionDefinition

    /**
     * Option used to specify the path to the certificate file for authentication
     */
    var ZOSMF_OPTION_CERT_FILE: ICommandOptionDefinition

    /**
     * Option used to specify the path to the cert's key file for authentication
     */
    var ZOSMF_OPTION_CERT_KEY_FILE: ICommandOptionDefinition

    /**
     * Options related to connecting to z/OSMF
     * These options can be filled in if the user creates a profile
     */
    var ZOSMF_CONNECTION_OPTIONS: Array<ICommandOptionDefinition>

    /**
     * Given command line arguments, create an session configuration object.
     * @param args The arguments specified by the user
     * @return A session configuration to be used for a session.
     */
    fun createSessCfgFromArgs(args: ICommandArguments): ISession
  }
}
