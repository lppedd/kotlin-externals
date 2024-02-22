/**
 * Interface of an explanation map object
 */
export interface IExplanationMap {
    explainedParentKey: string;
    ignoredKeys: string;
    [key: string]: string | IExplanationMap;
}
/**
 * Lightweight utilities for text manipulation/coloring.
 * Low import impact
 */
export declare class TextUtils {
    static readonly DEFAULT_WRAP_WIDTH = 80;
    static readonly AVAILABLE_CHALK_COLORS: string[];
    /**
     * Get the recommended width to wrap text. You can specify a preferred width,
     * but this method width return
     * @param {number} preferredWidth - the width you would like  to use if supported
     *                                  by the user's terminal
     * @returns {number} - the width that will work best for the user's terminal
     */
    static getRecommendedWidth(preferredWidth?: number): number;
    static renderWithMustache(template: string, values: any): string;
    /**
     * Replace keys from an object with string explanations for those keys,
     * primarily so that they can be printed for the user to read.
     * @param original - the original object e.g. a response from a z/OSMF API {wrdKy4U: "weirdkeyvalue"}
     * @param explanationMap - an object that maps the original to the new format
     * @param includeUnexplainedKeys - should keys not covered by
     *        the explanation object be included in the result?
     * @returns {any} - the explained object
     */
    static explainObject(original: any, explanationMap: IExplanationMap, includeUnexplainedKeys?: boolean): any;
    /**
     *  Get a json object in tabular form
     * @param {any} object: Any JSON object
     * @param {any } options: Any JSON object to specify printing
     * @param  color  use  color on the result?
     */
    static prettyJson(object: any, options?: any, color?: boolean, append?: string): string;
    /**
     *
     * @param {any[]} objects - the key-value objects to convert to a
     * @param primaryHighlightColor - the main color to highlight headings of the table with. e.g. "blue"
     * @param {number} maxColumnWidth - override the default column width of the table?
     * @param {boolean}  includeHeader - should the table include a header of the field names of the objects
     * @param includeBorders -  should the table have borders between the cells?
     * @param hardWrap - hard wrap the text within the width of the table cells (defaults to false)
     * @param headers - specify which headers in which order to display. if omitted, loops through the rows
     *        and adds object properties as headers in their enumeration order
     * @returns {string} the rendered table
     */
    static getTable(objects: any[], primaryHighlightColor: string, maxColumnWidth?: number, includeHeader?: boolean, includeBorders?: boolean, hardWrap?: boolean, headers?: string[]): string;
    /**
     *  Build table headers from an array of key-value objects
     * @param {any[]} objects - the key-value objects from which to build headers
     * @returns {string} the headers array
     */
    static buildHeaders(objects: any[]): string[];
    /**
     * Wrap some text so that it fits within a certain width with the wrap-ansi package
     * @param {string} text The text you would like to wrap
     * @param {number} width - The width you would like to wrap to - we'll try to determine the
     *                  optimal width based on this (the resulting wrap may be wrapped to fewer columns, but not more)
     * @param {string} indent - Add this string to every line of the result
     * @param {boolean} hardWrap - do not allow any letters past the requested width - defaults to false
     * @returns {string}
     */
    static wordWrap(text: string, width?: number, indent?: string, hardWrap?: boolean, trim?: boolean): string;
    /**
     * Indent some text
     * @param {string} text The text you would like to indent
     * @param {string} indent - Add this string to every line of the result
     * @returns {string}
     */
    static indentLines(text: string, indent?: string): string;
    /**
     * Highlight all matches of a full regex with TextUtils.chalk
     * @param {string} text - the text you'd like to search for matches
     * @param {RegExp} term - a regular expression of terms to highlight
     * @returns {string} - the highlighted string
     */
    static highlightMatches(text: string, term: RegExp): string;
    /**
     * Auto-detect whether a message should be formatted with printf-style formatting or mustache
     *  (but don't try to use both!) and format the string accordingly
     * @param {string} message - the string message  with %s or {{mustache}} style variables
     * @param values the fields that will resolve the printf or mustache template
     * @returns {string} - a formatted string with the variables inserted
     */
    static formatMessage(message: string, ...values: any[]): string;
    static get chalk(): any;
    /**
     * Parse a key value string into an object
     * @param {string} keysAndValues - a string in the format key1=value1,key2=value2,key3=value3.
     *                                 Note: the key names are case sensitive
     * @returns {{[key: string]: string}} the parsed object
     */
    static parseKeyValueString(keysAndValues: string): {
        [key: string]: string;
    };
    /**
     * Render a mustache template based on arguments from the user
     * @param {string} template - the mustache-style template string into which you would like to insert your values
     * @param {string} keysAndValues - a string in the format key1=value1,key2=value2,key3=value3.
     *                                 Note: the key names are case sensitive
     * @returns {string} - the rendered template
     * @throws an Error if the keysAndValues are not in the expected format
     */
    static renderTemplateFromKeyValueArguments(template: string, keysAndValues: string): string;
}
