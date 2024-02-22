import { ICommandDefinition } from "../../";
/**
 * profile.schema Command Builder - used in the module loaders to build and append additional profile.schemaside commands as
 * requested by the module definition.
 */
export declare abstract class AbstractCommandBuilder {
    /**
     * Accepts an instance of this class and builds the definition and appends it to the command definition document.
     * @param { AbstractCommandBuilder} builder: The builder that constructs the definition.
     * @param {ICommandDefinition} definition: The definition to append to.
     * command will be appended to the existing group.
     */
    static appendToDocument(builder: AbstractCommandBuilder, definition: ICommandDefinition): void;
    /**
     * Gets the "action" that this command builder is building.
     * @return {string}: The action command group string.
     */
    abstract getAction(): string;
    /**
     * Build the full command - includes action group and object command.
     * @return {ICommandDefinition}: The command definition.
     */
    abstract buildFull(): ICommandDefinition;
    /**
     * Only constructs the object command.
     * @return {ICommandDefinition}: The object command definition.
     */
    abstract build(): ICommandDefinition;
}
