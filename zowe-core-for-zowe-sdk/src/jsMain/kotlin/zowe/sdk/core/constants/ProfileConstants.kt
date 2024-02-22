@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.constants

import zowe.imperative.cmd.doc.ICommandExampleDefinition
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration

/**
 * Class containing the various profile related constants
 */
external class ProfileConstants {
  companion object {
    @JsString("Base Connection Options")
    val BASE_CONNECTION_OPTION_GROUP: String

    /**
     * Option used in profile creation and commands for hostname
     */
    val BASE_OPTION_HOST: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for port
     */
    val BASE_OPTION_PORT: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for username / ID
     */
    val BASE_OPTION_USER: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for password/passphrase
     */
    val BASE_OPTION_PASSWORD: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for rejectUnauthorized setting for connecting to z/OSMF
     */
    val BASE_OPTION_REJECT_UNAUTHORIZED: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for tokenType
     */
    val BASE_OPTION_TOKEN_TYPE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for tokenValue to be used to interact with APIs
     */
    val BASE_OPTION_TOKEN_VALUE: ICommandOptionDefinition

    /**
     * Option used to specify the path to the certificate file for authentication
     */
    val BASE_OPTION_CERT_FILE: ICommandOptionDefinition

    /**
     * Option used to specify the path to the certificate file for authentication
     */
    val BASE_OPTION_CERT_KEY_FILE: ICommandOptionDefinition

    /**
     * Option used to specify the path to the certificate file for authentication
     */
    val AUTO_INIT_OPTION_GROUP: Any? // type isn't declared

    /**
     * Option used in profile creation and commands for hostname
     */
    val AUTO_INIT_OPTION_HOST: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for port
     */
    val AUTO_INIT_OPTION_PORT: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for username / ID
     */
    val AUTO_INIT_OPTION_USER: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for password/passphrase
     */
    val AUTO_INIT_OPTION_PASSWORD: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for rejectUnauthorized setting for connecting to z/OSMF
     */
    val AUTO_INIT_OPTION_REJECT_UNAUTHORIZED: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for tokenType
     */
    val AUTO_INIT_OPTION_TOKEN_TYPE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for tokenValue to be used to interact with APIs
     */
    val AUTO_INIT_OPTION_TOKEN_VALUE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for certificate file to be used to interact with login APIs
     */
    var AUTO_INIT_OPTION_CERT_FILE: ICommandOptionDefinition

    /**
     * Option used in profile creation and commands for certificate key file to be used to interact with login APIs
     */
    var AUTO_INIT_OPTION_CERT_KEY_FILE: ICommandOptionDefinition

    /**
     * Summary of auth command group
     */
    @JsString("Connect to Zowe API ML authentication service")
    val AUTH_GROUP_SUMMARY: String

    /**
     * Description of auth command group
     */
    val AUTH_GROUP_DESCRIPTION: String

    /**
     * Summary of APIML login command
     */
    @JsString("Log in to API ML authentication service")
    val APIML_LOGIN_SUMMARY: String

    /**
     * Description of APIML login command
     */
    val APIML_LOGIN_DESCRIPTION: String

    /**
     * Example definition for APIML login command
     */
    val APIML_LOGIN_EXAMPLE1: ICommandExampleDefinition

    /**
     * Example definition for APIML login command with show-token
     */
    val APIML_LOGIN_EXAMPLE2: ICommandExampleDefinition

    /**
     * Summary of APIML logout command
     */
    @JsString("Log out of API ML authentication service")
    val APIML_LOGOUT_SUMMARY: String

    /**
     * Description of APIML logout command
     */
    val APIML_LOGOUT_DESCRIPTION: String

    /**
     * Example definition for APIML logout command
     * @static
     * @memberof AuthConstants
     */
    val APIML_LOGOUT_EXAMPLE1: ICommandExampleDefinition

    /**
     * Example definition for APIML logout command with token-value
     */
    val APIML_LOGOUT_EXAMPLE2: ICommandExampleDefinition

    /**
     * Option used in APIML logout command for token-type
     */
    val APIML_LOGOUT_OPTION_TOKEN_TYPE: ICommandOptionDefinition

    /**
     * Profile configuration for SSH profiles
     */
    val BaseProfile: ICommandProfileTypeConfiguration
  }
}
