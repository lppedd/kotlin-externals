/**
 * The ZosFiles API response.
 * @export
 */
export interface IZosFilesResponse {
    /**
     * Indicates the success of retrieving specified file information.
     * @type {boolean}
     */
    success: boolean;
    /**
     * Relevant information about the performed file operation.
     * @type {string}
     */
    commandResponse: string;
    /**
     * The api response object, housing any returned header information.
     * @type {*}
     */
    apiResponse?: any;
    /**
     * The error message text.
     * If not defined, the command response will be used.
     * @type {string}
     */
    errorMessage?: string;
}
