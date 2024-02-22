import { ProfilesCommandBuilder } from "./ProfilesCommandBuilder";
import { ICommandDefinition, ICommandProfileTypeConfiguration } from "../../../../cmd";
import { Logger } from "../../../../logger/";
/**
 * Used to build profile update command definitions.
 * Used automatically if you allow the "profiles" command group to be generated
 */
export declare class ProfilesListCommandBuilder extends ProfilesCommandBuilder {
    /**
     * Construct the builder based on the schema.
     * @param profileType - the profile type to generate the command definition for
     * @param {Logger} logger - logger instance to use for the builder class
     * @param {ICommandProfileTypeConfiguration} profileConfig: Imperative profile configuration for this type of profile
     */
    constructor(profileType: string, logger: Logger, profileConfig: ICommandProfileTypeConfiguration);
    /**
     * Gets the "action" that this command builder is building.
     * @return {string}: The "create" action string
     */
    getAction(): string;
    /**
     * Build the full command - includes action group and object command.
     * @return {ICommandDefinition}: The command definition.
     */
    buildFull(): ICommandDefinition;
    /**
     * Builds only the "profile" segment from the profile schema.
     * @return {ICommandDefinition}
     */
    protected buildProfileSegmentFromSchema(): ICommandDefinition;
}
