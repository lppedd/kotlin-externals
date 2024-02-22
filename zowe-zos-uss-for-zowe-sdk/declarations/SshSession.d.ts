import { ICommandArguments, ICommandOptionDefinition } from "@zowe/imperative";
import { ISshSession } from "./doc/ISshSession";
/**
 * Utility Methods for Brightside
 * @export
 */
export declare class SshSession {
    private mISshSession;
    /**
     * Default ssh port 22
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_SSH_PORT = 22;
    /**
     * Obtain session info and defaults
     * @readonly
     * @type {ISession}
     * @memberof AbstractSession
     */
    get ISshSession(): ISshSession;
    static SSH_CONNECTION_OPTION_GROUP: string;
    /**
     * Option used in profile creation and commands for hostname for z/OS SSH
     */
    static SSH_OPTION_HOST: ICommandOptionDefinition;
    /**
     * @deprecated Use SSH_OPTION_HOST
     */
    static SSH_OPTION_HOST_PROFILE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for port for z/OS SSH
     */
    static SSH_OPTION_PORT: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for username / ID  for z/OS SSH
     */
    static SSH_OPTION_USER: ICommandOptionDefinition;
    /**
     * @deprecated Use SSH_OPTION_USER
     */
    static SSH_OPTION_USER_PROFILE: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for password/passphrase for z/OS SSH
     */
    static SSH_OPTION_PASSWORD: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for private key path
     */
    static SSH_OPTION_PRIVATEKEY: ICommandOptionDefinition;
    /**
     * Option used in profile creation and commands for passphrase for private key
     */
    static SSH_OPTION_KEYPASSPHRASE: ICommandOptionDefinition;
    /**
     * Option used in profile creation to set handshake timeout. If unset, defaults to no timeout.
     */
    static SSH_OPTION_HANDSHAKETIMEOUT: ICommandOptionDefinition;
    /**
     * Options related to connecting to z/OS SSH
     * These options can be filled in if the user creates a profile
     */
    static SSH_CONNECTION_OPTIONS: ICommandOptionDefinition[];
    /**
     * Given command line arguments, create an SSH session configuration object.
     * @param {ICommandArguments} args - The arguments specified by the user
     * @returns {ISshSession} - A session configuration to be used for an SSH session.
     */
    static createSshSessCfgFromArgs(args: ICommandArguments): ISshSession;
    /**
     * Creates an instance of AbstractSession.
     * @param {ISshSession} session: SshSession parameter object
     */
    constructor(mISshSession: ISshSession);
    private static get log();
    /**
     * Builds an ISshSession so all required pieces are filled in
     * @private
     * @param {ISession} session - the fully populated session
     * @memberof AbstractSession
     */
    private buildSession;
}
