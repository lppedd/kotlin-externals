/**
 * The z/OSMF Ping API error message parameters. See the z/OSMF REST API documentation for full details.
 * @export
 * @interface IZosmfMessages
 */
export interface IZosmfMessages {
    /**
     * Error message text.
     * @type {string}
     * @memberof IZosmfMessages
     */
    messageText: string;
    /**
     * Error message text ID.
     * @type {string}
     * @memberof IZosmfMessages
     */
    messageId: string;
    /**
     * Error message stack trace.
     * @type {string}
     * @memberof IZosmfMessages
     */
    stackTrace: string;
}
