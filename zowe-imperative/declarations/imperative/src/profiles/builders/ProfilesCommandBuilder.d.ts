import { AbstractCommandBuilder } from "../../../../cmd/src/builders/AbstractCommandBuilder";
import { ICommandDefinition, ICommandOptionDefinition, ICommandProfileTypeConfiguration } from "../../../../cmd";
import { Logger } from "../../../../logger";
import { IProfileSchema } from "../../../../profiles";
/**
 * Abstract class for generating profile-related commands
 */
export declare abstract class ProfilesCommandBuilder implements AbstractCommandBuilder {
    protected mProfileType: string;
    protected mLogger: Logger;
    protected mProfileConfig: ICommandProfileTypeConfiguration;
    /**
     * Schema for the command.
     */
    protected mSchema: IProfileSchema;
    /**
     * Construct the builder based on the schema.
     * @param mProfileType - the name of the profile type e.g. banana
     * @param {Logger} mLogger - logger instance to use for the builder class
     * @param {IProfileSchema} mProfileConfig: The schema that describes the profile
     */
    constructor(mProfileType: string, mLogger: Logger, mProfileConfig: ICommandProfileTypeConfiguration);
    /**
     * Build the full command - includes action group and object command.
     * @return {ICommandDefinition}: The command definition.
     */
    abstract buildFull(): ICommandDefinition;
    /**
     * Gets the "action" that this command builder is building.
     * @return {string}: The "create" action string
     */
    abstract getAction(): string;
    /**
     * Only constructs the "group" command segment for the document. Use this if the command definition
     * document already includes a "create" verb.
     * @return {ICommandDefinition}
     */
    build(): ICommandDefinition;
    /**
     * Builds only the "profile" segment from the profile schema.
     * @return {ICommandDefinition}
     */
    protected abstract buildProfileSegmentFromSchema(): ICommandDefinition;
    /**
     * Construct the operands from the Bright Profile Schema.
     * @param {any} properties: The properties set to iterate over looking for operands to add
     * @param {ICommandOptionDefinition[]} options: The final option definitions to add.
     * @return {ICommandOptionDefinition[]}: The set of returned option definitions
     */
    protected buildOptionsFromProfileSchema(properties: any, options: ICommandOptionDefinition[]): ICommandOptionDefinition[];
}
