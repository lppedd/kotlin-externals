import { ICommandArguments, ICommandOptionDefinition, ISession } from "@zowe/imperative";
/**
 * Utility Methods for Brightside
 * @export
 */
export declare class ZosmfSession {
    static ZOSMF_CONNECTION_OPTION_GROUP: string;
    /**
     * Option used in profile creation and commands for hostname for z/OSMF
     */
    static ZOSMF_OPTION_HOST: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for hostname for z/OSMF
     * @deprecated Use ZOSMF_OPTION_HOST instead
     */
    static ZOSMF_OPTION_HOST_PROFILE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for port for z/OSMF
     */
    static ZOSMF_OPTION_PORT: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for username / ID for z/OSMF
     */
    static ZOSMF_OPTION_USER: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for username / ID for z/OSMF
     * @deprecated Use ZOSMF_OPTION_USER instead
     */
    static ZOSMF_OPTION_USER_PROFILE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for password/passphrase for z/OSMF
     */
    static ZOSMF_OPTION_PASSWORD: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for password/passphrase for z/OSMF
     * @deprecated Use ZOSMF_OPTION_PASSWORD instead
     */
    static ZOSMF_OPTION_PASSWORD_PROFILE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for rejectUnauthorized setting for connecting to z/OSMF
     */
    static ZOSMF_OPTION_REJECT_UNAUTHORIZED: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for base path setting for connecting to z/OSMF
     */
    static ZOSMF_OPTION_BASE_PATH: ICommandOptionDefinition;
    /**
     * Option used to specify HTTP or HTTPS Protocol
     */
    static ZOSMF_OPTION_PROTOCOL: ICommandOptionDefinition;
    /**
     * Option used to specify the path to the certificate file for authentication
     */
    static ZOSMF_OPTION_CERT_FILE: ICommandOptionDefinition;
    /**
     * Option used to specify the path to the cert's key file for authentication
     */
    static ZOSMF_OPTION_CERT_KEY_FILE: ICommandOptionDefinition;
    /**
     * Option used to specify the path to the certificate file for authentication
     */
    /**
     * Options related to connecting to z/OSMF
     * These options can be filled in if the user creates a profile
     */
    static ZOSMF_CONNECTION_OPTIONS: ICommandOptionDefinition[];
    /**
     * Given command line arguments, create an session configuration object.
     * @param {ICommandArguments} args - The arguments specified by the user
     * @returns {ISession} - A session configuration to be used for a session.
     */
    static createSessCfgFromArgs(args: ICommandArguments): ISession;
    private static get log();
}
