/**
 * z/OSMF synchronous console command response messages. See the z/OSMF REST API publication for complete details.
 * @export
 * @interface IZosmfCollectResponse
 */
export interface IZosmfCollectResponse {
    /**
     * Command response text.
     * @type {string}
     * memerof IZosmfCollectResponse
     */
    "cmd-response": string;
    /**
     * True if the solicited keyword requested is present.
     * @type {boolean}
     * @memberof IZosmfCollectResponse
     */
    "sol-key-detected"?: boolean;
}
