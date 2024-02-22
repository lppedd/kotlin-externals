/**
 * TSO Prompt interface for one of TSO/E messages
 * @export
 * @interface ITsoPromptMessage
 */
export interface ITsoPromptMessage {
    /**
     * JSON version for message format
     * @type {string}
     * @memberof ITsoPromptMessage
     */
    VERSION: string;
    /**
     * description of the data type
     * @type {string}
     * @memberof ITsoPromptMessage
     */
    HIDDEN: string;
}
