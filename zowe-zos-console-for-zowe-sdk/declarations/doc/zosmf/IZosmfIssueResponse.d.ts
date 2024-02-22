/**
 * z/OSMF synchronous console command response messages. See the z/OSMF REST API publication for complete details.
 * @export
 * @interface IZosmfIssueResponse
 */
export interface IZosmfIssueResponse {
    /**
     * Follow-up response URL.
     * @type {string}
     * @memberof IZosmfIssueResponse
     */
    "cmd-response-url"?: string;
    /**
     * Command response text.
     * @type {string}
     * @memberof IZosmfIssueResponse
     */
    "cmd-response": string;
    /**
     * The follow-up response URI.
     * @type {string}
     * @memberof IZosmfIssueResponse
     */
    "cmd-response-uri"?: string;
    /**
     * The command response key used for follow-up requests.
     * @type {string}
     * @memberof IZosmfIssueResponse
     */
    "cmd-response-key"?: string;
    /**
     * True if the solicited keyword requested is present.
     * @type {string}
     * @memberof IZosmfIssueResponse
     */
    "sol-key-detected"?: boolean;
}
