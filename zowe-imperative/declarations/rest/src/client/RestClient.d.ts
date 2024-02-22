/// <reference types="node" />
/// <reference types="node" />
import { AbstractSession } from "../session/AbstractSession";
import { AbstractRestClient } from "./AbstractRestClient";
import { Readable, Writable } from "stream";
import { ITaskWithStatus } from "../../../operations";
import { IRestClientResponse } from "./doc/IRestClientResponse";
import { IOptionsFullResponse } from "./doc/IOptionsFullResponse";
/**
 * Class to handle http(s) requests, build headers, collect data, report status codes, and header responses
 * and passes control to session object for maintaining connection information (tokens, checking for timeout, etc...)
 * @export
 * @class RestClient
 * @extends {AbstractRestClient}
 */
export declare class RestClient extends AbstractRestClient {
    /**
     * Wrap get for common error handling and supporting generic JSON types
     * @static
     * @template T - object type to return
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - the API URI that we are targeting
     * @param {any[]} reqHeaders - headers for the http(s) request
     * @returns {Promise<T>} - object on promise
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static getExpectJSON<T extends object>(session: AbstractSession, resource: string, reqHeaders?: any[]): Promise<T>;
    /**
     * Wrap put for common error handling and supporting generic JSON types
     * @static
     * @template T - object type to return
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - the API URI that we are targeting
     * @param {any[]} reqHeaders - headers for the http(s) request
     * @param {any} payload - data to write on the http(s) request
     * @returns {Promise<T>} - object on promise
     * @throws  if the request gets a status code outside of the 200 range
     *                                   or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static putExpectJSON<T extends object>(session: AbstractSession, resource: string, reqHeaders: any[], payload: any): Promise<T>;
    /**
     * Wrap post for common error handling and supporting generic JSON types
     * @static
     * @template T - object type to return
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - the API URI that we are targeting
     * @param {any[]} reqHeaders - headers for the http(s) request
     * @param {any} payload - data to write on the http(s) request
     * @returns {Promise<T>} - object on promise
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static postExpectJSON<T extends object>(session: AbstractSession, resource: string, reqHeaders?: any[], payload?: any): Promise<T>;
    /**
     * Wrap post for common error handling and supporting generic JSON types
     * @static
     * @template T - object type to return
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - the API URI that we are targeting
     * @param {any[]} reqHeaders - headers for the http(s) request
     * @returns {Promise<T>} - object on promise
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static deleteExpectJSON<T extends object>(session: AbstractSession, resource: string, reqHeaders?: any[]): Promise<T>;
    /**
     * REST HTTP GET operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {any} reqHeaders - headers to include in the REST request
     * @returns {Promise<Buffer>} - response body content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static getExpectBuffer(session: AbstractSession, resource: string, reqHeaders?: any[]): Promise<Buffer>;
    /**
     * REST HTTP PUT operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {object[]} reqHeaders - headers to include in the REST request
     * @param {any} data - payload data
     * @returns {Promise<Buffer>} - response body content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static putExpectBuffer(session: AbstractSession, resource: string, reqHeaders: any[], data: any): Promise<Buffer>;
    /**
     * REST HTTP POST operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {object[]} reqHeaders - headers to include in the REST request
     * @param {any} data - payload data
     * @returns {Promise<Buffer>} - response body content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static postExpectBuffer(session: AbstractSession, resource: string, reqHeaders?: any[], data?: any): Promise<Buffer>;
    /**
     * REST HTTP DELETE operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {any} reqHeaders - headers to include in the REST request
     * @returns {Promise<Buffer>} - response body content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static deleteExpectBuffer(session: AbstractSession, resource: string, reqHeaders?: any[]): Promise<Buffer>;
    /**
     * REST HTTP GET operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {any} reqHeaders - headers to include in the REST request
     * @returns {Promise<string>} - response body content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static getExpectString(session: AbstractSession, resource: string, reqHeaders?: any[]): Promise<string>;
    /**
     * REST HTTP PUT operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {object[]} reqHeaders - headers to include in the REST request
     * @param {any} data - payload data
     * @returns {Promise<string>} - response body content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static putExpectString(session: AbstractSession, resource: string, reqHeaders: any[], data: any): Promise<string>;
    /**
     * REST HTTP POST operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {object[]} reqHeaders - headers to include in the REST request
     * @param {any} data - payload data
     * @returns {Promise<string>} - response body content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static postExpectString(session: AbstractSession, resource: string, reqHeaders?: any[], data?: any): Promise<string>;
    /**
     * REST HTTP DELETE operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {any} reqHeaders - headers to include in the REST request
     * @returns {Promise<string>} - response body content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static deleteExpectString(session: AbstractSession, resource: string, reqHeaders?: any[]): Promise<string>;
    /**
     * REST HTTP GET operation - streaming the response to a writable stream
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {any} reqHeaders - headers to include in the REST request
     * @param responseStream - the stream to which the response data will be written
     * @param normalizeResponseNewLines - streaming only - true if you want newlines to be \r\n on windows
     *                                    when receiving data from the server to responseStream. Don't set this for binary responses
     * @param {ITaskWithStatus} task - task used to update the user on the progress of their request
     * @returns {Promise<string>} - empty string - data is not buffered for this request
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static getStreamed(session: AbstractSession, resource: string, reqHeaders: any[], responseStream: Writable, normalizeResponseNewLines?: boolean, task?: ITaskWithStatus): Promise<string>;
    /**
     * REST HTTP PUT operation with streamed response and request
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {object[]} reqHeaders - headers to include in the REST request
     * @param {any} responseStream - stream to which the response data will be written
     * @param {any} requestStream - stream from which payload data will be read
     * @param normalizeResponseNewLines - streaming only - true if you want newlines to be \r\n on windows
     *                                    when receiving data from the server to responseStream. Don't set this for binary responses
     * @param normalizeRequestNewLines -  streaming only - true if you want \r\n to be replaced with \n when sending
     *                                    data to the server from requestStream. Don't set this for binary requests
     * @param {ITaskWithStatus} task - task used to update the user on the progress of their request
     * @returns {Promise<string>} - empty string - data is not buffered for streamed requests
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static putStreamed(session: AbstractSession, resource: string, reqHeaders: any[], responseStream: Writable, requestStream: Readable, normalizeResponseNewLines?: boolean, normalizeRequestNewLines?: boolean, task?: ITaskWithStatus): Promise<string>;
    /**
     * REST HTTP PUT operation with only streamed request, buffers response data and returns it
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {object[]} reqHeaders - headers to include in the REST request
     * @param {any} requestStream - stream from which payload data will be read
     * @param normalizeRequestNewLines -  streaming only - true if you want \r\n to be replaced with \n when sending
     *                                    data to the server from requestStream. Don't set this for binary requests
     * @param {ITaskWithStatus} task - task used to update the user on the progress of their request
     * @returns {Promise<string>} - string of the response
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static putStreamedRequestOnly(session: AbstractSession, resource: string, reqHeaders: any[], requestStream: Readable, normalizeRequestNewLines?: boolean, task?: ITaskWithStatus): Promise<string>;
    /**
     * REST HTTP POST operation streaming both the request and the response
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {object[]} reqHeaders - headers to include in the REST request
     * @param {any} responseStream - stream to which the response data will be written
     * @param {any} requestStream - stream from which payload data will be read
     * @param normalizeResponseNewLines - streaming only - true if you want newlines to be \r\n on windows
     *                                    when receiving data from the server to responseStream. Don't set this for binary responses
     * @param normalizeRequestNewLines -  streaming only - true if you want \r\n to be replaced with \n when sending
     *                                    data to the server from requestStream. Don't set this for binary requests
     * @param {ITaskWithStatus} task - task used to update the user on the progress of their request
     * @returns {Promise<string>} - empty string - data is not buffered for  this request
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static postStreamed(session: AbstractSession, resource: string, reqHeaders: any[], responseStream: Writable, requestStream: Readable, normalizeResponseNewLines?: boolean, normalizeRequestNewLines?: boolean, task?: ITaskWithStatus): Promise<string>;
    /**
     * REST HTTP POST operation, streaming only the request and not the response
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {object[]} reqHeaders - headers to include in the REST request
     * @param {any} requestStream - stream from which payload data will be read
     * @param normalizeRequestNewLines -  streaming only - true if you want \r\n to be replaced with \n when sending
     *                                    data to the server from requestStream. Don't set this for binary requests
     * @param {ITaskWithStatus} task - task used to update the user on the progress of their request
     * @returns {Promise<string>} - string of the response
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static postStreamedRequestOnly(session: AbstractSession, resource: string, reqHeaders: any[], requestStream: Readable, normalizeRequestNewLines?: boolean, task?: ITaskWithStatus): Promise<string>;
    /**
     * REST HTTP DELETE operation
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {string} resource - URI for which this request should go against
     * @param {any} reqHeaders - headers to include in the REST request
     * @param {any} responseStream - stream to which the response data will be written
     * @param {ITaskWithStatus} task - task used to update the user on the progress of their request
     * @param normalizeResponseNewLines - streaming only - true if you want newlines to be \r\n on windows
     *                                    when receiving data from the server to responseStream. Don't set this for binary responses
     * @returns {Promise<string>} - empty string - data is not buffered for streamed requests
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static deleteStreamed(session: AbstractSession, resource: string, reqHeaders: any[], responseStream: Writable, normalizeResponseNewLines?: boolean, task?: ITaskWithStatus): Promise<string>;
    /**
     * REST HTTP GET operation returning full HTTP(S) Response
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {IOptionsFullRequest} options - URI for which this request should go against
     * @returns {Promise<IRestClientResponse>} - full response or filtered based on provided params
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static getExpectFullResponse(session: AbstractSession, options: IOptionsFullResponse): Promise<IRestClientResponse>;
    /**
     * REST HTTP PUT operation returning full HTTP(S) Response
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {IOptionsFullRequest} options - list of parameters
     * @returns {Promise<IRestClientResponse>} - response content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static putExpectFullResponse(session: AbstractSession, options: IOptionsFullResponse): Promise<IRestClientResponse>;
    /**
     * REST HTTP delete operation returning full HTTP(S) Response
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {IOptionsFullRequest} options - list of parameters
     * @returns {Promise<IRestClientResponse>} - response content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static deleteExpectFullResponse(session: AbstractSession, options: IOptionsFullResponse): Promise<IRestClientResponse>;
    /**
     * REST HTTP post operation returning full HTTP(S) Response
     * @static
     * @param {AbstractSession} session - representing connection to this api
     * @param {IOptionsFullRequest} options - list of parameters
     * @returns {Promise<IRestClientResponse>} - response content from http(s) call
     * @throws  if the request gets a status code outside of the 200 range
     *          or other connection problems occur (e.g. connection refused)
     * @memberof RestClient
     */
    static postExpectFullResponse(session: AbstractSession, options: IOptionsFullResponse): Promise<IRestClientResponse>;
    /**
     * Helper method to return an indicator for whether or not a URI contains a query string.
     * @static
     * @param {string} query - URI
     * @returns {boolean} - true if query is contained within URI
     * @memberof RestClient
     */
    static hasQueryString(query: string): boolean;
    /**
     * Helper method to extract requested data from response object
     * If list is not passed, returns entire response
     * @static
     * @param {any} client - HTTP(S) response object
     * @param {string[]} toReturn - list with object properties to return
     * @returns {IRestClientResponse} - trimmed or full response object based on the list provided
     * @memberof RestClient
     */
    private static extractExpectedData;
}
