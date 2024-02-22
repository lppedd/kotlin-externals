/**
 * Class to contain  constants
 * @export
 * @class Constants
 */
export declare class Constants {
    /**
     * Custom log location to prevent logging to default folder based on the package name
     * @static
     * @memberof Constants
     */
    static readonly LOG_LOCATION = "zowe/logs/zowe.log";
    /**
     * Display name
     * @static
     * @memberof Constants
     */
    static readonly DISPLAY_NAME = "Zowe CLI";
    /**
     * Binary executable name
     * @static
     * @memberof Constants
     */
    static readonly BINARY_NAME = "zowe";
    /**
     *
     * Documentation link for the CLI
     * @static
     * @memberof Constants
     */
    static readonly DOCUMENTATION_LINK = "https://docs.zowe.org";
    /**
     *
     * Support link for zowe
     * @static
     * @memberof Constants
     */
    static readonly SUPPORT_LINK = "https://www.zowe.org";
    /**
     * Description of product
     * @static
     * @memberof Constants
     */
    static readonly DESCRIPTION: string;
    /**
     * Home environment variable
     * @static
     * @memberof Constants
     */
    static readonly HOME_ENV_KEY = "ZOWE_CLI_HOME";
    /**
     * Prefix for environmental variable settings used by Imperative
     * @static
     * @memberof Constants
     */
    static readonly ENV_PREFIX = "ZOWE";
    /**
     * Home directory
     * @static
     * @memberof Constants
     */
    static readonly HOME_DIR = "~/.zowe";
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_CONNECTION_OPTION_GROUP = "Base Connection Options";
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_HOST: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_PORT: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_USER: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_PASSWORD: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_REJECT_UNAUTHORIZED: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_TOKEN_TYPE: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_TOKEN_VALUE: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_CERT_FILE: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly BASE_OPTION_CERT_KEY_FILE: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_GROUP = "APIML Connection Options";
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_HOST: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_PORT: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_USER: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_PASSWORD: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_REJECT_UNAUTHORIZED: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_TOKEN_TYPE: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_TOKEN_VALUE: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTO_INIT_OPTION_CERT_FILE: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
    */
    static readonly AUTO_INIT_OPTION_CERT_KEY_FILE: import("@zowe/imperative").ICommandOptionDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTH_GROUP_SUMMARY = "Connect to Zowe API ML authentication service";
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly AUTH_GROUP_DESCRIPTION: string;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGIN_SUMMARY = "Log in to API ML authentication service";
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGIN_DESCRIPTION: string;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGIN_EXAMPLE1: import("@zowe/imperative").ICommandExampleDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGIN_EXAMPLE2: import("@zowe/imperative").ICommandExampleDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGOUT_SUMMARY = "Log out of API ML authentication service";
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGOUT_DESCRIPTION: string;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGOUT_EXAMPLE1: import("@zowe/imperative").ICommandExampleDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGOUT_EXAMPLE2: import("@zowe/imperative").ICommandExampleDefinition;
    /**
     * @deprecated Please use this constant from the @zowe/core-for-zowe-sdk
     */
    static readonly APIML_LOGOUT_OPTION_TOKEN_TYPE: import("@zowe/imperative").ICommandOptionDefinition;
}
