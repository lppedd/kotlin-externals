import { ImperativeError } from "@zowe/imperative";
import { IZosmfIssueResponse } from "./doc/zosmf/IZosmfIssueResponse";
import { IConsoleResponse } from "./doc/IConsoleResponse";
/**
 * Class contains helper methods for console response commands response processing
 * @export
 * @class ConsoleResponseService
 */
export declare class ConsoleResponseService {
    /**
     * Populate the console response with the details returned from the z/OSMF console API.
     * Method takes two parameters: response from z/OSMF command and response to be populated.
     * Method adds response to a collection of z/OSMF responses, mark response as "succeeded" (response.success = true)
     * and populate other fields of response with values from z/OSMF sresponse.
     * @static
     * @param {IZosmfIssueResponse} zosmfResponse zosmf console response, @see {IZosmfIssueResponse}
     * @param {IConsoleResponse} response console response to be populated, @see {IConsoleResponse}
     * @param {boolean} processResponses is set to true, append command response string to the console API response
     * @return {IConsoleResponse} populated console response, @see {IConsoleResponse}
     * @memberof ConsoleResponse
     */
    static populate(zosmfResponse: IZosmfIssueResponse, response: IConsoleResponse, processResponses?: boolean): IConsoleResponse;
    /**
     * Populate the console response with the Imperative error message.
     * Method takes two parameters: Imperative error and response to be populated.
     * Method save error message info failureResponse field and mark console response as "failed" (response.success = false)
     * @tatic
     * @param {ImperativeError} error Imperative error, @see {ImperativeError}
     * @param {IConsoleResponse} response console response to be populated, @see {IConsoleResponse}
     * @return {IConsoleResponse} populated console response, @see {IConsoleResponse}
     * @memberof ConsoleResponse
     */
    static populateError(error: ImperativeError, response: IConsoleResponse): IConsoleResponse;
    /**
     * Provides empty console response
     * @static
     * @return {IConsoleResponse}
     * @memberof ConsoleResponse
     */
    static getEmptyConsoleResponse(): IConsoleResponse;
    /**
     * Determines whether last z/OSMF response has empty content or not
     * @static
     * @param {IConsoleResponse} response command response
     * @return {boolean} true if last z/OSMF response has empty "cmd-response", false otherwise
     * @memberof ConsoleResponse
     */
    static isLastZosmfResponseEmpty(response: IConsoleResponse): boolean;
}
