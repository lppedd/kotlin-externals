import { ICommandExampleDefinition, ICommandOptionDefinition, ICommandProfileTypeConfiguration } from "@zowe/imperative";
/**
 * Class containing the various profile related constants
 */
export declare class ProfileConstants {
    static readonly BASE_CONNECTION_OPTION_GROUP = "Base Connection Options";
    /**
     * Option used in profile creation and commands for hostname
     */
    static readonly BASE_OPTION_HOST: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for port
     */
    static readonly BASE_OPTION_PORT: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for username / ID
     */
    static readonly BASE_OPTION_USER: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for password/passphrase
     */
    static readonly BASE_OPTION_PASSWORD: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for rejectUnauthorized setting for connecting to z/OSMF
     */
    static readonly BASE_OPTION_REJECT_UNAUTHORIZED: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for tokenType
     */
    static readonly BASE_OPTION_TOKEN_TYPE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for tokenValue to be used to interact with APIs
     */
    static readonly BASE_OPTION_TOKEN_VALUE: ICommandOptionDefinition;
    /**
     * Option used to specify the path to the certificate file for authentication
     */
    static readonly BASE_OPTION_CERT_FILE: ICommandOptionDefinition;
    /**
     * Option used to specify the path to the certificate file for authentication
     */
    static readonly BASE_OPTION_CERT_KEY_FILE: ICommandOptionDefinition;
    /**
     * Option used to specify the path to the certificate file for authentication
     */
    static readonly AUTO_INIT_OPTION_GROUP = "APIML Connection Options";
    /**
     * Option used in profile creation and commands for hostname
     */
    static readonly AUTO_INIT_OPTION_HOST: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for port
     */
    static readonly AUTO_INIT_OPTION_PORT: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for username / ID
     */
    static readonly AUTO_INIT_OPTION_USER: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for password/passphrase
     */
    static readonly AUTO_INIT_OPTION_PASSWORD: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for rejectUnauthorized setting for connecting to z/OSMF
     */
    static readonly AUTO_INIT_OPTION_REJECT_UNAUTHORIZED: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for tokenType
     */
    static readonly AUTO_INIT_OPTION_TOKEN_TYPE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for tokenValue to be used to interact with APIs
     */
    static readonly AUTO_INIT_OPTION_TOKEN_VALUE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for certificate file to be used to interact with login APIs
     */
    static AUTO_INIT_OPTION_CERT_FILE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for certificate key file to be used to interact with login APIs
     */
    static AUTO_INIT_OPTION_CERT_KEY_FILE: ICommandOptionDefinition;
    /**
     * Summary of auth command group
     * @static
     * @memberof AuthConstants
     */
    static readonly AUTH_GROUP_SUMMARY = "Connect to Zowe API ML authentication service";
    /**
     * Description of auth command group
     * @static
     * @memberof AuthConstants
     */
    static readonly AUTH_GROUP_DESCRIPTION: string;
    /**
     * Summary of APIML login command
     * @static
     * @memberof AuthConstants
     */
    static readonly APIML_LOGIN_SUMMARY = "Log in to API ML authentication service";
    /**
     * Description of APIML login command
     * @static
     * @memberof AuthConstants
     */
    static readonly APIML_LOGIN_DESCRIPTION: string;
    /**
     * Example definition for APIML login command
     * @static
     * @memberof AuthConstants
     */
    static readonly APIML_LOGIN_EXAMPLE1: ICommandExampleDefinition;
    /**
     * Example definition for APIML login command with show-token
     * @static
     * @memberof AuthConstants
     */
    static readonly APIML_LOGIN_EXAMPLE2: ICommandExampleDefinition;
    /**
     * Summary of APIML logout command
     * @static
     * @memberof AuthConstants
     */
    static readonly APIML_LOGOUT_SUMMARY = "Log out of API ML authentication service";
    /**
     * Description of APIML logout command
     * @static
     * @memberof AuthConstants
     */
    static readonly APIML_LOGOUT_DESCRIPTION: string;
    /**
     * Example definition for APIML logout command
     * @static
     * @memberof AuthConstants
     */
    static readonly APIML_LOGOUT_EXAMPLE1: ICommandExampleDefinition;
    /**
     * Example definition for APIML logout command with token-value
     * @static
     * @memberof AuthConstants
     */
    static readonly APIML_LOGOUT_EXAMPLE2: ICommandExampleDefinition;
    /**
     * Option used in APIML logout command for token-type
     */
    static readonly APIML_LOGOUT_OPTION_TOKEN_TYPE: ICommandOptionDefinition;
    /**
     * Profile configuration for SSH profiles
     * @type {ICommandProfileTypeConfiguration}
     * @memberof BaseProfile
     */
    static readonly BaseProfile: ICommandProfileTypeConfiguration;
}
