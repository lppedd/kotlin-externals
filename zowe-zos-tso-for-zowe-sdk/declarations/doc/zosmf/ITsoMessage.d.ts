/**
 * TSO Message interface for one of TSO/E messages
 * @export
 * @interface ITsoMessage
 */
export interface ITsoMessage {
    /**
     * JSON version for message format
     * @type {string}
     * @memberof ITsoMessage
     */
    VERSION: string;
    /**
     * description of the data type
     * @type {string}
     * @memberof ITsoMessage
     */
    DATA: string;
}
