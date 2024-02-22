import { IConsoleParms } from "./IConsoleParms";
/**
 * Interface for Collect command parameters
 * @export
 * @interface ICollectParms
 */
export interface ICollectParms extends IConsoleParms {
    /**
     * The command response key for follow up messages
     * API call.
     * @type {string}
     * @memberof ICollectParms
     */
    commandResponseKey: string;
    /**
     * Indicates that you would like to wait 'n' number of seconds before issues a follow-up request for
     * additional messages (assuming a command response key is present). Will wait the specified amount of
     * time before each follow-up request is issued.
     * @type {string}
     * @memberof ICollectParms
     */
    waitToCollect?: number;
    /**
     * The default is 1, however you may specify the number of follow-up attempts. This can be useful when multiple
     * multi-line WTO command responses are issued in direct response to a command. zOS consoles do NOT have any
     * awareness of how many multi-line WTO messages will be issued in response to a command. Use this parameter
     * in conjunction with waitToCollect to "fine-tune" your requests. The follow-up counter is decremented when
     * no command response (response text) is present in the request. Meaning, if a command is issued, follow-up
     * attempts is 1, and the first 2 requests provided command response data, it will issue 1 final
     * follow up request before returning (resulting in 3 total API calls).
     * @type {number}
     * @memberof ICollectParms
     */
    followUpAttempts?: number;
}
