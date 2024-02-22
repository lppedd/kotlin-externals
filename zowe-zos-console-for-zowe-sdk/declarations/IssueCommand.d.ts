import { AbstractSession } from "@zowe/imperative";
import { IZosmfIssueParms } from "./doc/zosmf/IZosmfIssueParms";
import { IZosmfIssueResponse } from "./doc/zosmf/IZosmfIssueResponse";
import { IIssueParms } from "./doc/IIssueParms";
import { IConsoleResponse } from "./doc/IConsoleResponse";
import { ICollectParms } from "./doc/ICollectParms";
/**
 * Issue MVS Console commands by using a system console
 * @export
 * @class IssueCommand
 */
export declare class IssueCommand {
    /**
     * Issue an MVS console command, returns "raw" z/OSMF response
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {string} consoleName name of the EMCS console that is used to issue the command
     * @param {IZosmfIssueParms} commandParms synchronous console issue parameters, @see {IZosmfIssueParms}
     * @return {Promise<IZosmfIssueResponse>} command response on resolve, @see {IZosmfIssueResponse}
     * @memberof IssueCommand
     */
    static issueCommon(session: AbstractSession, consoleName: string, commandParms: IZosmfIssueParms): Promise<IZosmfIssueResponse>;
    /**
     * Issue an MVS console command in default console, returns "raw" z/OSMF response
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {IZosmfIssueParms} commandParms synchronous console issue parameters, @see {IZosmfIssueParms}
     * @return {Promise<IZosmfIssueResponse>} command response on resolve, @see {IZosmfIssueResponse}
     * @memberof IssueCommand
     */
    static issueDefConsoleCommon(session: AbstractSession, commandParms: IZosmfIssueParms): Promise<IZosmfIssueResponse>;
    /**
     * Issue an MVS console command command synchronously - meaning solicited (direct command responses) are gathered
     * immediately after the command is issued. However, after (according to the z/OSMF REST API documentation)
     * approximately 3 seconds the response will be returned.
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {IIssueParms} parms console issue parameters, @see {IIssueParms}
     * @return {Promise<IConsoleResponse>} command response on resolve, @see {IConsoleResponse}
     * @memberof IssueCommand
     */
    static issue(session: AbstractSession, parms: IIssueParms): Promise<IConsoleResponse>;
    /**
     * Simple issue console command method. Does not accept parameters, so all defaults on the z/OSMF API are taken.
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {string} theCommand command to issue
     * @return {Promise<IConsoleResponse>} command response on resolve, @see {IConsoleResponse}
     * @memberof IssueCommand
     */
    static issueSimple(session: AbstractSession, theCommand: string): Promise<IConsoleResponse>;
    /**
     * Issue an MVS console command command synchronously - meaning solicited (direct command responses) are gathered
     * immediately after the command is issued. However, after (according to the z/OSMF REST API documentation)
     * approximately 3 seconds the response will be returned.
     *
     * To control additional collection and other behaviors, populate the ICollectParms object according
     * to your needs (see ICollectParms for details).
     * @static
     * @param {AbstractSession} session representing connection to this api
     * @param {IIssueParms} issueParms console issue parameters, @see {IIssueParms}
     * @param {ICollectParms} collectParms console collect parameters, @see {ICollectParms}
     * @return {Promise<IConsoleResponse>} command response on resolve, @see {IConsoleResponse}
     * @memberof IssueCommand
     */
    static issueAndCollect(session: AbstractSession, issueParms: IIssueParms, collectParms: ICollectParms): Promise<IConsoleResponse>;
    /**
     * Get resource path for issue command
     * @static
     * @param {string} consoleName name of the EMCS console that is used to issue the command
     * @return {string} resource path
     * @memberof IssueCommand
     */
    static getResource(consoleName: string): string;
    /**
     * Build IZosmfIssueParms object from provided parameters
     * @static
     * @param {IIssueParms} parms parameters for issue command
     * @return {IZosmfIssueParms} request body, @see {ZosmfConsoleApiParameters}
     * @memberof IssueCommand
     */
    static buildZosmfConsoleApiParameters(parms: IIssueParms): IZosmfIssueParms;
}
