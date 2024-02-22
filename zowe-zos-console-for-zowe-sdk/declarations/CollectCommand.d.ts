import { AbstractSession } from "@zowe/imperative";
import { IZosmfCollectResponse } from "./doc/zosmf/IZosmfCollectResponse";
import { ICollectParms } from "./doc/ICollectParms";
import { IConsoleResponse } from "./doc/IConsoleResponse";
/**
 * Get the response to a command that was issued asynchronously with the Issue Command service
 * @export
 * @class CollectCommand
 */
export declare class CollectCommand {
    /**
     * Collect any messages related to the synchronous command response key provided
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {string} consoleName name of the EMCS console that is used to issue the command
     * @param {string} commandResponseKey command response key from the Issue Command request
     * @returns {Promise<IZosmfIssueResponse>} command response on resolve, @see {IZosmfIssueResponse}
     * @memberof CollectCommand
     */
    static collectCommon(session: AbstractSession, consoleName: string, commandResponseKey: string): Promise<IZosmfCollectResponse>;
    /**
     * Collect any messages (from default console) related to the synchronous command response key provided
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {string} commandResponseKey command response key from the Issue Command request
     * @return {Promise<IZosmfCollectResponse>} command response on resolve, @see {IZosmfCollectResponse}
     * @memberof CollectCommand
     */
    static collectDefConsoleCommon(session: AbstractSession, commandResponseKey: string): Promise<IZosmfCollectResponse>;
    /**
     * Collect any messages related to the synchronous command response key provided and collect them into IConsoleResponse
     *
     * To control additional collection and other behaviors, populate the ICollectParms object according
     * to your needs (see ICollectParms for details).
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {ICollectParms} parms console collect parameters, @see {ICollectParms}
     * @param {IConsoleResponse} response response from previous command (if present), @see {IConsoleResponse}
     * @return {Promise<IConsoleResponse>} command response on resolve, @see {IConsoleResponse}
     * @memberof CollectCommand
     */
    static collect(session: AbstractSession, parms: ICollectParms, response?: IConsoleResponse): Promise<IConsoleResponse>;
    /**
     * Get resource path for collect command
     * @param {string} consoleName name of the EMCS console that is used to issue the command
     * @param {string} commandResponseKey command response key from the Issue Command request
     * @return {string} resource path
     * @memberof CollectCommand
     */
    static getResource(consoleName: string, commandResponseKey: string): string;
    private static readonly TO_SECONDS;
    /**
     *
     * @param {ICollectParms} parms parameters for collect command
     * @return {number}
     */
    private static getFollowUpAttempts;
    /**
     * @static
     * @param {ICollectParms} parms console collect parameters, @see {ICollectParms}s
     * @return {number} timeout in milliseconds or default value
     * @memberof CollectCommand
     */
    private static getTimeout;
}
