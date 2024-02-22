import { ICommandDefinition } from "./doc/ICommandDefinition";
import { ICommandProfileTypeConfiguration } from "./doc/profiles/definition/ICommandProfileTypeConfiguration";
/**
 * Command preparer provides static utilities to ensure that command definitions are suitable for Imperative definition.
 */
export declare class CommandPreparer {
    /**
     * Prepare the command definition and apply any pass on traits to children.
     * After a definition has been prepared, it should be considered final.
     * @param {ICommandDefinition} original - The original command definition tree to "prepare"
     * @param {ICommandProfileTypeConfiguration} baseProfile - An optional base profile to add to command definitions
     * @return {ICommandDefinition} A copy of the original that has been prepared
     */
    static prepare(original: ICommandDefinition, baseProfile?: ICommandProfileTypeConfiguration): ICommandDefinition;
    /**
     * Perform preliminary (or post-preparation) basic validation of the command definition tree. Checks to ensure
     * that absoultely necessary fields are populated and invalid combos are not present.
     * @param {ICommandDefinition} definitionTree - full tree of command definitions to validate
     */
    static validateDefinitionTree(definitionTree: ICommandDefinition): void;
    /**
     * Perform preliminary (or post prepared) basic validation of the command definition tree. Checks to ensure
     * that absoultely necessary fields are populated and invalid combos are not present.
     *
     * Note: The root command is a bit of a special case, and is immune to some validation - we can't have a
     * name associated because that would cause an extra segment added in yargs.
     *
     * @param {ICommandDefinition} definition - The current command definition in the tree
     * @param {ICommandDefinition[]} definitions - the current set of definitions we've traversed - for diagnostics
     */
    private static perfomBasicValidation;
    /**
     * Perform basic positional operand validation. Ensure that the positional operands are valid and well formed.
     * @private
     * @static
     * @param {ICommandDefinition} definition - The command definition containing positionals to be validated
     * @memberof CommandPreparer
     */
    private static performBasicPositionalValidation;
    /**
     * Perform basic option operand validation. Ensure that the option operands are valid and well formed.
     * @private
     * @static
     * @param {ICommandDefinition} definition - The command definition containing options to be validated
     * @memberof CommandPreparer
     */
    private static performBasicOptionValidation;
    /**
     * If optional fields have not been populated in the original definition, ensure they are set to the appropriate defaults.
     * @private
     * @static
     * @param {ICommandDefinition} definition - the definition tree to set the default values
     * @memberof CommandPreparer
     */
    private static setDefaultValues;
    /**
     * If the "passOn" specification does not indicate a value, we will extract the value/trait from the parent and
     * populate the "passOn" value. This allows parents to pass on their own properties/traits.
     * @private
     * @static
     * @param {ICommandDefinition} definition - the full definition tree
     * @memberof CommandPreparer
     */
    private static populatePassOnValueFromParent;
    /**
     * Appends items which should be passed on to later nodes
     * @param definition - The original command definition tree to "prepare"
     */
    private static appendPassOnOptions;
    /**
     * Appends options (for profiles, global options like help, etc.) automatically
     * @param {ICommandDefinition} definition - The original command definition tree to "prepare"
     * @param {ICommandOptionDefinition[]} baseProfileOptions - Option definitions sourced from base profile
     * @return {ICommandDefinition} A copy of the original that has been prepared
     */
    private static appendAutoOptions;
    /**
     * A command definition node can indicate any arbitrary field be "passed on" to it's children. The intention is
     * to provide convienence for the coder of definition document, when they want to apply the same attributes (such
     * as reading from stdin OR which profiles are required) to all of its decedents.
     * @param {ICommandDefinition} definition - the original command document
     * @param {ICommandDefinition} inherit - the current set of attributes/fields being "passed on" - if a "pass on"
     * specification is found in a child document, it overwrites the parents (takes precedence)
     * @return {ICommandDefinition} A copy of the original with all "passed on" fields.
     */
    private static passOn;
    /**
     * Check if the current node should be ignored. The name of the node is checked agaisnt the specification in
     * the pass on parameters.
     * @param {ICommandDefinition} node - The command definition node
     * @param {ICommandDefinitionPassOnIgnore[]} ignore - The names to ignore
     * @returns {boolean} - True if we are to ignore passing on attributes to the passed definition node.
     */
    private static ignoreNode;
}
