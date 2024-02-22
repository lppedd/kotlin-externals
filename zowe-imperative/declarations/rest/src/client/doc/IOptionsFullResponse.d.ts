/// <reference types="node" />
import { Writable, Readable } from "stream";
import { ITaskWithStatus } from "../../../../operations";
import { CLIENT_PROPERTY } from "../types/AbstractRestClientProperties";
/**
 * Interface to define input options for RestClient GET|POST|PUT|DELETE ExpectFullResponse methods
 * @export
 * @interface IOptionsFullResponse
 */
export interface IOptionsFullResponse {
    /**
     * URI for this request
     * @type {string}
     * @memberof IRestOptions
     */
    resource: string;
    /**
     * List of properties to return from REST call
     * @type {CLIENT_PROPERTY[]}
     * @memberof IFullResponseOptions
     */
    dataToReturn?: CLIENT_PROPERTY[];
    /**
     * Headers to include with request
     * @type {any[]}
     * @memberof IRestOptions
     */
    reqHeaders?: any[];
    /**
     * Data to write on this REST request
     * @type {*}
     * @memberof IRestOptions
     */
    writeData?: any;
    /**
     * Stream for incoming response data from the server. If specified, response data will not be buffered
     * @type {Writable}
     * @memberof IRestOptions
     */
    responseStream?: Writable;
    /**
     * Stream for outgoing request data to the server
     * @type {Readable}
     * @memberof IRestOptions
     */
    requestStream?: Readable;
    /**
     * true if you want newlines to be \r\n on windows
     * when receiving data from the server to responseStream. Don't set this for binary responses
     * @type {boolean}
     * @memberof IRestOptions
     */
    normalizeResponseNewLines?: boolean;
    /**
     * true if you want \r\n to be replaced with \n when sending
     * data to the server from requestStream. Don't set this for binary requests
     * @type {boolean}
     * @memberof IRestOptions
     */
    normalizeRequestNewLines?: boolean;
    /**
     * Task that will automatically be updated to report progress of upload or download to user
     * @type {ITaskWithStatus}
     * @memberof IRestOptions
     */
    task?: ITaskWithStatus;
}
