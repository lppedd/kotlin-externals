/**
 * Interface for TSO issue command z/OSMF parameters
 * @export
 * @interface IIssueTsoParms
 */
export interface ISendTsoParms {
    /**
     * Servlet key of an active address space
     * @type {string}
     * @memberof ISendTsoParms
     */
    servletKey: string;
    /**
     * Data to be sent to the active address space
     * @type {string}
     * @memberof ISendTsoParms
     */
    data: string;
}
