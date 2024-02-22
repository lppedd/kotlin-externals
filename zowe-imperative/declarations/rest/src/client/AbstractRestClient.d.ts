/// <reference types="node" />
/// <reference types="node" />
import { Logger } from "../../../logger";
import { IImperativeError } from "../../../error";
import { AbstractSession } from "../session/AbstractSession";
import { ContentEncoding } from "./Headers";
import { ImperativeReject } from "../../../interfaces";
import { HTTP_VERB } from "./types/HTTPVerb";
import { Session } from "../session/Session";
import { Readable, Writable } from "stream";
import { ITaskWithStatus } from "../../../operations";
import { IRestOptions } from "./doc/IRestOptions";
export declare type RestClientResolve = (data: string) => void;
/**
 * Class to handle http(s) requests, build headers, collect data, report status codes, and header responses
 * and passes control to session object for maintaining connection information (tokens, checking for timeout, etc...)
 * @export
 * @abstract
 * @class AbstractRestClient
 */
export declare abstract class AbstractRestClient {
    private mSession;
    /**
     * Contains REST chucks
     * @private
     * @type {Buffer[]}
     * @memberof AbstractRestClient
     */
    protected mChunks: Buffer[];
    /**
     * Contains buffered data after all REST chucks are received
     * @private
     * @type {Buffer}
     * @memberof AbstractRestClient
     */
    protected mData: Buffer;
    /**
     * Instance of logger
     * @private
     * @type {Logger}
     * @memberof AbstractRestClient
     */
    protected mLogger: Logger;
    /**
     * Resolved when all data has been obtained
     * @private
     * @type {RestClientResolve}
     * @memberof AbstractRestClient
     */
    protected mResolve: RestClientResolve;
    /**
     * Reject for errors when obtaining data
     * @private
     * @type {ImperativeReject}
     * @memberof AbstractRestClient
     */
    protected mReject: ImperativeReject;
    /**
     * Contain response from http(s) request
     * @private
     * @type {*}
     * @memberof AbstractRestClient
     */
    protected mResponse: any;
    /**
     * If we get a response containing a Content-Length header,
     * it is saved here
     * @private
     * @type {number}
     * @memberof AbstractRestClient
     */
    protected mContentLength: number;
    /**
     * If we get a response containing a Content-Encoding header,
     * and it matches an encoding type that we recognize,
     * it is saved here
     * @private
     * @type {ContentEncoding}
     * @memberof AbstractRestClient
     */
    protected mContentEncoding: ContentEncoding;
    /**
     * Indicates if payload data is JSON to be stringified before writing
     * @private
     * @type {boolean}
     * @memberof AbstractRestClient
     */
    protected mIsJson: boolean;
    /**
     * Indicates if request data should have its newlines normalized to /n before sending
     * each chunk to the server
     * @private
     * @type {boolean}
     * @memberof AbstractRestClient
     */
    protected mNormalizeRequestNewlines: boolean;
    /**
     * Indicates if response data should have its newlines normalized for the current platform
     * (\r\n for windows, otherwise \n)
     * @private
     * @type {boolean}
     * @memberof AbstractRestClient
     */
    protected mNormalizeResponseNewlines: boolean;
    /**
     * Save resource
     * @private
     * @type {string}
     * @memberof AbstractRestClient
     */
    protected mResource: string;
    /**
     * Save request
     * @private
     * @type {HTTP_VERB}
     * @memberof AbstractRestClient
     */
    protected mRequest: HTTP_VERB;
    /**
     * Save req headers
     * @private
     * @type {any[]}
     * @memberof AbstractRestClient
     */
    protected mReqHeaders: any[];
    /**
     * Save write data
     * @private
     * @type {*}
     * @memberof AbstractRestClient
     */
    protected mWriteData: any;
    /**
     * Stream for incoming response data from the server.
     * If specified, response data will not be buffered
     * @private
     * @type {Writable}
     * @memberof AbstractRestClient
     */
    protected mResponseStream: Writable;
    /**
     * stream for outgoing request data to the server
     * @private
     * @type {Writable}
     * @memberof AbstractRestClient
     */
    protected mRequestStream: Readable;
    /**
     * Task used to display progress bars or other user feedback mechanisms
     * Automatically updated if task is specified and streams are provided for upload/download
     * @private
     * @type {ITaskWithStatus}
     * @memberof AbstractRestClient
     */
    protected mTask: ITaskWithStatus;
    /**
     * Bytes received from the server response so far
     * @private
     * @type {ITaskWithStatus}
     * @memberof AbstractRestClient
     */
    protected mBytesReceived: number;
    /**
     * Whether or not to try and decode any encoded response
     * @private
     * @type {boolean}
     * @memberof AbstractRestClient
     */
    protected mDecode: boolean;
    /**
     * Last byte received when response is being streamed
     * @private
     * @type {number}
     * @memberof AbstractRestClient
     */
    protected lastByteReceived: number;
    /**
     * Creates an instance of AbstractRestClient.
     * @param {AbstractSession} mSession - representing connection to this api
     * @memberof AbstractRestClient
     */
    constructor(mSession: AbstractSession);
    /**
     * Perform the actual http REST call with appropriate user input
     * @param {IRestOptions} options
     * @returns {Promise<string>}
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof AbstractRestClient
     */
    request(options: IRestOptions): Promise<string>;
    /**
     * Append specific headers for all requests by overriding this implementation
     * @protected
     * @param {(any[] | undefined)} headers - list of headers
     * @returns {any[]} - completed list of headers
     * @memberof AbstractRestClient
     */
    protected appendHeaders(headers: any[] | undefined): any[];
    /**
     * Process and customize errors encountered in your client.
     * This is called any time an error is thrown from a failed Rest request using this client.
     * error before receiving any response body from the API.
     * You can use this, for example, to set the error tag for you client or add additional
     * details to the error message.
     * If you return null or undefined, Imperative will use the default error generated
     * for your failed request.
     * @protected
     * @param {IImperativeError} error - the error encountered by the client
     * @memberof AbstractRestClient
     * @returns {IImperativeError} processedError - the error with the fields set the way you want them
     */
    protected processError(error: IImperativeError): IImperativeError;
    /**
     * Build http(s) options based upon session settings and request.
     * @private
     * @param {string} resource - URI for this request
     * @param {string} request - REST request type GET|PUT|POST|DELETE
     * @param {any[]} reqHeaders - option headers to include with request
     * @returns {IHTTPSOptions} - completed options object
     * @memberof AbstractRestClient
     */
    private buildOptions;
    /**
     * Callback from http(s).request
     * @private
     * @param {*} res - https response
     * @memberof AbstractRestClient
     */
    private requestHandler;
    /**
     * Method to accumulate and buffer http request response data until our
     * onEnd method is invoked, at which point all response data has been accounted for.
     * NOTE(Kelosky): this method may be invoked multiple times.
     * @private
     * @param {Buffer} respData - any datatype and content
     * @memberof AbstractRestClient
     */
    private onData;
    /**
     * Method that must be implemented to extend the IRestClient class.  This is the client specific implementation
     * for what action to perform after all response data has been collected.
     * @private
     * @memberof AbstractRestClient
     */
    private onEnd;
    /**
     * Construct a throwable rest client error with all "relevant" diagnostic information.
     * The caller should have the session, so not all input fields are present on the error
     * response. Only the set required to understand "what may have gone wrong".
     *
     * The "exit" point for the implementation error override will also be called here. The
     * implementation can choose to transform the IImperativeError details however they see
     * fit.
     *
     * @param {IRestClientError} error - The base request error. It is expected to already have msg,
     *                                   causeErrors, and the error source pre-populated.
     * @param {*} [nodeClientError] - If the source is a node http client error (meaning the request
     *                                did not make it to the remote system) this parameter should be
     *                                populated.
     * @returns {RestClientError} - The error that can be thrown or rejected.
     */
    private populateError;
    /**
     * Appends output headers to the http(s) request
     * @private
     * @param {IHTTPSOptions} options - partially populated options objects
     * @param {any[]} [reqHeaders] - input headers for request on outgoing request
     * @returns {IHTTPSOptions} - with populated headers
     * @memberof AbstractRestClient
     */
    private appendInputHeaders;
    /**
     * Determine whether we should stringify or leave writable data alone
     * @private
     * @param {http.OutgoingHttpHeaders} headers - options containing populated headers
     * @memberof AbstractRestClient
     */
    private setTransferFlags;
    /**
     * Return whether or not a REST request was successful by HTTP status code
     * @readonly
     * @type {boolean}
     * @memberof AbstractRestClient
     */
    get requestSuccess(): boolean;
    /**
     * Return whether or not a REST request was successful by HTTP status code
     * @readonly
     * @type {boolean}
     * @memberof AbstractRestClient
     */
    get requestFailure(): boolean;
    /**
     * Return http(s) response body as a buffer
     * @readonly
     * @type {Buffer}
     * @memberof AbstractRestClient
     */
    get data(): Buffer;
    /**
     * Return http(s) response body as a string
     * @readonly
     * @type {string}
     * @memberof AbstractRestClient
     */
    get dataString(): string;
    /**
     * Return http(s) response object
     * @readonly
     * @type {*}
     * @memberof AbstractRestClient
     */
    get response(): any;
    /**
     * Return this session object
     * @readonly
     * @type {Session}
     * @memberof AbstractRestClient
     */
    get session(): Session;
    /**
     * Return the logger object for ease of reference
     * @readonly
     * @type {Logger}
     * @memberof AbstractRestClient
     */
    get log(): Logger;
}
