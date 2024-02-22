import { ICommandOptionDefinition } from "../doc/option/ICommandOptionDefinition";
/**
 * Option constants - includes static options built/added by request (on imperative config or command definitions).
 * @export
 * @class OptionConstants
 */
export declare class OptionConstants {
    /**
     * The response format filter options allows users to filter (include) fields/properties in an output table/object.
     * Enable this option by specifying "outputFormatOptions: true" on your ICommandDefinition document.
     * @static
     * @type {ICommandOptionDefinition}
     * @memberof OptionConstants
     */
    static readonly RESPONSE_FORMAT_FILTER_OPTION: ICommandOptionDefinition;
    /**
     * The response format header option allows users to include a table header (or not).
     * Enable this option by specifying "outputFormatOptions: true" on your ICommandDefinition document.
     * @static
     * @type {ICommandOptionDefinition}
     * @memberof OptionConstants
     */
    static readonly RESPONSE_FORMAT_HEADER_OPTION: ICommandOptionDefinition;
    /**
     * The array of available format types (for the response-format-type definition allowable values).
     * @static
     * @type {string[]}
     * @memberof OptionConstants
     */
    static readonly RESPONSE_FORMAT_TYPES: string[];
    /**
     * The response format type option allows users control over handler output (print/console) data format.
     * Enable this option by specifying "outputFormatOptions: true" on your ICommandDefinition document.
     * @static
     * @type {ICommandOptionDefinition}
     * @memberof OptionConstants
     */
    static readonly RESPONSE_FORMAT_OPTION: ICommandOptionDefinition;
}
