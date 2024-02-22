import { IZosmfMessages } from "./IZosmfMessages";
/**
 * The z/OSMF Ping API parameters. See the z/OSMF REST API documentation for full details.
 * @export
 * @interface IZosmfPingResponse
 */
export interface IZosmfPingResponse {
    /**
     * Ping servlet key used text.
     * @type {string}
     * @memberof IZosmfPingResponse
     */
    servletKey: string;
    /**
     * Ping version text.
     * @type {string}
     * @memberof IZosmfPingResponse
     */
    ver: string;
    /**
     * Ping error message response.
     * @type {array}
     * @memberof IZosmfPingResponse
     */
    msgData?: IZosmfMessages[];
    /**
     * Ping reused boolean.
     * @type {boolean}
     * @memberof IZosmfPingResponse
     */
    reused: boolean;
    /**
     * Ping timeout boolean.
     * @type {boolean}
     * @memberof IZosmfPingResponse
     */
    timeout: boolean;
}
