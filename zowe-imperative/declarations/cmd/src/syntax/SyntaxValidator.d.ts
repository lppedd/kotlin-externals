import { ICommandDefinition } from "../doc/ICommandDefinition";
import { ICommandValidatorResponse } from "../doc/response/response/ICommandValidatorResponse";
import { CommandResponse } from "../response/CommandResponse";
import { ICommandArguments } from "../doc/args/ICommandArguments";
/**
 * The Imperative default syntax validator. Accepts the input arguments, command
 * definitions, and a response object. Validates the syntax and issues the
 * appropriate error messages if necessary.
 *
 * TODO - Consider limiting to a single purpose of producing error documents
 * TODO - that will be outputted by the command processor in a "more structured"
 * TODO - fasion.
 *
 * @export
 * @class SyntaxValidator
 */
export declare class SyntaxValidator {
    /**
     * Command option short/long
     */
    static SHORT: string;
    static LONG: string;
    /**
     * The command definition supplied to validate the arguments against.
     */
    private mCommandDefinition;
    /**
     * The full command definition - which includes the parents of the command.
     */
    private mDefinitionTree;
    /**
     * The full list of command options from the command definition
     */
    private mOptionDefinitionsMap;
    /**
     * Get an instance of the logger.
     * @private
     * @type {Logger}
     * @memberof SyntaxValidator
     */
    private mLogger;
    /**
     * The error list that is appended to the error response object.
     * @private
     * @type {ICommandValidatorError}
     * @memberof SyntaxValidator
     */
    private mErrorList;
    /**
     * Create the object - maintains the definition used to validate against the input arguments.
     * @param {ICommandDefinition} commandDefinition: The command definition document
     * @param {ICommandDefinition} fullCommandDefinition: The full command definition
     */
    constructor(commandDefinition: ICommandDefinition, fullCommandDefinition: ICommandDefinition);
    /**
     * Validate the command syntax.
     * @param {CommandResponse} responseObject: The response object to output the messages.
     * @param {ICommandArguments} commandArguments
     * @return {Promise<ICommandResponse>}
     */
    validate(responseObject: CommandResponse, commandArguments: ICommandArguments): Promise<ICommandValidatorResponse>;
    /**
     * Validate the options. Includes automatic validation based on option
     * and command definition as well as
     * custom validation provided by the user
     * @return {boolean}: True if the options are valid
     */
    private validateSyntax;
    /**
     * Issue an error message indicating that the JSON string provided is not valid.
     * @param {Error} error - the JSON parse try/catch error.
     * @param {ICommandOptionDefinition} optionDefinition - The Option definition
     * Validate the options. Includes automatic validation based on option
     * and command definition as well as custom validation provided by the user
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @return {boolean}: True if the options are valid, false if there is a syntax error
     */
    private invalidJsonString;
    /**
     * Issue the 'file must exist' error
     * @param {ICommandOptionDefinition} optionDefinition: the option definition for which the user specified a non-existent file
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @param {ICommandArguments} commandArguments: The arguments specified by the user.
     * @param isPositional - is the option a positional option? defaults to false
     */
    private fileOptionError;
    /**
     * Build up an object used for filling in syntax error messages with fields from an
     * option definition
     * @param optionDefinition - the option definition to use
     * @param isPositional - is the option a positional option? defaults to false
     * @returns {{long: string, aliases: string, description: string}} -
     *              an object used to replace {{variables}} with mustache
     */
    private getMustacheSummaryForOption;
    /**
     * Get the 'dash form' of an option as it would appear in a user's command,
     * appending the proper number of dashes depending on the length of the option name
     * @param {string} optionName - e.g. my-option
     * @returns {string} - e.g. --my-option
     */
    private getDashFormOfOption;
    private getOptionDefinitionFromName;
    /**
     * Accept the input and check for a match.
     * @param {string} input: the input value to check.
     * @param {ICommandOptionAllowableValues} allowable: The set of allowable values.
     * @returns {boolean}: true if the value is allowable.
     */
    private checkIfAllowable;
    /**
     * Issue the 'option is required' error.
     * @param {ICommandOptionDefinition} optionDefinition: the definition for this option
     * @param {CommandResponse} responseObject: The response object for producing messages.
     */
    private missingOptionError;
    /**
     * Issue error message indicating that the positional parameter specified does not match the regex.
     * @param {ICommandPositionalDefinition} positionalDefinition: The positional argument definition.
     * @param {string} specified: The argument that was specified.
     * @param {CommandResponse} responseObject: The response object for producing messages.
     */
    private positionalParameterInvalid;
    /**
     * Validate the that option's value is within the range specified. If not, error messages will be issued.
     *
     * @param {ICommandOptionDefinition} optionDefinition: The option definition
     * @param {string} optionValue: The option value
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @return {boolean}: false if the option's value is not valid.
     */
    private validateOptionValueRange;
    /**
     * Validate the that option's value is within the range specified. If not, error messages will be issued.
     *
     * @param {ICommandOptionDefinition|ICommandPositionalDefinition} optionDefinition: The option definition
     * @param {string} optionValue: The option value
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @param isPositional - is this a positional option? this method works with regular options and positionals
     * @return {boolean}: false if the value is not valid.
     */
    private validateOptionValueLength;
    /**
     * Validate if the option's value as array contains duplicates. If yes, error messages will be issued.
     *
     * @param {ICommandOptionDefinition} optionDefinition: The option definition
     * @param {string} optionValue: The option value
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @return {boolean}: false if the value is not valid.
     */
    private validateArrayDuplicate;
    /**
     * Issue the options require one another (dependency) error.
     *
     * @param {ICommandOptionDefinition} optionDef1: the first option that requires the second (or visa-versa)
     * @param {ICommandOptionDefinition} optionDef2: the first option that requires the second (or visa-versa)
     * @param {CommandResponse} responseObject: The response object for producing messages.
     */
    private optionDependencyError;
    /**
     * "impliesOneOf" (implicationAlternatives) condition was not satisfied
     * @param {ICommandOptionDefinition} optionDef: the option that requires  at least one of a group of options
     * @param {CommandResponse} responseObject: The response object for producing messages.
     */
    private implicationAlternativeError;
    /**
     *  If an option was specified, some other option should have been specified
     * @param {ICommandOptionDefinition} optionDef: the option whose absence implies the presence of other options.
     * @param {CommandResponse} responseObject: The response object for producing messages.
     */
    private absenceImplicationError;
    /**
     * Issue the options are mutually exclusive error.
     * @param {ICommandOptionDefinition} optionDef1: the first of the conflicting options.
     * @param {ICommandOptionDefinition} optionDef2: the second of hte conflicting options.
     * @param {CommandResponse} responseObject: The response object for producing messages.
     */
    private optionCombinationInvalidError;
    /**
     * If the option was specified multiple times despite not being an array type option, that's a syntax error
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @param {ICommandOptionDefinition} failingOption: The option with the non-allowable value
     */
    private specifiedMultipleTimesError;
    /**
     * If the option requires one of a set of values and the value provided doesn't match
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @param {ICommandOptionDefinition} failingOption: The option with the non-allowable value
     * @param {any} value - the value specified by the user which was not an array
     */
    private notAnArrayError;
    /**
     * If the option requires one of a set of values and the value provided doesn't match
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @param {ICommandOptionDefinition} failingOption: The option with the non-allowable value
     * @param value - the value that was specified by the user
     */
    private invalidOptionError;
    /**
     * If this option's specification requires another  option to be present. e.g. '--type TXT' requires that
     * '--maxlinelength' be specified. That condition was not satisfied, so issue an error message
     *
     * @param {ICommandOptionDefinition} optionDef: The option definition whose value requires
     * more options which were not specified
     * (e.g. '--type TXT' the specification of TXT requires that the user specify '--maxlinelength')
     * @param {string} value: The value that requries additional options (e.g. TXT in '--type TXT'
     * @param {ICommandOptionDefinition} requires: The parameter that it requires.
     * @param {CommandResponse} responseObject: The response object for producing messages.
     */
    private valueRequiresAdditionalOption;
    /**
     * Validate that the option's value is a boolean type
     * @param {any} value: The value passed to validate.
     * @param {ICommandOptionDefinition} optionDefinition: The definition for this option.
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @param isPositional - is the option a positional option? defaults to false
     */
    private validateBoolean;
    /**
     * Validate that the option's value is numeric.
     * @param {any} value: The value passed to validate.
     * @param {ICommandOptionDefinition| ICommandPositionalDefinition} optionDefinition: The definition for this option.
     * @param {CommandResponse} responseObject: The response object for producing messages.
     * @param isPositional - is the option a positional option? defaults to false
     */
    private validateNumeric;
    /**
     * If one of a set of options are required, issue an error message with the list of required options.
     */
    private mustSpecifyOneError;
    /**
     * If more than one of a set of options are specified, issue an error message with the list of offending options
     */
    private onlyOneOfError;
    /**
     * If the user specifies no value for an option that requires a string value,
     * that's an error
     */
    private emptyValueError;
    /**
     * If the user specifies an extra positional option
     */
    private unknownPositionalError;
    /**
     * Issue an error message indicating the missing positional parameters
     * @param {string[]} missingPositionals - The list of missing positional parameters for the command.
     * @param {CommandResponse} responseObject: The response object for producing messages.
     */
    private missingPositionalParameter;
    /**
     * Append the validator error to the resposne object.
     * @param {CommandResponse} responseObject: The Brightside response object
     * @param {ICommandValidatorError} error: The error to append.
     */
    private appendValidatorError;
}
