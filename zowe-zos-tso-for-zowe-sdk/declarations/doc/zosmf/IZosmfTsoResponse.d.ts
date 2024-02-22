import { ITsoMessages, IZosmfMessages } from "../../";
/**
 * z/OSMF synchronous most tso command response messages. See the z/OSMF REST API publication for complete details.
 * @export
 * @interface IZosmfTsoResponse
 */
export interface IZosmfTsoResponse {
    /**
     * unique identifier for the servlet entry
     * @type {string}
     * @memberof IZosmfTsoResponse
     */
    servletKey: string;
    /**
     * message queue ID
     * @type {string}
     * @memberof IZosmfTsoResponse
     */
    queueID?: string;
    /**
     * structure version
     * @type {string}
     * @memberof IZosmfTsoResponse
     */
    ver: string;
    /**
     * reconnected indicator
     * @type {boolean}
     * @memberof IZosmfTsoResponse
     */
    reused: boolean;
    /**
     * timeout indicator
     * @type {boolean}
     * @memberof IZosmfTsoResponse
     */
    timeout: boolean;
    /**
     * z/OSMF messages
     * @type {IZosmfMessages[]}
     * @memberof IZosmfTsoResponse
     */
    msgData?: IZosmfMessages[];
    /**
     * id of the session
     * @type {string}
     * @memberof IZosmfTsoResponse
     */
    sessionID?: string;
    /**
     * TSO/E messages that were received during the request
     * @type {ITsoMessages[]}
     * @memberof IZosmfTsoResponse
     */
    tsoData?: ITsoMessages[];
    /**
     * application messages
     * @type {string}
     * @memberof IZosmfTsoResponse
     */
    appData?: string;
}
