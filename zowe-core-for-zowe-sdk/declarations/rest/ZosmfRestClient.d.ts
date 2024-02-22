import { IImperativeError, Logger, RestClient } from "@zowe/imperative";
/**
 * Wrapper for invoke z/OSMF API through the RestClient to perform common error
 * handling and checking and resolve promises according to generic types
 * @export
 * @class ZosmfRestClient
 * @extends {RestClient}
 */
export declare class ZosmfRestClient extends RestClient {
    /**
     * Use the Brightside logger instead of the imperative logger
     * @type {Logger}
     */
    get log(): Logger;
    /**
     * Append z/OSMF specific headers to the callers headers for cases
     * where a header is common to every request.
     * @param headers current header array
     * @memberof ZosmfRestClient
     */
    protected appendHeaders(headers: any[] | undefined): any[];
    /**
     * Process an error encountered in the rest client
     * @param original the original error automatically built by the abstract rest client
     * @return the processed error with details added
     * @memberof ZosmfRestClient
     */
    protected processError(original: IImperativeError): IImperativeError;
}
