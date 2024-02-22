/**
 * Interface describing what values are allowable
 * for a particular option.
 */
export interface ICommandOptionAllowableValues {
    /**
     * Regular expressions for values that the user can specify for this option
     *
     * new RegExp(value).test(theValueSpecifiedByUser) will be called during syntax validation.
     * If none of the values match, the user will get a syntax error.
     * @type {string[]}
     * @memberof ICommandOptionAllowableValues
     */
    values: string[];
    /**
     * Should these values be compared in a case sensitive manner?
     * @type {boolean}
     * @memberof ICommandOptionAllowableValues
     */
    caseSensitive?: boolean;
}
