@file:JsModule("@zowe/zos-console-for-zowe-sdk")

package zowe.sdk.console

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.console.doc.ICollectParms
import zowe.sdk.console.doc.IConsoleResponse
import zowe.sdk.console.doc.IIssueParms
import zowe.sdk.console.doc.zosmf.IZosmfIssueParms
import zowe.sdk.console.doc.zosmf.IZosmfIssueResponse

/**
 * Issue MVS Console commands by using a system console
 */
external class IssueCommand {
  companion object {
    /**
     * Issue an MVS console command, returns "raw" z/OSMF response
     * @static
     * @param session representing connection to this api
     * @param consoleName name of the EMCS console that is used to issue the command
     * @param commandParms synchronous console issue parameters, see [IZosmfIssueParms]
     * @return command response on resolve, see [IZosmfIssueResponse]
     * @memberof IssueCommand
     */
    fun issueCommon(
      session: AbstractSession,
      consoleName: String,
      commandParms: IZosmfIssueParms
    ): Promise<IZosmfIssueResponse>

    /**
     * Issue an MVS console command in default console, returns "raw" z/OSMF response
     * @static
     * @param session representing connection to this api
     * @param commandParms synchronous console issue parameters, see [IZosmfIssueParms]
     * @return command response on resolve, see [IZosmfIssueResponse]
     * @memberof IssueCommand
     */
    fun issueDefConsoleCommon(session: AbstractSession, commandParms: IZosmfIssueParms): Promise<IZosmfIssueResponse>

    /**
     * Issue an MVS console command command synchronously - meaning solicited (direct command responses) are gathered
     * immediately after the command is issued. However, after (according to the z/OSMF REST API documentation)
     * approximately 3 seconds the response will be returned.
     * @static
     * @param session representing connection to this api
     * @param parms console issue parameters, see [IIssueParms]
     * @return command response on resolve, see [IConsoleResponse]
     * @memberof IssueCommand
     */
    fun issue(session: AbstractSession, parms: IIssueParms): Promise<IConsoleResponse>

    /**
     * Simple issue console command method. Does not accept parameters, so all defaults on the z/OSMF API are taken.
     * @static
     * @param session representing connection to this api
     * @param theCommand command to issue
     * @return command response on resolve, see [IConsoleResponse]
     * @memberof IssueCommand
     */
    fun issueSimple(session: AbstractSession, theCommand: String): Promise<IConsoleResponse>

    /**
     * Issue an MVS console command command synchronously - meaning solicited (direct command responses) are gathered
     * immediately after the command is issued. However, after (according to the z/OSMF REST API documentation)
     * approximately 3 seconds the response will be returned.
     *
     * To control additional collection and other behaviors, populate the ICollectParms object according
     * to your needs (see ICollectParms for details).
     * @static
     * @param session representing connection to this api
     * @param issueParms console issue parameters, see [IIssueParms]
     * @param collectParms console collect parameters, see [ICollectParms]
     * @return command response on resolve, see [IConsoleResponse]
     * @memberof IssueCommand
     */
    fun issueAndCollect(
      session: AbstractSession,
      issueParms: IIssueParms,
      collectParms: ICollectParms
    ): Promise<IConsoleResponse>

    /**
     * Get resource path for issue command
     * @static
     * @param consoleName name of the EMCS console that is used to issue the command
     * @return resource path
     * @memberof IssueCommand
     */
    fun getResource(consoleName: String): String

    /**
     * Build IZosmfIssueParms object from provided parameters
     * @static
     * @param parms parameters for issue command
     * @return request body, see [ZosmfConsoleApiParameters]
     * @memberof IssueCommand
     */
    fun buildZosmfConsoleApiParameters(parms: IIssueParms): IZosmfIssueParms
  }
}
