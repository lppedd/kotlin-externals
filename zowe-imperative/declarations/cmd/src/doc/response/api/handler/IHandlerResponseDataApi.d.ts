/**
 * APIs for the command handlers to construct the JSON response object for the command. The JSON response object is
 * built/written when the "response format JSON" flag is set. The intention is to allow for structured information/data
 * to be provided to the caller (who is requesting the JSON format of the command output) for programmatic usage of
 * Imperative commands.
 * @export
 * @interface IHandlerResponseDataApi
 */
export interface IHandlerResponseDataApi {
    /**
     * The JSON response object for a command contains a property that is intended to contain any custom object(s)/data
     * that the command wants to return to the caller.
     * @param {*} data - The object to set in the JSON response.
     * @param {boolean} merge - If true, will merge the object with the existing data already set.
     * @returns {*} - The object.
     * @memberof IHandlerResponseDataApi
     */
    setObj(data: any, merge?: boolean): any;
    /**
     * Sets the JSON response API "message" property. Can optionally be logged. The intent is to provide a short
     * summary on the response JSON object (for display and other purposes).
     * @param {string} message
     * @param {...any[]} values
     * Values gets passed to the method TextUtils.formatMessage.
     * Two possible formats:
     * - List of values to be inserted into the string message ("printf" style)
     * - Object containing key-value pairs to be rendered in the Mustache template string message
     * @returns {string}
     * @memberof IHandlerResponseDataApi
     */
    setMessage(message: string, ...values: any[]): string;
    /**
     * Sets the JSON response API "exitCode" property.
     * Desired exit code for the command process
     * @param {number} code - The desired exit code
     * @returns {number} - The code you've set
     * @memberof IHandlerResponseDataApi
     */
    setExitCode(code: number): number;
}
