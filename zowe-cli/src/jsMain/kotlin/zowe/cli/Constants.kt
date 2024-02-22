@file:JsModule("@zowe/cli")

package zowe.cli

import zowe.imperative.cmd.doc.ICommandExampleDefinition
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Class to contain  constants
 */
external class Constants {
  companion object {
    /**
     * Custom log location to prevent logging to default folder based on the package name
     */
    @JsString("zowe/logs/zowe.log")
    val LOG_LOCATION: String

    /**
     * Display name
     */
    @JsString("Zowe CLI")
    val DISPLAY_NAME: String

    /**
     * Binary executable name
     */
    @JsString("zowe")
    val BINARY_NAME: String

    /**
     *
     * Documentation link for the CLI
     */
    @JsString("https://docs.zowe.org")
    val DOCUMENTATION_LINK: String

    /**
     *
     * Support link for zowe
     */
    @JsString("https://www.zowe.org")
    val SUPPORT_LINK: String

    /**
     * Description of product
     */
    val DESCRIPTION: String

    /**
     * Home environment variable
     */
    @JsString("ZOWE_CLI_HOME")
    val HOME_ENV_KEY: String

    /**
     * Prefix for environmental variable settings used by Imperative
     */
    @JsString("ZOWE")
    val ENV_PREFIX: String

    /**
     * Home directory
     */
    @JsString("~/.zowe")
    val HOME_DIR: String

    @JsString("Base Connection Options")
    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_CONNECTION_OPTION_GROUP: String

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_HOST: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_PORT: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_USER: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_PASSWORD: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_REJECT_UNAUTHORIZED: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_TOKEN_TYPE: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_TOKEN_VALUE: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_CERT_FILE: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val BASE_OPTION_CERT_KEY_FILE: ICommandOptionDefinition

    @JsString("APIML Connection Options")
    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_GROUP: String

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_HOST: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_PORT: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_USER: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_PASSWORD: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_REJECT_UNAUTHORIZED: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_TOKEN_TYPE: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_TOKEN_VALUE: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_CERT_FILE: ICommandOptionDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTO_INIT_OPTION_CERT_KEY_FILE: ICommandOptionDefinition

    @JsString("Connect to Zowe API ML authentication service")
    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTH_GROUP_SUMMARY: String

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val AUTH_GROUP_DESCRIPTION: String

    @JsString("Log in to API ML authentication service")
    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGIN_SUMMARY: String

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGIN_DESCRIPTION: String

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGIN_EXAMPLE1: ICommandExampleDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGIN_EXAMPLE2: ICommandExampleDefinition

    @JsString("Log out of API ML authentication service")
    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGOUT_SUMMARY: String

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGOUT_DESCRIPTION: String

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGOUT_EXAMPLE1: ICommandExampleDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGOUT_EXAMPLE2: ICommandExampleDefinition

    @Deprecated("Please use this constant from the @zowe/core-for-zowe-sdk")
    val APIML_LOGOUT_OPTION_TOKEN_TYPE: ICommandOptionDefinition
  }
}
