import { AbstractCommandBuilder } from "../../../../../../cmd/src/builders/AbstractCommandBuilder";
import { ICommandDefinition } from "../../../../../../cmd";
import { Logger } from "../../../../../../logger";
import { ICommandProfileAutoInitConfig } from "../../../../../../cmd/src/doc/profiles/definition/ICommandProfileAutoInitConfig";
/**
 * Class for generating auth-related commands
 */
export declare class AutoInitCommandBuilder implements AbstractCommandBuilder {
    protected mLogger: Logger;
    protected mAutoInitConfig: ICommandProfileAutoInitConfig;
    protected mProfileType?: string;
    /**
     * Auth config for the command.
     */
    protected mConfig: ICommandProfileAutoInitConfig;
    /**
     * Construct the builder based on the auth config.
     * @param mProfileType - the profile name of the profile type e.g. banana
     * @param {Logger} mLogger - logger instance to use for the builder class
     * @param {IImperativeAuthConfig} mAuthConfig - the config for the auth type
     */
    constructor(mLogger: Logger, mAutoInitConfig: ICommandProfileAutoInitConfig, mProfileType?: string);
    /**
     * Build the command
     * @return {ICommandDefinition}: The command definition.
     */
    buildFull(): ICommandDefinition;
    /**
     * Gets the "action" that this command builder is building.
     * @return {string}: The auth action string
     */
    getAction(): string;
    /**
     * Build the command
     * @return {ICommandDefinition}
     */
    build(): ICommandDefinition;
    /**
     * Builds only the "auto-init" segment from the auto-init config.
     * @return {ICommandDefinition}
     */
    protected buildAutoInitSegmentFromConfig(): ICommandDefinition;
}
