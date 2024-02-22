import { CommandProfiles } from "../../../../src/profiles/CommandProfiles";
import { ICommandArguments } from "../../../../src/doc/args/ICommandArguments";
/**
 * Command Processor prepare response.
 * @export
 * @interface ICommandPrepared
 */
export interface ICommandPrepared {
    /**
     * The profile map object for all profiles loaded for commands.
     * @type {CommandProfiles}
     * @memberof ICommandPrepared
     */
    profiles: CommandProfiles;
    /**
     * Imperative arguments object. Starts with arguments passed parsed by
     * Yargs as a base and fills in the rest from ENV/profile/defaults.
     * Eventually passed to handlers.
     * @type {ICommandArguments}
     */
    args: ICommandArguments;
}
