import { AbstractCommandBuilder } from "../../../../cmd/src/builders/AbstractCommandBuilder";
import { ICommandDefinition } from "../../../../cmd";
import { Logger } from "../../../../logger";
import { ICommandProfileAuthConfig } from "../../../../cmd/src/doc/profiles/definition/ICommandProfileAuthConfig";
/**
 * Abstract class for generating auth-related commands
 */
export declare abstract class AuthCommandBuilder implements AbstractCommandBuilder {
    protected mProfileType: string;
    protected mLogger: Logger;
    protected mAuthConfig: ICommandProfileAuthConfig;
    /**
     * Auth config for the command.
     */
    protected mConfig: ICommandProfileAuthConfig;
    /**
     * Construct the builder based on the auth config.
     * @param mProfileType - the profile name of the profile type e.g. banana
     * @param {Logger} mLogger - logger instance to use for the builder class
     * @param {IImperativeAuthConfig} mAuthConfig - the config for the auth type
     */
    constructor(mProfileType: string, mLogger: Logger, mAuthConfig: ICommandProfileAuthConfig);
    /**
     * Build the full command - includes action group and object command.
     * @return {ICommandDefinition}: The command definition.
     */
    abstract buildFull(): ICommandDefinition;
    /**
     * Gets the "action" that this command builder is building.
     * @return {string}: The auth action string
     */
    abstract getAction(): string;
    /**
     * Only constructs the "group" command segment for the document. Use this if the command definition
     * document already includes an auth verb.
     * @return {ICommandDefinition}
     */
    build(): ICommandDefinition;
    /**
     * Builds only the "auth" segment from the auth config.
     * @return {ICommandDefinition}
     */
    protected abstract buildAuthSegmentFromConfig(): ICommandDefinition;
}
