import { ITsoMessage, ITsoPromptMessage, ITsoResponseMessage } from "../../";
/**
 * Interface for TSO/E messages
 * @export
 * @interface ITsoMessages
 */
export interface ITsoMessages {
    /**
     * tso message type of TSO/E messages
     * @type {ITsoMessage}
     * @memberof ITsoMessages
     */
    "TSO MESSAGE"?: ITsoMessage;
    /**
     * tso prompt message type of TSO/E messages
     * @type {ITsoPromptMessage}
     * @memberof ITsoMessages
     */
    "TSO PROMPT"?: ITsoPromptMessage;
    /**
     * tso response message type of TSO/E messages
     * @type {ITsoResponseMessage}
     * @memberof ITsoMessages
     */
    "TSO RESPONSE"?: ITsoResponseMessage;
}
