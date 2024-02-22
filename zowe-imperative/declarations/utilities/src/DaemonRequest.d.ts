import { IDaemonRequest } from "./doc/IDaemonRequest";
/**
 * Class to handle building a daemon request
 * @export
 * @class DaemonRequest
 */
export declare class DaemonRequest {
    private request;
    /**
     * End of writing delimiter
     * @static
     * @type {string}
     * @memberof DaemonRequest
     */
    static readonly EOW_DELIMITER: string;
    /**
     *Creates an instance of DaemonRequest.
     * @param {IDaemonRequest} request
     * @memberof DaemonRequest
     */
    constructor(request: IDaemonRequest);
    /**
     * Create daemon request from input options
     * @static
     * @param {IDaemonRequest} request
     * @returns {string}
     * @memberof DaemonRequest
     */
    static create(request: IDaemonRequest): string;
    /**
     * Stringify request and append form feed
     * @private
     * @returns {string}
     * @memberof DaemonRequest
     */
    private build;
}
