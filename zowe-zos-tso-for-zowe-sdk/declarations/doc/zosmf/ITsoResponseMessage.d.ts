/**
 * TSO Response interface for one of TSO/E messages
 * @export
 * @interface ITsoResponseMessage
 */
export interface ITsoResponseMessage {
    /**
     * JSON version for message format
     * @type {string}
     * @memberof ITsoResponseMessage
     */
    VERSION: string;
    /**
     * description of the data type
     * @type {string}
     * @memberof ITsoResponseMessage
     */
    DATA: string;
}
